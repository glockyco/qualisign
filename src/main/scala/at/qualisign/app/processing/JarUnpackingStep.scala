package at.qualisign.app.processing

import at.qualisign.core.exec.TimeoutException
import at.qualisign.domain.ProcessingStatus.{FAILED, PENDING, SUCCEEDED, TIMEOUT_EXCEEDED}
import at.qualisign.domain.Project
import at.qualisign.unpacking.MavenProjectUnpacker
import at.qualisign.unpacking.exceptions.UnpackingException

class JarUnpackingStep(
  unpacker: MavenProjectUnpacker,
) extends ProcessingStep {
  override def execute(project: Project): Either[(Project, Exception), Project] = {
    try {
      unpacker.unpackProject(project)
      Right(project.copy(jarUnpackingStatus = SUCCEEDED))
    } catch {
      case exception: UnpackingException =>
        exception.getNestedException match {
          case _: TimeoutException =>
            Left(project.copy(jarUnpackingStatus = TIMEOUT_EXCEEDED), exception)
          case _ =>
            Left(project.copy(jarUnpackingStatus = FAILED), exception)
        }
      case exception: Exception =>
        Left(project.copy(jarUnpackingStatus = FAILED), exception)
    }
  }

  override def status(project: Project): Int = {
    project.jarUnpackingStatus
  }
}
