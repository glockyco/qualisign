package at.qualisign.metrics.jhawk.factories

import at.qualisign.domain.{Project, ProjectMetricsJHawk}
import at.qualisign.metrics.jhawk.jaxb.LOCType

object ProjectMetricsFactory {
  def create(project: Project, locType: LOCType): ProjectMetricsJHawk = {
    ProjectMetricsJHawk(
      project.name,
      locType.getTL.intValue,
      locType.getBL.intValue,
      locType.getCI.intValue,
      locType.getCO.intValue,
    )
  }
}
