package at.qualisign.app.processing

import at.qualisign.domain.ProcessingStatus.{FAILED, PENDING, SUCCEEDED}
import at.qualisign.domain.Project
import at.qualisign.metrics.MavenProjectMetricsCalculator

class MetricsCalculationStep(
  calculator: MavenProjectMetricsCalculator,
) extends ProcessingStep {
  override def execute(project: Project): Either[(Project, Exception), Project] = {
    try {
      calculator.calculateProjectMetrics(project)
      Right(project.copy(metricsCalculationStatus = SUCCEEDED))
    } catch {
      case exception: Exception =>
        Left(project.copy(metricsCalculationStatus = FAILED), exception)
    }
  }

  override def isPending(project: Project): Boolean = {
    project.metricsCalculationStatus == PENDING
  }
}
