package at.qualisign.app.processing

import at.qualisign.domain.ProcessingStatus.{FAILED, PENDING, SUCCEEDED}
import at.qualisign.domain.Project
import at.qualisign.languages.MavenProjectLanguagePersistence

class LanguagePersistenceStep(
  persistence: MavenProjectLanguagePersistence,
) extends ProcessingStep {
  override def execute(project: Project): Either[(Project, Exception), Project] = {
    try {
      persistence.persistProjectLanguages(project)
      Right(project.copy(languagePersistenceStatus = SUCCEEDED))
    } catch {
      case exception: Exception =>
        Left(project.copy(languagePersistenceStatus = FAILED), exception)
    }
  }

  override def isPending(project: Project): Boolean = {
    project.languagePersistenceStatus == PENDING
  }
}
