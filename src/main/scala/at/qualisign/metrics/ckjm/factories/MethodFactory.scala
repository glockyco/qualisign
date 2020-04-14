package at.qualisign.metrics.ckjm.factories

import at.qualisign.domain.{Clazz, Method}
import at.qualisign.metrics.ckjm.jaxb.MethodType

object MethodFactory {
  def create(clazz: Clazz, methodType: MethodType): Method = {

    // Format of methodType.getName:
    // [modifiers] [return_type] [method_name]([param_type] [param_name], ...)
    //
    // Needed name format:
    // [class_name]::[method_name]([param_type], ...):[return_type]

    val Array(left, right) = methodType.getName.split("\\(")
    val Array(returnType, methodName) = left.split(" ").takeRight(2)
    val paramTypes = right.replace(")", "").split(", ").map(param => param.split(" ").head).mkString(", ")

    val name = s"${clazz.name}::${methodName}(${paramTypes}):${returnType}"

    Method(clazz.name, name, getAccessModifier(methodType.getName))
  }

  private def getAccessModifier(name: String): String = {
    val modifier = name.split(" ").head
    val accessModifiers = Seq("public", "protected", "private")

    if (accessModifiers.contains(modifier)) modifier else "default"
  }
}
