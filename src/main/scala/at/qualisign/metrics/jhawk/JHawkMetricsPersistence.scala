package at.qualisign.metrics.jhawk

import at.qualisign.domain.Project
import at.qualisign.metrics.jhawk.jaxb.SystemType

import scala.concurrent.Future

trait JHawkMetricsPersistence {
  def persistMetrics(project: Project, systemType: SystemType): Future[Unit]
}
