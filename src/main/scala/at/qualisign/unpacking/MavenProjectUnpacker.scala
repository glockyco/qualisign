package at.qualisign.unpacking

import at.qualisign.domain.Project

trait MavenProjectUnpacker {
  def unpackProject(project: Project)
}
