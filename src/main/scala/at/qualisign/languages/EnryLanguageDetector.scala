package at.qualisign.languages

import java.io.File

trait EnryLanguageDetector {
  def detectLanguages(from: File, to: File): Unit
}
