package at.qualisign.languages

import java.io.File

import at.qualisign.domain.Project
import at.qualisign.domain.extensions.ProjectExtensions._
import at.qualisign.languages.exceptions.LanguageDetectionException

class MavenProjectLanguageDetectorImpl(detector: EnryLanguageDetector)
  extends MavenProjectLanguageDetector {

  override def detectProjectLanguages(project: Project): Unit = {
    try {
      project.languagesDirectory.mkdirs()

      detectLanguages(project)
    } catch {
      case exception: Exception => throw new LanguageDetectionException(exception)
    }
  }

  private def detectLanguages(project: Project): Unit = {
    val from: File = project.sourcesDirectory
    val to: File = project.languagesFile
    detector.detectLanguages(from, to)
  }
}
