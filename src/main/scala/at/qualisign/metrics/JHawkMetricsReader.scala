package at.qualisign.metrics

import java.io.File

import at.qualisign.metrics.jaxb.SystemType

trait JHawkMetricsReader {
  def readMetrics(from: File): SystemType
}
