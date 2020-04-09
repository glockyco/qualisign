package at.qualisign.metrics

import java.io.File

import at.qualisign.domain.Project
import at.qualisign.domain.extensions.ProjectExtensions._
import at.qualisign.metrics.exceptions.MetricsCalculationException
import at.qualisign.metrics.jhawk.JHawkMetricsCalculator

class MavenProjectMetricsCalculatorImpl(calculator: JHawkMetricsCalculator)
  extends MavenProjectMetricsCalculator {

  override def calculateProjectMetrics(project: Project): Unit = {
    try {
      project.metricsDirectory.mkdirs()

      calculateMetrics(project)
    } catch {
      case exception: Exception => throw new MetricsCalculationException(exception)
    }
  }

  private def calculateMetrics(project: Project): Unit = {
    val from: File = project.sourcesDirectory
    val to: File = project.metricsFile
    calculator.calculateMetrics(from, to)
  }
}
