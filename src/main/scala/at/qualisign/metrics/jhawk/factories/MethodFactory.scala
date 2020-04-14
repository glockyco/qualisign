package at.qualisign.metrics.jhawk.factories

import at.qualisign.domain.{Clazz, Method}
import at.qualisign.metrics.jhawk.jaxb.MethodType

import scala.jdk.CollectionConverters._

object MethodFactory {
  def create(clazz: Clazz, methodType: MethodType): Method = {
    val arguments = Option(methodType.getMetrics.getArguments).map(a => a.getArgument.asScala).getOrElse(Seq())
    val argumentsString = arguments.map(a => s"${a.getV}").mkString(", ")

    val name = s"${clazz.name}::${methodType.getName}(${argumentsString}):${methodType.getReturnValue}"

    val modifiers = Option(methodType.getMetrics.getModifiers).map(m => m.getModifier.asScala).getOrElse(Seq()).toSeq

    Method(clazz.name, name, getAccessModifier(modifiers))
  }

  private def getAccessModifier(modifiers: Seq[String]): String = {
    val modifier = modifiers.headOption
    val accessModifiers = Seq("public", "protected", "private")

    modifier.filter(m => accessModifiers.contains(m)).getOrElse("default")
  }
}
