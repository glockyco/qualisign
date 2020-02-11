package at.qualisign.indexing

import java.io.File

import org.apache.maven.index.context.IndexCreator
import org.apache.maven.index.creator.MinimalArtifactInfoIndexCreator

class MavenIndexConfigurationImpl extends MavenIndexConfiguration {
  val id: String = "central-context"
  val repositoryId: String = "central"
  val repository: File = new File("data/central-cache")
  val indexDirectory: File = new File("data/central-index")
  val repositoryUrl: String = "https://repo1.maven.org/maven2"
  val indexUpdateUrl: String = null
  val searchable = true
  val reclaim = true
  val indexers: List[IndexCreator] = List[IndexCreator](
    new MinimalArtifactInfoIndexCreator,
    //new JarFileContentsIndexCreator,
    //new MavenPluginArtifactInfoIndexCreator,
  )
}
