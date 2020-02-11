package at.qualisign.patterns

import java.io.File

import at.qualisign.domain.Project
import at.qualisign.domain.extensions.ProjectExtensions._
import at.qualisign.patterns.exceptions.PatternDetectionException

class MavenProjectPatternDetectorImpl(detector: SsaPatternDetector)
  extends MavenProjectPatternDetector {

  override def detectProjectPatterns(project: Project): Unit = {
    project.patternsDirectory.mkdirs()

    try {
      detectPatterns(project)
    } catch {
      case exception: Exception => throw new PatternDetectionException(exception)
    }
  }

  private def detectPatterns(project: Project): Unit = {
    val from: File = project.binariesDirectory
    val to: File = project.patternsFile
    detector.detectPatterns(from, to)
  }
}
