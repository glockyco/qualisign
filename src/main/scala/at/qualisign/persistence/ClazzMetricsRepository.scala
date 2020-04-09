package at.qualisign.persistence

import at.qualisign.domain.ClazzMetricsJHawk

import scala.concurrent.Future

trait ClazzMetricsRepository {
  def save(metrics: ClazzMetricsJHawk): Future[Unit]
  def saveAll(metrics: Seq[ClazzMetricsJHawk]): Future[Unit]
}
