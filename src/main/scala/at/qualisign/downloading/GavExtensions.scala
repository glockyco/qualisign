package at.qualisign.downloading

import java.io.File

import org.apache.maven.index.artifact.{Gav, M2GavCalculator}

object GavExtensions {

  private val repository_path = "https://repo1.maven.org/maven2"
  private val calculator: M2GavCalculator = new M2GavCalculator

  implicit class GavToPath(gav: Gav) {
    def toPath: String = {
      calculator.gavToPath(gav)
    }
  }

  implicit class GavToUrl(gav: Gav) {
    def toUrl: String = {
      repository_path + gav.toPath.replace(File.separatorChar, '/')
    }
  }
}
