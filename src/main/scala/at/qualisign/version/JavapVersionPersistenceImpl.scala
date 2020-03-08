package at.qualisign.version

import at.qualisign.domain.Project
import at.qualisign.persistence.Tables
import at.qualisign.persistence.postgresql.extensions.DomainExtensions._
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}

class JavapVersionPersistenceImpl(database: Database) extends JavapVersionPersistence {
  override def persistJavaVersion(project: Project, javaVersion: Int): Future[Project] = {
    val p = project.copy(javaVersion = Some(javaVersion))

    val promise = Promise[Project]()

    val actions = Tables.Projects.filter(_.name === p.name).update(p.asRow).transactionally.asTry.map({
      case Success(_) => promise.success(p)
      case Failure(exception) => promise.failure(exception)
    })

    database.run(actions)

    promise.future
  }
}
