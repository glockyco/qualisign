package at.qualisign.patterns

import at.qualisign.domain.Project

import scala.concurrent.Future

trait MavenProjectPatternPersistence {
  def persistProjectPatterns(project: Project): Future[Unit]
}
