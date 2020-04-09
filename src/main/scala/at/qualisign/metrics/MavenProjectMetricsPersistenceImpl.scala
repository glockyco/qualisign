package at.qualisign.metrics

import at.qualisign.domain.Project
import at.qualisign.domain.extensions.ProjectExtensions._
import at.qualisign.metrics.exceptions.MetricsPersistenceException
import at.qualisign.metrics.jhawk.{JHawkMetricsPersistence, JHawkMetricsReader}

import scala.concurrent.Future

class MavenProjectMetricsPersistenceImpl(
  reader: JHawkMetricsReader,
  writer: JHawkMetricsPersistence
) extends MavenProjectMetricsPersistence {
  override def persistProjectMetrics(project: Project): Future[Unit] = {
    try {
      writer.persistMetrics(project, reader.readMetrics(project.metricsFile))
    } catch {
      case exception: Exception => throw new MetricsPersistenceException(exception)
    }
  }
}
