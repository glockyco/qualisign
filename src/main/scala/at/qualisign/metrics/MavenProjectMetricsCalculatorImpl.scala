package at.qualisign.metrics

import java.io.File

import at.qualisign.domain.Project
import at.qualisign.domain.extensions.ProjectExtensions._
import at.qualisign.metrics.ckjm.CkjmMetricsCalculator
import at.qualisign.metrics.exceptions.MetricsCalculationException

class MavenProjectMetricsCalculatorImpl(
  ckjmCalculator: CkjmMetricsCalculator,
) extends MavenProjectMetricsCalculator {

  override def calculateProjectMetrics(project: Project): Unit = {
    try {
      project.metricsDirectory.mkdirs()

      calculateCkjmMetrics(project)
    } catch {
      case exception: Exception => throw new MetricsCalculationException(exception)
    }
  }

  private def calculateCkjmMetrics(project: Project): Unit = {
    val from: File = project.binariesJarFile
    val to: File = project.ckjmMetricsFile
    val error: File = project.ckjmErrorFile

    ckjmCalculator.calculateMetrics(from, to, error)
  }
}
