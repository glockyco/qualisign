package at.qualisign.metrics.ckjm.factories

import at.qualisign.domain.{Method, MethodMetricsCkjm}
import at.qualisign.metrics.ckjm.jaxb.MethodType

object MethodMetricsFactory {
  def create(method: Method, methodType: MethodType): MethodMetricsCkjm = {
    MethodMetricsCkjm(
      method.name,
      methodType.getValue.intValue,
    )
  }
}
