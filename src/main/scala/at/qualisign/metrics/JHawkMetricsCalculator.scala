package at.qualisign.metrics

import java.io.File

trait JHawkMetricsCalculator {
  def calculateMetrics(from: File, to: File) : Unit
}
