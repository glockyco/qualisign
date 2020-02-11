package at.qualisign.persistence

import at.qualisign.domain.Project

import scala.concurrent.Future

trait ProjectRepository {
  def save(project: Project): Future[Unit]
  def saveAll(projects: Seq[Project]): Future[Unit]
  def readAllWithSources(): Future[Seq[Project]]
  def insertIfNotExists(projects: Seq[Project]): Future[Unit]
}
