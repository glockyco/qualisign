package at.qualisign.indexing

import at.qualisign.domain.Project
import at.qualisign.indexing.IndexerExtensions._
import org.apache.lucene.index.Term
import org.apache.lucene.search.WildcardQuery
import org.apache.maven.index._
import org.apache.maven.index.context.IndexingContext
import org.apache.maven.index.search.grouping.GAGrouping

import scala.jdk.CollectionConverters._

class MavenIndexReaderImpl(configuration: MavenIndexConfiguration) extends MavenIndexReader {

  def readProjects(): Seq[Project] = {
    val context: IndexingContext = indexer.createIndexingContext(configuration)

    val query = new WildcardQuery(new Term("u", "*|NA|jar"))
    val grouping = new GAGrouping
    val request = new GroupedSearchRequest(query, grouping, context)

    val response = indexer.searchGrouped(request)
    val results = response.getResults

    val projects = results.asScala.values
      // only include the newest versions of the artifacts
      // @TODO: include all versions instead (for descriptive statistics / potential extensions)
      .map(group => group.getArtifactInfos.iterator().next())
      // only include artifacts for which sources are available
      // @TODO: include artifacts without sources as well (for descriptive statistics)
      //.filter(artifact => artifact.getSourcesExists == ArtifactAvailability.PRESENT)
      .map(artifact2project)
      .toSeq

    indexer.closeIndexingContext(context, false)

    projects
  }

  private def artifact2project(artifact: ArtifactInfo): Project = {
    Project(
      artifact.getGroupId,
      artifact.getArtifactId,
      artifact.getVersion,
      artifact.getSourcesExists == ArtifactAvailability.PRESENT
    )
  }

  private val searcher: SearchEngine = new DefaultSearchEngine
  private val indexerEngine: IndexerEngine = new DefaultIndexerEngine
  private val queryCreator: QueryCreator = new DefaultQueryCreator
  private val indexer: Indexer = new DefaultIndexer(searcher, indexerEngine, queryCreator)
}
