package at.qualisign.persistence.postgresql

import at.qualisign.domain.Pakkage
import at.qualisign.persistence.postgresql.extensions.DomainExtensions._
import at.qualisign.persistence.{PakkageRepository, Tables}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

class PostgresPakkageRepository(database: Database) extends PakkageRepository {
  override def save(pakkage: Pakkage): Future[Unit] = {
    saveAll(Seq(pakkage))
  }

  override def saveAll(pakkages: Seq[Pakkage]): Future[Unit] = {
    val action = Tables.Pakkages ++= pakkages.map(m => m.asRow)
    database.run(DBIO.seq(action))
  }
}
