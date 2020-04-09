package at.qualisign.persistence

import at.qualisign.domain.ProjectMetricsJHawk

import scala.concurrent.Future

trait ProjectMetricsRepository {
  def save(metrics: ProjectMetricsJHawk): Future[Unit]
  def saveAll(metrics: Seq[ProjectMetricsJHawk]): Future[Unit]
}
