package at.qualisign.persistence.postgresql

import at.qualisign.domain.ProjectMetrics
import at.qualisign.persistence.postgresql.extensions.DomainExtensions._
import at.qualisign.persistence.{ProjectMetricsRepository, Tables}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

class PostgresProjectMetricsRepository(database: Database) extends ProjectMetricsRepository {
  override def save(metrics: ProjectMetrics): Future[Unit] = {
    saveAll(Seq(metrics))
  }

  override def saveAll(metrics: Seq[ProjectMetrics]): Future[Unit] = {
    val action = Tables.ProjectMetrics ++= metrics.map(m => m.asRow)
    database.run(DBIO.seq(action))
  }
}
