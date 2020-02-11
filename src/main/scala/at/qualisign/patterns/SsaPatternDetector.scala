package at.qualisign.patterns

import java.io.File

trait SsaPatternDetector {
  def detectPatterns(from: File, to: File): Unit
}
