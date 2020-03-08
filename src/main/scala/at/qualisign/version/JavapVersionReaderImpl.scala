package at.qualisign.version
import java.io.File

import scala.io.{BufferedSource, Source}

class JavapVersionReaderImpl extends JavapVersionReader {
  override def readJavaVersion(from: File): Int = {
    val source: BufferedSource = Source.fromFile(from)
    val versionString: String = source.getLines().next()
    val javaVersion: Int = versionString.replace("  major version: ", "").toInt
    source.close()
    javaVersion
  }
}
