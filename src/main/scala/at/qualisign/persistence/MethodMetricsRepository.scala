package at.qualisign.persistence

import at.qualisign.domain.MethodMetrics

import scala.concurrent.Future

trait MethodMetricsRepository {
  def save(metrics: MethodMetrics): Future[Unit]
  def saveAll(metrics: Seq[MethodMetrics]): Future[Unit]
}
