package at.qualisign.languages

import java.io.File

trait EnryLanguageReader {
  def readLanguages(from: File): Seq[EnryLanguage]
}
