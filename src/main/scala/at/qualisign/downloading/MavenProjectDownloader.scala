package at.qualisign.downloading

import at.qualisign.domain.Project

trait MavenProjectDownloader {
  def downloadProject(project: Project): Unit
}
