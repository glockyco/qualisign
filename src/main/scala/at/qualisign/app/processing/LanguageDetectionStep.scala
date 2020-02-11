package at.qualisign.app.processing

import at.qualisign.domain.ProcessingStatus.{FAILED, PENDING, SUCCEEDED}
import at.qualisign.domain.Project
import at.qualisign.languages.MavenProjectLanguageDetector

class LanguageDetectionStep(
  detector: MavenProjectLanguageDetector,
) extends ProcessingStep {
  override def execute(project: Project): Either[(Project, Exception), Project] = {
    try {
      detector.detectProjectLanguages(project)
      Right(project.copy(languageDetectionStatus = SUCCEEDED))
    } catch {
      case exception: Exception =>
        Left(project.copy(languageDetectionStatus = FAILED), exception)
    }
  }

  override def isPending(project: Project): Boolean = {
    project.languageDetectionStatus == PENDING
  }
}
