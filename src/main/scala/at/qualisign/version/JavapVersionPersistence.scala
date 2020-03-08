package at.qualisign.version

import at.qualisign.domain.Project

import scala.concurrent.Future

trait JavapVersionPersistence {
  def persistJavaVersion(project: Project, javaVersion: Int): Future[Project]
}
