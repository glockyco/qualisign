package at.qualisign.metrics.ckjm

import at.qualisign.domain.Project
import at.qualisign.metrics.ckjm.jaxb.CkjmType

trait CkjmMetricsPersistence {
  def persistMetrics(project: Project, ckjmType: CkjmType): Unit
}
