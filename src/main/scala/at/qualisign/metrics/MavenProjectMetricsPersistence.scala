package at.qualisign.metrics

import at.qualisign.domain.Project

trait MavenProjectMetricsPersistence {
  def persistProjectMetrics(project: Project): Unit
}
