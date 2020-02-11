package at.qualisign.patterns

import at.qualisign.domain.Project
import at.qualisign.domain.extensions.ProjectExtensions._
import at.qualisign.patterns.exceptions.PatternPersistenceException

import scala.concurrent.Future

class MavenProjectPatternPersistenceImpl(
  reader: SsaPatternReader,
  writer: SsaPatternPersistence,
) extends MavenProjectPatternPersistence {
  override def persistProjectPatterns(project: Project): Future[Unit] = {
    try {
      writer.persistPatterns(project, reader.readPatterns(project.patternsFile))
    } catch {
      case exception: Exception => throw new PatternPersistenceException(exception)
    }
  }
}
