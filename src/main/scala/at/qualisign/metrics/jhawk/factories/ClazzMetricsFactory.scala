package at.qualisign.metrics.jhawk.factories

import at.qualisign.domain.{Clazz, ClazzMetrics}
import at.qualisign.metrics.jhawk.jaxb.ClassMetricsType

object ClazzMetricsFactory {
  def create(clazz: Clazz, classMetricsType: ClassMetricsType): ClazzMetrics = {
    ClazzMetrics(
      clazz.name,
      classMetricsType.getAvcc,
      classMetricsType.getCbo.intValue,
      classMetricsType.getCoh,
      classMetricsType.getCumulativeNumberOfCommentLines.intValue,
      classMetricsType.getCumulativeNumberOfComments.intValue,
      classMetricsType.getDit.intValue,
      classMetricsType.getFanIn.intValue,
      classMetricsType.getFanOut.intValue,
      classMetricsType.getHalsteadCumulativeBugs,
      classMetricsType.getHalsteadCumulativeLength.intValue,
      classMetricsType.getHalsteadCumulativeVolume,
      classMetricsType.getHalsteadEffort,
      classMetricsType.getLcom,
      classMetricsType.getLcom2,
      classMetricsType.getLoc.intValue,
      classMetricsType.getMaintainabilityIndex,
      classMetricsType.getMaintainabilityIndexNC,
      classMetricsType.getMaxcc.intValue,
      classMetricsType.getMessagePassingCoupling.intValue,
      classMetricsType.getNumberOfCommands.intValue,
      classMetricsType.getNumberOfMethods.intValue,
      classMetricsType.getNumberOfQueries.intValue,
      classMetricsType.getNumberOfStatements.intValue,
      classMetricsType.getNumberOfSubclasses.intValue,
      classMetricsType.getNumberOfSuperclasses.intValue,
      classMetricsType.getResponseForClass.intValue,
      classMetricsType.getReuseRatio,
      classMetricsType.getREVF,
      classMetricsType.getSix,
      classMetricsType.getSpecializationRatio,
      classMetricsType.getTcc.intValue,
      classMetricsType.getUnweightedClassSize.intValue,
    )
  }
}
