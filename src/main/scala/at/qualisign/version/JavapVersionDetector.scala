package at.qualisign.version

import java.io.File

trait JavapVersionDetector {
  def detectJavaVersion(from: File, to: File): Unit
}
