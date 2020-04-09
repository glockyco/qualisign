package at.qualisign.metrics.ckjm

import at.qualisign.domain.Project
import at.qualisign.metrics.ckjm.jaxb.CkjmType

import scala.concurrent.Future

trait CkjmMetricsPersistence {
  def persistMetrics(project: Project, ckjmType: CkjmType): Future[Unit]
}
