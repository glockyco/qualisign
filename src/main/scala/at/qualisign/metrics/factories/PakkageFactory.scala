package at.qualisign.metrics.factories

import at.qualisign.domain.{Pakkage, Project}
import at.qualisign.metrics.jaxb.PackageType

object PakkageFactory {
  def create(project: Project, packageType: PackageType): Pakkage = {
    val name = s"${project.name}.${packageType.getName}"

    Pakkage(project.name, name)
  }
}
