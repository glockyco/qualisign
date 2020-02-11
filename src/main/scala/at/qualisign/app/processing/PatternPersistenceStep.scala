package at.qualisign.app.processing

import at.qualisign.domain.ProcessingStatus.{FAILED, PENDING, SUCCEEDED}
import at.qualisign.domain.Project
import at.qualisign.patterns.MavenProjectPatternPersistence

class PatternPersistenceStep(
  persistence: MavenProjectPatternPersistence,
) extends ProcessingStep {
  override def execute(project: Project): Either[(Project, Exception), Project] = {
    try {
      persistence.persistProjectPatterns(project)
      Right(project.copy(patternPersistenceStatus = SUCCEEDED))
    } catch {
      case exception: Exception =>
        Left(project.copy(patternPersistenceStatus = FAILED), exception)
    }
  }

  override def isPending(project: Project): Boolean = {
    project.patternPersistenceStatus == PENDING
  }
}
