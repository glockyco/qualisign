package at.qualisign.persistence.postgresql

import at.qualisign.domain.Clazz
import at.qualisign.persistence.postgresql.extensions.DomainExtensions._
import at.qualisign.persistence.{ClazzRepository, Tables}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

class PostgresClazzRepository(database: Database) extends ClazzRepository {
  override def save(clazz: Clazz): Future[Unit] = {
    saveAll(Seq(clazz))
  }

  override def saveAll(clazzes: Seq[Clazz]): Future[Unit] = {
    val action = Tables.Clazzes ++= clazzes.map(m => m.asRow)
    database.run(DBIO.seq(action))
  }
}
