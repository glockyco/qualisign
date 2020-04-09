package at.qualisign.metrics.ckjm.factories

import at.qualisign.domain.{Pakkage, Project}
import at.qualisign.metrics.ckjm.jaxb.ClassType

object PakkageFactory {
  def create(project: Project, classType: ClassType): Pakkage = {
    val pakkageName = classType.getName.split("\\.").dropRight(1).mkString(".")
    val name = s"${project.name}.${pakkageName}"

    Pakkage(project.name, name)
  }
}
