package at.qualisign.metrics.jhawk.factories

import at.qualisign.domain.{Project, ProjectMetrics}
import at.qualisign.metrics.jhawk.jaxb.LOCType

object ProjectMetricsFactory {
  def create(project: Project, locType: LOCType): ProjectMetrics = {
    ProjectMetrics(
      project.name,
      locType.getTL.intValue,
      locType.getBL.intValue,
      locType.getCI.intValue,
      locType.getCO.intValue,
    )
  }
}
