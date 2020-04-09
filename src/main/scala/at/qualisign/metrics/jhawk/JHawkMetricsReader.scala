package at.qualisign.metrics.jhawk

import java.io.File

import at.qualisign.metrics.jhawk.jaxb.SystemType

trait JHawkMetricsReader {
  def readMetrics(from: File): SystemType
}
