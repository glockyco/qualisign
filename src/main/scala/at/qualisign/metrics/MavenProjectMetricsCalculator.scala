package at.qualisign.metrics

import at.qualisign.domain.Project

trait MavenProjectMetricsCalculator {
  def calculateProjectMetrics(project: Project): Unit
}
