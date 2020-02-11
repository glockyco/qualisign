package at.qualisign.metrics.factories

import at.qualisign.domain.{Clazz, Method}
import at.qualisign.metrics.jaxb.MethodType

import scala.jdk.CollectionConverters._

object MethodFactory {
  def create(clazz: Clazz, methodType: MethodType): Method = {
    val arguments = Option(methodType.getMetrics.getArguments).map(a => a.getArgument.asScala).getOrElse(Seq())
    val argumentsString = arguments.map(a => s"${a.getV}").mkString(", ")

    val name = s"${clazz.name}::${methodType.getName}(${argumentsString}):${methodType.getReturnValue}"

    Method(clazz.name, name)
  }
}
