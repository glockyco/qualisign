package at.qualisign.version

import java.io.File

trait JavapVersionReader {
  def readJavaVersion(from: File): Int
}
