package at.qualisign.metrics.jhawk.factories

import at.qualisign.domain.{Pakkage, PakkageMetrics}
import at.qualisign.metrics.jhawk.jaxb.PackageMetricsType

object PakkageMetricsFactory {
  def create(pakkage: Pakkage, packageMetricsType: PackageMetricsType): PakkageMetrics = {
    PakkageMetrics(
      pakkage.name,
      packageMetricsType.getAbstractness,
      packageMetricsType.getAvcc,
      packageMetricsType.getCumulativeNumberOfCommentLines.intValue,
      packageMetricsType.getCumulativeNumberOfComments.intValue,
      packageMetricsType.getDistance,
      packageMetricsType.getFanin.intValue,
      packageMetricsType.getFanout.intValue,
      packageMetricsType.getHalsteadCumulativeBugs,
      packageMetricsType.getHalsteadCumulativeLength.intValue,
      packageMetricsType.getHalsteadCumulativeVolume,
      packageMetricsType.getHalsteadEffort,
      packageMetricsType.getInstability,
      packageMetricsType.getLoc.intValue,
      packageMetricsType.getMaintainabilityIndex,
      packageMetricsType.getMaintainabilityIndexNC,
      packageMetricsType.getMaxcc.intValue,
      packageMetricsType.getNumberOfClasses.intValue,
      packageMetricsType.getNumberOfMethods.intValue,
      packageMetricsType.getNumberOfStatements.intValue,
      packageMetricsType.getRVF.intValue,
      packageMetricsType.getTcc.intValue,
    )
  }
}
