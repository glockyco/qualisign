package at.qualisign.persistence

import at.qualisign.domain.ProjectMetrics

import scala.concurrent.Future

trait ProjectMetricsRepository {
  def save(metrics: ProjectMetrics): Future[Unit]
  def saveAll(metrics: Seq[ProjectMetrics]): Future[Unit]
}
