package at.qualisign.persistence

import at.qualisign.domain.PakkageMetricsJHawk

import scala.concurrent.Future

trait PakkageMetricsRepository {
  def save(metrics: PakkageMetricsJHawk): Future[Unit]
  def saveAll(metrics: Seq[PakkageMetricsJHawk]): Future[Unit]
}
