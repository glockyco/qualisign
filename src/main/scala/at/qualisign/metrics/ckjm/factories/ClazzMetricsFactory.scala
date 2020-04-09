package at.qualisign.metrics.ckjm.factories

import at.qualisign.domain.{Clazz, ClazzMetricsCkjm}
import at.qualisign.metrics.ckjm.jaxb.ClassType

object ClazzMetricsFactory {
  def create(clazz: Clazz, classType: ClassType): ClazzMetricsCkjm = {
    ClazzMetricsCkjm(
      clazz.name,
      classType.getAmc,
      classType.getCa.intValue,
      classType.getCam,
      classType.getCbm.intValue,
      classType.getCbo.intValue,
      classType.getCe.intValue,
      classType.getDam,
      classType.getDit.intValue,
      classType.getIc.intValue,
      classType.getLcom.intValue,
      classType.getLcom3,
      classType.getLoc.intValue,
      classType.getMfa,
      classType.getMoa.intValue,
      classType.getNoc.intValue,
      classType.getNpm.intValue,
      classType.getRfc.intValue,
      classType.getWmc.intValue,
    )
  }
}
