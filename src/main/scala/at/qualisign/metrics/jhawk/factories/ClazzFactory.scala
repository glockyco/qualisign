package at.qualisign.metrics.jhawk.factories

import at.qualisign.domain.{Clazz, Pakkage}
import at.qualisign.metrics.jhawk.jaxb.ClassType

object ClazzFactory {
  def create(pakkage: Pakkage, classType: ClassType): Clazz = {
    val name = s"${pakkage.name}.${classType.getClassName}"

    Clazz(pakkage.name, name)
  }
}
