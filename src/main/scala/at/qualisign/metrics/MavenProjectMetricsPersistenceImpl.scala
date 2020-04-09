package at.qualisign.metrics

import at.qualisign.domain.Project
import at.qualisign.domain.extensions.ProjectExtensions._
import at.qualisign.metrics.ckjm.{CkjmMetricsPersistence, CkjmMetricsReader}
import at.qualisign.metrics.exceptions.MetricsPersistenceException
import at.qualisign.metrics.jhawk.{JHawkMetricsPersistence, JHawkMetricsReader}

import scala.concurrent.Future

class MavenProjectMetricsPersistenceImpl(
  ckjmReader: CkjmMetricsReader,
  ckjmWriter: CkjmMetricsPersistence,
  jHawkReader: JHawkMetricsReader,
  jHawkWriter: JHawkMetricsPersistence,
) extends MavenProjectMetricsPersistence {
  override def persistProjectMetrics(project: Project): Future[Unit] = {
    try {
      ckjmWriter.persistMetrics(project, ckjmReader.readMetrics(project.ckjmMetricsFile))
      jHawkWriter.persistMetrics(project, jHawkReader.readMetrics(project.jHawkMetricsFile))
    } catch {
      case exception: Exception => throw new MetricsPersistenceException(exception)
    }
  }
}
