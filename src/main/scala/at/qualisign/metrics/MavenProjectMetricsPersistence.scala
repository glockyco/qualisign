package at.qualisign.metrics

import at.qualisign.domain.Project

import scala.concurrent.Future

trait MavenProjectMetricsPersistence {
  def persistProjectMetrics(project: Project): Future[Unit]
}
