package at.qualisign.app

import at.qualisign.app.processing._
import at.qualisign.core.exec._
import at.qualisign.domain.Project
import at.qualisign.downloading._
import at.qualisign.indexing._
import at.qualisign.languages._
import at.qualisign.metrics._
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

  val jHawkCalculator: JHawkMetricsCalculator = new JHawkMetricsCalculatorImpl(executor)
  val metricsCalculator: MavenProjectMetricsCalculator = new MavenProjectMetricsCalculatorImpl(jHawkCalculator)

  val jHawkReader: JHawkMetricsReader = new JHawkMetricsReaderImpl
  val jHawkPersistence: JHawkMetricsPersistence = new JHawkMetricsPersistenceImpl(database)
  val metricsPersistence: MavenProjectMetricsPersistence = new MavenProjectMetricsPersistenceImpl(jHawkReader, jHawkPersistence)

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

  // @TODO: gracefully handle missing JHawk command line tool

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

  val batchSize = 100
  val slice = 0

  print("Reading projects...")
  val projects: Seq[Project] = Await.result(projectRepository.readAllWithSources(), Duration.Inf).slice(slice * batchSize, (slice + 1) * batchSize)
  println("done!")

  processor.processProjects(projects)
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
  def processProjects(projects: Seq[Project]): Seq[Try[Unit]] = {
    projects.zipWithIndex.par.map(e => processProject(e._1, e._2)).seq
  }

  def processProject(project: Project, index: Int): Try[Unit] = {
    var p: Project = project
    val steps: Seq[ProcessingStep] = processingSteps.filter(step => step.status(project) == ProcessingStatus.PENDING)

    for (step: ProcessingStep <- steps) {
      val result: Either[(Project, Exception), Project] = step.execute(p)

      result match {
        case Right(processedProject) =>
          p = processedProject
          Await.ready(projectRepository.save(p), Duration.Inf)

        case Left((processedProject, exception)) =>
          p = processedProject
          Await.ready(projectRepository.save(p), Duration.Inf)
          println(s"Error ($index): ${p.name}, $exception")
          return Failure(exception)
      }
    }

    println(s"Success ($index): ${project.name}")
    Success()
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
