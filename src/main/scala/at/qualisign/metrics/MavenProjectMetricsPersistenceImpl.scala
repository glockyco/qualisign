package at.qualisign.metrics

import at.qualisign.domain.Project
import at.qualisign.domain.extensions.ProjectExtensions._
import at.qualisign.metrics.ckjm.{CkjmMetricsPersistence, CkjmMetricsReader}
import at.qualisign.metrics.exceptions.MetricsPersistenceException

import scala.concurrent.Future

class MavenProjectMetricsPersistenceImpl(
  ckjmReader: CkjmMetricsReader,
  ckjmWriter: CkjmMetricsPersistence,
) extends MavenProjectMetricsPersistence {
  override def persistProjectMetrics(project: Project): Future[Unit] = {
    try {
      ckjmWriter.persistMetrics(project, ckjmReader.readMetrics(project.ckjmMetricsFile))
    } catch {
      case exception: Exception => throw new MetricsPersistenceException(exception)
    }
  }
}
