package at.qualisign.patterns

import java.io.File

import at.qualisign.patterns.jaxb.SystemType

trait SsaPatternReader {
  def readPatterns(from: File): SystemType
}
