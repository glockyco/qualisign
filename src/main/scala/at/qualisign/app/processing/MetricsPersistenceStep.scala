package at.qualisign.app.processing

import at.qualisign.domain.ProcessingStatus.{FAILED, PENDING, SUCCEEDED}
import at.qualisign.domain.Project
import at.qualisign.metrics.MavenProjectMetricsPersistence

class MetricsPersistenceStep(
  persistence: MavenProjectMetricsPersistence,
) extends ProcessingStep {
  override def execute(project: Project): Either[(Project, Exception), Project] = {
    try {
      persistence.persistProjectMetrics(project)
      Right(project.copy(metricsPersistenceStatus = SUCCEEDED))
    } catch {
      case exception: Exception =>
        Left(project.copy(metricsPersistenceStatus = FAILED), exception)
    }
  }

  override def status(project: Project): Int = {
    project.metricsPersistenceStatus
  }
}
