package at.qualisign.app.processing

import at.qualisign.domain.ProcessingStatus.{FAILED, PENDING, SUCCEEDED}
import at.qualisign.domain.Project
import at.qualisign.version.MavenProjectJavaVersionDetector

class JavaVersionDetectionStep(
  detector: MavenProjectJavaVersionDetector
) extends ProcessingStep {
  override def execute(project: Project): Either[(Project, Exception), Project] = {
    try {
      detector.detectProjectJavaVersion(project)
      Right(project.copy(javaVersionDetectionStatus = SUCCEEDED))
    } catch {
      case exception: Exception =>
        Left(project.copy(javaVersionDetectionStatus = FAILED), exception)
    }
  }

  override def isPending(project: Project): Boolean = {
    project.javaVersionDetectionStatus == PENDING
  }
}
