package at.qualisign.metrics.factories

import at.qualisign.domain.{Clazz, Pakkage}
import at.qualisign.metrics.jaxb.ClassType

object ClazzFactory {
  def create(pakkage: Pakkage, classType: ClassType): Clazz = {
    val name = s"${pakkage.name}.${classType.getClassName}"

    Clazz(pakkage.name, name)
  }
}
