package at.qualisign.app.processing

import at.qualisign.core.exec.TimeoutException
import at.qualisign.domain.ProcessingStatus.{FAILED, SUCCEEDED, TIMEOUT_EXCEEDED}
import at.qualisign.domain.Project
import at.qualisign.patterns.MavenProjectPatternDetector
import at.qualisign.patterns.exceptions.PatternDetectionException

class PatternDetectionStep(
  detector: MavenProjectPatternDetector,
) extends ProcessingStep {
  override def execute(project: Project): Either[(Project, Exception), Project] = {
    try {
      detector.detectProjectPatterns(project)
      Right(project.copy(patternDetectionStatus =  SUCCEEDED))
    } catch {
      case exception: PatternDetectionException =>
        exception.getNestedException match {
          case _: TimeoutException =>
            Left(project.copy(patternDetectionStatus = TIMEOUT_EXCEEDED), exception)
          case _ =>
            Left(project.copy(patternDetectionStatus = FAILED), exception)
        }
      case exception: Exception =>
        Left(project.copy(patternDetectionStatus =  FAILED), exception)
    }
  }

  override def status(project: Project): Int = {
    project.patternDetectionStatus
  }
}
