package at.qualisign.persistence.postgresql

import at.qualisign.domain.MethodMetricsJHawk
import at.qualisign.persistence.postgresql.extensions.DomainExtensions._
import at.qualisign.persistence.{MethodMetricsRepository, Tables}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

class PostgresMethodMetricsRepository(database: Database) extends MethodMetricsRepository {
  override def save(metrics: MethodMetricsJHawk): Future[Unit] = {
    saveAll(Seq(metrics))
  }

  override def saveAll(metrics: Seq[MethodMetricsJHawk]): Future[Unit] = {
    val action = Tables.MethodMetricsJhawk ++= metrics.map(m => m.asRow)
    database.run(DBIO.seq(action))
  }
}
