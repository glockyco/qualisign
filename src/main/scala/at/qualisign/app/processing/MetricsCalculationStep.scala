package at.qualisign.app.processing

import at.qualisign.core.exec.TimeoutException
import at.qualisign.domain.ProcessingStatus.{FAILED, SUCCEEDED, TIMEOUT_EXCEEDED}
import at.qualisign.domain.Project
import at.qualisign.metrics.MavenProjectMetricsCalculator
import at.qualisign.metrics.exceptions.MetricsCalculationException

class MetricsCalculationStep(
  calculator: MavenProjectMetricsCalculator,
) extends ProcessingStep {
  override def execute(project: Project): Either[(Project, Exception), Project] = {
    try {
      calculator.calculateProjectMetrics(project)
      Right(project.copy(metricsCalculationStatus = SUCCEEDED))
    } catch {
      case exception: MetricsCalculationException =>
        exception.getNestedException match {
          case _: TimeoutException =>
            Left(project.copy(metricsCalculationStatus = TIMEOUT_EXCEEDED), exception)
          case _ =>
            Left(project.copy(metricsCalculationStatus = FAILED), exception)
        }
      case exception: Exception =>
        Left(project.copy(metricsCalculationStatus = FAILED), exception)
    }
  }

  override def status(project: Project): Int = {
    project.metricsCalculationStatus
  }
}
