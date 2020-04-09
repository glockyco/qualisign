package at.qualisign.metrics.ckjm.factories

import at.qualisign.domain.{Clazz, Pakkage}
import at.qualisign.metrics.ckjm.jaxb.ClassType

object ClazzFactory {
  def create(pakkage: Pakkage, classType: ClassType): Clazz = {
    val clazzName = classType.getName.split("\\.").last;
    val name = s"${pakkage.name}.${clazzName}"

    Clazz(pakkage.name, name)
  }
}
