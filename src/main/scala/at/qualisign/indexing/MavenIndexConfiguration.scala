package at.qualisign.indexing

import java.io.File

import org.apache.maven.index.context.IndexCreator

trait MavenIndexConfiguration {
  val id: String
  val repositoryId: String
  val repository: File
  val indexDirectory: File
  val repositoryUrl: String
  val indexUpdateUrl: String
  val searchable: Boolean
  val reclaim: Boolean
  val indexers: List[IndexCreator]
}
