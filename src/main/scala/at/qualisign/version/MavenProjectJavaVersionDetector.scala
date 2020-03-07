package at.qualisign.version

import at.qualisign.domain.Project

trait MavenProjectJavaVersionDetector {
  def detectProjectJavaVersion(project: Project): Unit
}
