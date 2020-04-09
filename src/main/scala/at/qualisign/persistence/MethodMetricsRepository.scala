package at.qualisign.persistence

import at.qualisign.domain.MethodMetricsJHawk

import scala.concurrent.Future

trait MethodMetricsRepository {
  def save(metrics: MethodMetricsJHawk): Future[Unit]
  def saveAll(metrics: Seq[MethodMetricsJHawk]): Future[Unit]
}
