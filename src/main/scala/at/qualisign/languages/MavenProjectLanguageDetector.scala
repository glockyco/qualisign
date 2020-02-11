package at.qualisign.languages

import at.qualisign.domain.Project

trait MavenProjectLanguageDetector {
  def detectProjectLanguages(project: Project): Unit
}
