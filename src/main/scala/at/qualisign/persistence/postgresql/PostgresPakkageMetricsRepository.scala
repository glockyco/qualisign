package at.qualisign.persistence.postgresql

import at.qualisign.domain.PakkageMetrics
import at.qualisign.persistence.postgresql.extensions.DomainExtensions._
import at.qualisign.persistence.{PakkageMetricsRepository, Tables}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

class PostgresPakkageMetricsRepository(database: Database) extends PakkageMetricsRepository {
  override def save(metrics: PakkageMetrics): Future[Unit] = {
    saveAll(Seq(metrics))
  }

  override def saveAll(metrics: Seq[PakkageMetrics]): Future[Unit] = {
    val action = Tables.PakkageMetrics ++= metrics.map(m => m.asRow)
    database.run(DBIO.seq(action))
  }
}
