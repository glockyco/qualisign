package at.qualisign.patterns

import at.qualisign.domain.Project
import at.qualisign.patterns.jaxb.SystemType

import scala.concurrent.Future

trait SsaPatternPersistence {
  def persistPatterns(project: Project, systemType: SystemType): Future[Unit]
}
