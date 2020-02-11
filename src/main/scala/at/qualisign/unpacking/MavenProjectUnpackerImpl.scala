package at.qualisign.unpacking

import java.io.File

import at.qualisign.domain.Project
import at.qualisign.domain.extensions.ProjectExtensions._
import at.qualisign.unpacking.exceptions.UnpackingException

class MavenProjectUnpackerImpl(unpacker: JarUnpacker)
  extends MavenProjectUnpacker {

  override def unpackProject(project: Project): Unit = {
    try {
      project.sourcesDirectory.mkdirs()
      project.binariesDirectory.mkdirs()

      unpackSourcesJar(project)
      unpackBinariesJar(project)
    } catch {
      case exception: Exception => throw new UnpackingException(exception)
    }
  }

  private def unpackSourcesJar(project: Project): Unit = {
    val from: File = project.sourcesJarFile
    val to: File = project.sourcesDirectory
    unpacker.unpack(from, to)
  }

  private def unpackBinariesJar(project: Project): Unit = {
    val from: File = project.binariesJarFile
    val to: File = project.binariesDirectory
    unpacker.unpack(from, to)
  }
}
