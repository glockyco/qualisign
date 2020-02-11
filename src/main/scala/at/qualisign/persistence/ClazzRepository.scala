package at.qualisign.persistence

import at.qualisign.domain.Clazz

import scala.concurrent.Future

trait ClazzRepository {
  def save(clazz: Clazz): Future[Unit]
  def saveAll(clazzes: Seq[Clazz]): Future[Unit]
}
