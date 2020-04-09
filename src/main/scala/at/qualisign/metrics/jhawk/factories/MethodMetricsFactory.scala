package at.qualisign.metrics.jhawk.factories

import at.qualisign.domain.{Method, MethodMetrics}
import at.qualisign.metrics.jhawk.jaxb.MethodMetricsType

object MethodMetricsFactory {
  def create(method: Method, methodMetricsType: MethodMetricsType): MethodMetrics = {
    MethodMetrics(
      method.name,
      methodMetricsType.getCyclomaticComplexity.intValue,
      methodMetricsType.getHalsteadBugs,
      methodMetricsType.getHalsteadDifficulty,
      methodMetricsType.getHalsteadEffort,
      methodMetricsType.getHalsteadLength.intValue,
      methodMetricsType.getHalsteadVocabulary.intValue,
      methodMetricsType.getHalsteadVolume,
      methodMetricsType.getLoc.intValue,
      methodMetricsType.getMaxDepthOfNesting.intValue,
      methodMetricsType.getNumberOfArguments.intValue,
      methodMetricsType.getNumberOfCasts.intValue,
      methodMetricsType.getNumberOfCommentLines.intValue,
      methodMetricsType.getNumberOfComments.intValue,
      methodMetricsType.getNumberOfExpressions.intValue,
      methodMetricsType.getNumberOfLoops.intValue,
      methodMetricsType.getNumberOfOperands.intValue,
      methodMetricsType.getNumberOfOperators.intValue,
      methodMetricsType.getNumberOfStatements.intValue,
      methodMetricsType.getNumberOfVariableDeclarations.intValue,
      methodMetricsType.getNumberOfVariableReferences.intValue,
      methodMetricsType.getTotalNesting.intValue,
    )
  }
}
