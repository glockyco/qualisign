package at.qualisign.persistence

import at.qualisign.domain.Pakkage

import scala.concurrent.Future

trait PakkageRepository {
  def save(pakkage: Pakkage): Future[Unit]
  def saveAll(pakkages: Seq[Pakkage]): Future[Unit]
}
