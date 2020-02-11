package at.qualisign.persistence

import at.qualisign.domain.PakkageMetrics

import scala.concurrent.Future

trait PakkageMetricsRepository {
  def save(metrics: PakkageMetrics): Future[Unit]
  def saveAll(metrics: Seq[PakkageMetrics]): Future[Unit]
}
