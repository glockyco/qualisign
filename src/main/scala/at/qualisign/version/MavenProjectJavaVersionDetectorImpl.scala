package at.qualisign.version

import java.io.File
import java.nio.file.Files

import at.qualisign.domain.Project
import at.qualisign.domain.extensions.ProjectExtensions._
import at.qualisign.version.exceptions.JavaVersionDetectionException

class MavenProjectJavaVersionDetectorImpl(detector: JavapVersionDetector)
  extends MavenProjectJavaVersionDetector {

  override def detectProjectJavaVersion(project: Project): Unit = {
    try {
      detectJavaVersion(project)
    } catch {
      case exception: Exception => throw new JavaVersionDetectionException(exception)
    }
  }

  private def detectJavaVersion(project: Project): Unit = {
    val classPaths = Files.walk(project.binariesDirectory.toPath).filter(_.toString.endsWith(".class"))
    val from: File = classPaths.findFirst().get().toFile
    val to: File = project.javaVersionFile
    detector.detectJavaVersion(from, to)
  }
}
