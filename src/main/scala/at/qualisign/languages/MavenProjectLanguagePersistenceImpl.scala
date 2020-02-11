package at.qualisign.languages

import at.qualisign.domain.Project
import at.qualisign.domain.extensions.ProjectExtensions._
import at.qualisign.languages.exceptions.LanguagePersistenceException

import scala.concurrent.Future

class MavenProjectLanguagePersistenceImpl(
  reader: EnryLanguageReader,
  writer: EnryLanguagePersistence,
) extends MavenProjectLanguagePersistence {
  override def persistProjectLanguages(project: Project): Future[Unit] = {
    try {
      writer.persistLanguages(project, reader.readLanguages(project.languagesFile))
    } catch {
      case exception: Exception => throw new LanguagePersistenceException(exception)
    }
  }
}
