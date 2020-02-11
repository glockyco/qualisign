package at.qualisign.app.processing

import at.qualisign.domain.ProcessingStatus.{FAILED, PENDING, SUCCEEDED}
import at.qualisign.domain.Project
import at.qualisign.unpacking.MavenProjectUnpacker

class JarUnpackingStep(
  unpacker: MavenProjectUnpacker,
) extends ProcessingStep {
  override def execute(project: Project): Either[(Project, Exception), Project] = {
    try {
      unpacker.unpackProject(project)
      Right(project.copy(jarUnpackingStatus = SUCCEEDED))
    } catch {
      case exception: Exception =>
        Left(project.copy(jarUnpackingStatus = FAILED), exception)
    }
  }

  override def isPending(project: Project): Boolean = {
    project.jarUnpackingStatus == PENDING
  }
}
