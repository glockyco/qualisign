package at.qualisign.indexing

import at.qualisign.indexing.IndexerExtensions._
import org.apache.maven.index._
import org.apache.maven.index.context.IndexingContext
import org.apache.maven.index.incremental.{DefaultIncrementalHandler, IncrementalHandler}
import org.apache.maven.index.updater._
import org.apache.maven.wagon.Wagon
import org.apache.maven.wagon.providers.http.HttpWagon

import scala.jdk.CollectionConverters._

class MavenIndexUpdaterImpl(configuration: MavenIndexConfiguration) extends MavenIndexUpdater {

  def updateIndex(): Unit = {
    val context: IndexingContext = indexer.createIndexingContext(configuration)

    val resourceFetcher: ResourceFetcher = new WagonHelper.WagonFetcher(wagon, null, null, null)
    val updateRequest: IndexUpdateRequest = new IndexUpdateRequest(context, resourceFetcher)
    val updateResult: IndexUpdateResult = indexUpdater.fetchAndUpdateIndex(updateRequest)

    indexer.closeIndexingContext(context, false)
  }

  private val searcher: SearchEngine = new DefaultSearchEngine
  private val indexerEngine: IndexerEngine = new DefaultIndexerEngine
  private val queryCreator: QueryCreator = new DefaultQueryCreator
  private val indexer: Indexer = new DefaultIndexer(searcher, indexerEngine, queryCreator)

  private val incrementalHandler: IncrementalHandler = new DefaultIncrementalHandler
  private val sideEffects: List[IndexUpdateSideEffect] = List[IndexUpdateSideEffect]()
  private val indexUpdater: IndexUpdater = new DefaultIndexUpdater(incrementalHandler, sideEffects.asJava)

  private val wagon: Wagon = new HttpWagon
}
