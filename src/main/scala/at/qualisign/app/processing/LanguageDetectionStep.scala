package at.qualisign.app.processing

import at.qualisign.core.exec.TimeoutException
import at.qualisign.domain.ProcessingStatus.{FAILED, SUCCEEDED, TIMEOUT_EXCEEDED}
import at.qualisign.domain.Project
import at.qualisign.languages.MavenProjectLanguageDetector
import at.qualisign.languages.exceptions.LanguageDetectionException

class LanguageDetectionStep(
  detector: MavenProjectLanguageDetector,
) extends ProcessingStep {
  override def execute(project: Project): Either[(Project, Exception), Project] = {
    try {
      detector.detectProjectLanguages(project)
      Right(project.copy(languageDetectionStatus = SUCCEEDED))
    } catch {
      case exception: LanguageDetectionException =>
        exception.getNestedException match {
          case _: TimeoutException =>
            Left(project.copy(languageDetectionStatus = TIMEOUT_EXCEEDED), exception)
          case _ =>
            Left(project.copy(languageDetectionStatus = FAILED), exception)
        }
      case exception: Exception =>
        Left(project.copy(languageDetectionStatus = FAILED), exception)
    }
  }

  override def status(project: Project): Int = {
    project.languageDetectionStatus
  }
}
