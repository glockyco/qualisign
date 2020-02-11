package at.qualisign.metrics

import at.qualisign.domain.Project
import at.qualisign.metrics.jaxb.SystemType

import scala.concurrent.Future

trait JHawkMetricsPersistence {
  def persistMetrics(project: Project, systemType: SystemType): Future[Unit]
}
