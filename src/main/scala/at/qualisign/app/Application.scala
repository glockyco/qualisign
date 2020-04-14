package at.qualisign.app

import at.qualisign.app.processing._
import at.qualisign.core.exec._
import at.qualisign.domain.{ProcessingStatus, Project}
import at.qualisign.downloading._
import at.qualisign.indexing._
import at.qualisign.languages._
import at.qualisign.metrics._
import at.qualisign.metrics.ckjm._
import at.qualisign.patterns._
import at.qualisign.persistence.ProjectRepository
import at.qualisign.persistence.postgresql.PostgresProjectRepository
import at.qualisign.unpacking._
import at.qualisign.version._
import slick.jdbc.PostgresProfile.api._

import scala.collection.parallel.CollectionConverters._
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success, Try}

object Application extends App {

  // --- Utils ---

  val database: Database = Database.forConfig("postgres")

  val executor: CommandLineExecutor = new CommandLineExecutorImpl

  // --- Project Retrieval ---

  val configuration: MavenIndexConfiguration = new MavenIndexConfigurationImpl
  val updater: MavenIndexUpdater = new MavenIndexUpdaterImpl(configuration)
  val reader: MavenIndexReader = new MavenIndexReaderImpl(configuration)

  val projectRepository: ProjectRepository = new PostgresProjectRepository(database)

  val fileDownloader: FileDownloader = new FileDownloaderImpl
  val downloader: MavenProjectDownloader = new MavenProjectDownloaderImpl(fileDownloader)

  val jarUnpacker: JarUnpacker = new JarUnpackerImpl(executor)
  val unpacker: MavenProjectUnpacker = new MavenProjectUnpackerImpl(jarUnpacker)

  // --- Java Version Detection ---

  val javapDetector: JavapVersionDetector = new JavapVersionDetectorImpl(executor)
  val javaVersionDetector: MavenProjectJavaVersionDetector = new MavenProjectJavaVersionDetectorImpl(javapDetector)

  val javapVersionReader: JavapVersionReader = new JavapVersionReaderImpl
  val javapVersionPersistence: JavapVersionPersistence = new JavapVersionPersistenceImpl(database)
  val javaVersionPersistence: MavenProjectJavaVersionPersistence = new MavenProjectJavaVersionPersistenceImpl(javapVersionReader, javapVersionPersistence)

  // --- Programming Language Detection ---

  val enryDetector: EnryLanguageDetector = new EnryLanguageDetectorImpl(executor)
  val languageDetector: MavenProjectLanguageDetector = new MavenProjectLanguageDetectorImpl(enryDetector)

  val enryReader: EnryLanguageReader = new EnryLanguageReaderImpl
  val enryPersistence: EnryLanguagePersistence = new EnryLanguagePersistenceImpl(database)
  val languagePersistence: MavenProjectLanguagePersistence = new MavenProjectLanguagePersistenceImpl(enryReader, enryPersistence)

  // --- Metrics Calculation ---

  val ckjmCalculator: CkjmMetricsCalculator = new CkjmMetricsCalculatorImpl(executor)
  val metricsCalculator: MavenProjectMetricsCalculator = new MavenProjectMetricsCalculatorImpl(ckjmCalculator)

  val ckjmReader: CkjmMetricsReader = new CkjmMetricsReaderImpl
  val ckjmPersistence: CkjmMetricsPersistence = new CkjmMetricsPersistenceImpl(database)
  val metricsPersistence: MavenProjectMetricsPersistence = new MavenProjectMetricsPersistenceImpl(ckjmReader, ckjmPersistence)

  // --- Design Pattern Detection ---

  val ssaDetector: SsaPatternDetector = new SsaPatternDetectorImpl(executor)
  val patternDetector: MavenProjectPatternDetector = new MavenProjectPatternDetectorImpl(ssaDetector)

  val ssaReader: SsaPatternReader = new SsaPatternReaderImpl
  val ssaPersistence: SsaPatternPersistence = new SsaPatternPersistenceImpl(database)
  val patternPersistence: MavenProjectPatternPersistence = new MavenProjectPatternPersistenceImpl(ssaReader, ssaPersistence)

  // --- Processor ---

  val processor = new ProjectProcessor(
    downloader,
    unpacker,
    languageDetector,
    languagePersistence,
    metricsCalculator,
    metricsPersistence,
    patternDetector,
    patternPersistence,
    javaVersionDetector,
    javaVersionPersistence,
    projectRepository,
  )

  // ---------------------------------------------------------------------------

  // @TODO: ignore non-java projects

  // @TODO: detect java version
  // @TODO: persist java version
  // @TODO: ignore non-java-8 projects

  // @TODO: remove old versions of projects if a new one is available

  // @TODO: mark projects with empty sources

  // @TODO: limit max processing time per project / processing step (< 1h metrics calculation?)

  // @TODO: log errors that happened during processing

  // @TODO: setup scalastyle

  // @TODO: rework error handling of failed database statements

  // --- Project Retrieval ---

  // @TODO: skip DB update if index update brought no new data

  print("Updating index...")
  updater.updateIndex()
  println("done!")

  print("Reading index...")
  val projectsInIndex = reader.readProjects()
  println("done!")

  print("Persisting projects...")
  Await.ready(projectRepository.insertIfNotExists(projectsInIndex), Duration.Inf)
  println("done!")

  processor.processProjects()
}

class ProjectProcessor(
  downloader: MavenProjectDownloader,
  unpacker: MavenProjectUnpacker,
  languageDetector: MavenProjectLanguageDetector,
  languagePersistence: MavenProjectLanguagePersistence,
  metricsCalculator: MavenProjectMetricsCalculator,
  metricsPersistence: MavenProjectMetricsPersistence,
  patternDetector: MavenProjectPatternDetector,
  patternPersistence: MavenProjectPatternPersistence,
  javaVersionDetector: MavenProjectJavaVersionDetector,
  javaVersionPersistence: MavenProjectJavaVersionPersistence,
  projectRepository: ProjectRepository,
) {
  def processProjects(): Unit = {
    def hasFailedProcessingSteps(project: Project): Boolean = {
      processingSteps.exists(step => step.status(project) == ProcessingStatus.FAILED)
    }

    print("Reading projects...")
    val projects: Seq[Project] = Await.result(projectRepository.readAllWithSources(), Duration.Inf).slice(0, 1000)
    println("done!")

    //--------------------------------------------------------------------------

    def time[R](block: => R): R = {
      val t0 = System.nanoTime()
      val result = block    // call-by-name
      val t1 = System.nanoTime()
      println("Elapsed time: " + (t1 - t0) + "ns")
      result
    }

    time { projects.par.foreach { project: Project =>
      if (hasFailedProcessingSteps(project)) {
        println(s"Skipped: ${project.name}")
      } else {
        (for (
          p1 <- executeProjectRetrieval(project);
          p2 <- executeJavaVersionDetection(p1);
          p3 <- executeProgrammingLanguageDetection(p2)
        ) yield p3) match {
          case Failure(exception) => println(s"Failure: ${project.name}\n$exception")
          case Success(_) => println(s"Success: ${project.name}")
        }
      }
    } }

    //--------------------------------------------------------------------------

    print("Reading eligible projects...")
    val eligibleProjects: Seq[Project] = Await.result(projectRepository.readEligibleForAnalysis(), Duration.Inf)
    println("done!")

    time { eligibleProjects.par.foreach { project: Project =>
      if (hasFailedProcessingSteps(project)) {
        println(s"Skipped: ${project.name}")
      } else {
        (for (
          p4 <- executeMetricsCalculation(project);
          p5 <- executePatternDetection(p4)
        ) yield p5) match {
          case Failure(exception) => println(s"Failure: ${project.name}\n$exception")
          case Success(_) => println(s"Success: ${project.name}")
        }
      }
    } }
  }

  def executeProjectRetrieval(project: Project): Try[Project] = {
    val steps = Seq(
      new JarDownloadStep(downloader),
      new JarUnpackingStep(unpacker),
    )

    executeSteps(project, steps)
  }

  def executeJavaVersionDetection(project: Project): Try[Project] = {
    val steps = Seq(
      new JavaVersionDetectionStep(javaVersionDetector),
      new JavaVersionPersistenceStep(javaVersionPersistence),
    )

    executeSteps(project, steps)
  }

  def executeProgrammingLanguageDetection(project: Project): Try[Project] = {
    val steps = Seq(
      new LanguageDetectionStep(languageDetector),
      new LanguagePersistenceStep(languagePersistence),
    )

    executeSteps(project, steps)
  }

  def executeMetricsCalculation(project: Project): Try[Project] = {
    val steps = Seq(
      new MetricsCalculationStep(metricsCalculator),
      new MetricsPersistenceStep(metricsPersistence),
    )

    executeSteps(project, steps)
  }

  def executePatternDetection(project: Project): Try[Project] = {
    val steps = Seq(
      new PatternDetectionStep(patternDetector),
      new PatternPersistenceStep(patternPersistence),
    )

    executeSteps(project, steps)
  }

  def executeSteps(project: Project, steps: Seq[ProcessingStep]): Try[Project] = {
    val filteredSteps = steps.filter(step => step.status(project) == ProcessingStatus.PENDING)
    var p: Project = project

    for (step: ProcessingStep <- filteredSteps) {
      val result: Either[(Project, Exception), Project] = step.execute(p)

      result match {
        case Right(processedProject) =>
          p = processedProject
          Await.ready(projectRepository.save(p), Duration.Inf)

        case Left((processedProject, exception)) =>
          p = processedProject
          Await.ready(projectRepository.save(p), Duration.Inf)
          return Failure(exception)
      }
    }

    Success(p)
  }

  def processingSteps: Seq[ProcessingStep] = {
    Seq(
      // --- Project Retrieval ---

      new JarDownloadStep(downloader),
      new JarUnpackingStep(unpacker),

      // --- Project/Package/Class/Method Persistence ---

      // @TODO: Extract PPCM persistence from metrics calculation.

      // --- Java Version Detection ---

      new JavaVersionDetectionStep(javaVersionDetector),
      new JavaVersionPersistenceStep(javaVersionPersistence),

      // --- Programming Language Detection ---

      new LanguageDetectionStep(languageDetector),
      new LanguagePersistenceStep(languagePersistence),

      // --- Metrics Calculation ---

      new MetricsCalculationStep(metricsCalculator),
      new MetricsPersistenceStep(metricsPersistence),

      // --- Pattern Detection ---

      new PatternDetectionStep(patternDetector),
      new PatternPersistenceStep(patternPersistence),
    )
  }
}
