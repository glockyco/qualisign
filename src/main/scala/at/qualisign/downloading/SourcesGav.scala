package at.qualisign.downloading

import at.qualisign.domain.Project
import org.apache.maven.index.artifact.Gav

object SourcesGav {
  def apply(project: Project): Gav = {
    new Gav(
      project.groupId,
      project.artifactId,
      project.version,
      "sources",
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
