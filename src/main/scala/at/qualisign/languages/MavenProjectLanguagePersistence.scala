package at.qualisign.languages

import at.qualisign.domain.Project

import scala.concurrent.Future

trait MavenProjectLanguagePersistence {
  def persistProjectLanguages(project: Project): Future[Unit]
}
