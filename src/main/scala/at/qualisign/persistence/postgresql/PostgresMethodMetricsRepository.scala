package at.qualisign.persistence.postgresql

import at.qualisign.domain.MethodMetrics
import at.qualisign.persistence.postgresql.extensions.DomainExtensions._
import at.qualisign.persistence.{MethodMetricsRepository, Tables}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

class PostgresMethodMetricsRepository(database: Database) extends MethodMetricsRepository {
  override def save(metrics: MethodMetrics): Future[Unit] = {
    saveAll(Seq(metrics))
  }

  override def saveAll(metrics: Seq[MethodMetrics]): Future[Unit] = {
    val action = Tables.MethodMetrics ++= metrics.map(m => m.asRow)
    database.run(DBIO.seq(action))
  }
}
