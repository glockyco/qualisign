package at.qualisign.metrics.ckjm.factories

import at.qualisign.domain.{Clazz, ClazzMetricsCkjm, Method, MethodMetricsCkjm}
import at.qualisign.metrics.ckjm.jaxb.ClassType

object ClazzMetricsFactory {
  def create(
    clazz: Clazz,
    classType: ClassType,
    methods: Seq[Method],
    methodMetrics: Seq[MethodMetricsCkjm]
  ): ClazzMetricsCkjm = {
    ClazzMetricsCkjm(
      clazz.name,
      classType.getAmc,
      classType.getCa.intValue,
      classType.getCam,
      classType.getCbm.intValue,
      classType.getCbo.intValue,
      methodMetrics.foldLeft(0)(_ + _.cc),
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
      methods.length,
      methods.count(m => m.accessModifier != "private"),
      classType.getNpm.intValue,
      classType.getRfc.intValue,
      classType.getWmc.intValue,
    )
  }
}
