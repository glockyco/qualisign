package at.qualisign.app.processing

import at.qualisign.domain.ProcessingStatus.{FAILED, PENDING, SUCCEEDED}
import at.qualisign.domain.Project
import at.qualisign.patterns.MavenProjectPatternDetector

class PatternDetectionStep(
  detector: MavenProjectPatternDetector,
) extends ProcessingStep {
  override def execute(project: Project): Either[(Project, Exception), Project] = {
    try {
      detector.detectProjectPatterns(project)
      Right(project.copy(patternDetectionStatus =  SUCCEEDED))
    } catch {
      case exception: Exception =>
        Left(project.copy(patternDetectionStatus =  FAILED), exception)
    }
  }

  override def isPending(project: Project): Boolean = {
    project.patternDetectionStatus == PENDING
  }
}
