package at.qualisign.version

import at.qualisign.domain.Project

import scala.concurrent.Future

trait MavenProjectJavaVersionPersistence {
  def persistProjectJavaVersion(project: Project): Future[Project]
}
