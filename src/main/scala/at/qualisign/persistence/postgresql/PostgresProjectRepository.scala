package at.qualisign.persistence.postgresql

import at.qualisign.domain.Project
import at.qualisign.persistence.postgresql.extensions.DomainExtensions._
import at.qualisign.persistence.postgresql.extensions.RowExtensions._
import at.qualisign.persistence.{ProjectRepository, Tables}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

class PostgresProjectRepository(database: Database) extends ProjectRepository {
  override def save(project: Project): Future[Unit] = {
    saveAll(Seq(project))
  }

  override def saveAll(projects: Seq[Project]): Future[Unit] = {
    val actions = projects.map(m => Tables.Projects.insertOrUpdate(m.asRow))
    database.run(DBIO.seq(actions: _ *))
  }

  override def readAllWithSources(): Future[Seq[Project]] = {
    val action = Tables.Projects.filter(p => p.hasSources).sortBy(p => p.name)

    for (
      projects <- database.run(action.result);
      project <- Future.sequence(projects.map(p => Future(p.asDomain)))
    ) yield project
  }

  def insertIfNotExists(projects: Seq[Project]): Future[Unit] = {
    val insertIfNotExists = (project: Project) => {
      Tables.Projects.filter(_.name === project.name).exists.result.flatMap {
        case true => DBIO.successful(None)
        case false => Tables.Projects += project.asRow
      }
    }.asTry.map({
      case Success(_) => // do nothing
      case Failure(value) => println(value)
    }).transactionally

    val actions = DBIO.seq(projects.map(insertIfNotExists): _ *)

    database.run(actions)
  }

}
