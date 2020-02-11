package at.qualisign.persistence.postgresql

import at.qualisign.domain.ClazzMetrics
import at.qualisign.persistence.postgresql.extensions.DomainExtensions._
import at.qualisign.persistence.{ClazzMetricsRepository, Tables}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

class PostgresClazzMetricsRepository(database: Database) extends ClazzMetricsRepository {
  override def save(metrics: ClazzMetrics): Future[Unit] = {
    saveAll(Seq(metrics))
  }

  override def saveAll(metrics: Seq[ClazzMetrics]): Future[Unit] = {
    val action = Tables.ClazzMetrics ++= metrics.map(m => m.asRow)
    database.run(DBIO.seq(action))
  }
}
