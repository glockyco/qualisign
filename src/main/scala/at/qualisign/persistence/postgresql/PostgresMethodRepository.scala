package at.qualisign.persistence.postgresql

import at.qualisign.domain.Method
import at.qualisign.persistence.postgresql.extensions.DomainExtensions._
import at.qualisign.persistence.{MethodRepository, Tables}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

class PostgresMethodRepository(database: Database) extends MethodRepository {
  override def save(method: Method): Future[Unit] = {
    saveAll(Seq(method))
  }

  override def saveAll(methods: Seq[Method]): Future[Unit] = {
    val action = Tables.Methods ++= methods.map(m => m.asRow)
    database.run(DBIO.seq(action))
  }
}
