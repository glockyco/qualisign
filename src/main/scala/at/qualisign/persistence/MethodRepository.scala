package at.qualisign.persistence

import at.qualisign.domain.Method

import scala.concurrent.Future

trait MethodRepository {
  def save(method: Method): Future[Unit]
  def saveAll(methods: Seq[Method]): Future[Unit]
}
