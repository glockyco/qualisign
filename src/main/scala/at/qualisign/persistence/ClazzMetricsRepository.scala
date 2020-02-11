package at.qualisign.persistence

import at.qualisign.domain.ClazzMetrics

import scala.concurrent.Future

trait ClazzMetricsRepository {
  def save(metrics: ClazzMetrics): Future[Unit]
  def saveAll(metrics: Seq[ClazzMetrics]): Future[Unit]
}
