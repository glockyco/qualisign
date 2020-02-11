package at.qualisign.indexing

import at.qualisign.domain.Project

trait MavenIndexReader {
  def readProjects(): Seq[Project]
}
