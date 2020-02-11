package at.qualisign.patterns

import at.qualisign.domain.Project

trait MavenProjectPatternDetector {
  def detectProjectPatterns(project: Project): Unit
}
