package at.qualisign.indexing

import org.apache.maven.index.Indexer
import org.apache.maven.index.context.IndexingContext

import scala.jdk.CollectionConverters._

object IndexerExtensions {
  implicit class IndexerCreateContext(indexer: Indexer) {
    def createIndexingContext(configuration: MavenIndexConfiguration): IndexingContext = {
      indexer.createIndexingContext(
        configuration.id,
        configuration.repositoryId,
        configuration.repository,
        configuration.indexDirectory,
        configuration.repositoryUrl,
        configuration.indexUpdateUrl,
        configuration.searchable,
        configuration.reclaim,
        configuration.indexers.asJava,
      )
    }
  }
}
