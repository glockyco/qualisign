package at.qualisign.languages

import at.qualisign.domain.Project

import scala.concurrent.Future

trait EnryLanguagePersistence {
  def persistLanguages(project: Project, languages: Seq[EnryLanguage]): Future[Unit]
}
