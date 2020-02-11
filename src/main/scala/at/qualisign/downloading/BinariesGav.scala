package at.qualisign.downloading

import at.qualisign.domain.Project
import org.apache.maven.index.artifact.Gav

object BinariesGav {
  def apply(project: Project): Gav = {
    new Gav(
      project.groupId,
      project.artifactId,
      project.version,
      null,
      "jar",
      null,
      null,
      null,
      false,
      null,
      false,
      null
    )
  }
}
