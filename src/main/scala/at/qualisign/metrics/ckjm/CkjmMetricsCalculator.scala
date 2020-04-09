package at.qualisign.metrics.ckjm

import java.io.File

trait CkjmMetricsCalculator {
  def calculateMetrics(from: File, to: File, error: File): Unit
}
