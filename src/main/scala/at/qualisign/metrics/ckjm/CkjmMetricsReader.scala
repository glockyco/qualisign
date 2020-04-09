package at.qualisign.metrics.ckjm

import java.io.File

import at.qualisign.metrics.ckjm.jaxb.CkjmType

trait CkjmMetricsReader {
  def readMetrics(from: File): CkjmType
}
