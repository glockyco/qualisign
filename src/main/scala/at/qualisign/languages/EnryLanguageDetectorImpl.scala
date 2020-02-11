package at.qualisign.languages

import java.io.{File, FileOutputStream}

import at.qualisign.core.exec.CommandLineExecutor

class EnryLanguageDetectorImpl(executor: CommandLineExecutor)
  extends EnryLanguageDetector {

  override def detectLanguages(from: File, to: File): Unit = {
    executor.execute(command(from), new FileOutputStream(to))
  }

  private def command(from: File): String = {
    s"""docker run -t --rm -v "${from.getAbsolutePath}:/project" wowmuch/enry"""
  }
}
