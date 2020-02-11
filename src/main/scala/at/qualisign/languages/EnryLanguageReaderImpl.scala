package at.qualisign.languages

import java.io.File
import java.text.DecimalFormat

import scala.io.{BufferedSource, Source}

class EnryLanguageReaderImpl extends EnryLanguageReader {
  override def readLanguages(from: File): Seq[EnryLanguage] = {
    val source: BufferedSource = Source.fromFile(from)
    val languages: Seq[EnryLanguage] = source.getLines().map(lineToLanguage).toSeq
    source.close()
    languages
  }

  private def lineToLanguage(line: String): EnryLanguage = {
    val parts: Array[String] = line.split("\t")
    val name: String = parts(1)
    val percentage: String = parts(0)
    val fraction: Number = new DecimalFormat("0.0#%").parse(percentage)

    EnryLanguage(name, fraction.doubleValue())
  }
}
