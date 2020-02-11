package at.qualisign.languages

import at.qualisign.domain.{Project, ProjectLanguage}
import at.qualisign.persistence.Tables
import at.qualisign.persistence.postgresql.extensions.DomainExtensions._
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

class EnryLanguagePersistenceImpl(database: Database) extends EnryLanguagePersistence {
  override def persistLanguages(project: Project, languages: Seq[EnryLanguage]): Future[Unit] = {
    val projectLanguages = languages.map(language => ProjectLanguage(project.name, language.name, language.fraction))

    val deleteLanguages = Tables.ProjectLanguages.filter(_.project === project.name).delete
    val insertLanguages = Tables.ProjectLanguages ++= projectLanguages.map(i => i.asRow)

    val actions = DBIO.seq(
      deleteLanguages,
      insertLanguages,
    ).transactionally.asTry.map({
      case Success(_) => // do nothing
      case Failure(value) => println(value)
        // @TODO: throw exception on error rather than printing it (or return Try rather than Unit)
    })

    database.run(actions)
  }
}
