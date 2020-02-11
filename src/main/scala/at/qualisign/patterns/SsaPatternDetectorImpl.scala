package at.qualisign.patterns

import java.io.File

import at.qualisign.core.exec.CommandLineExecutor

class SsaPatternDetectorImpl(executor: CommandLineExecutor)
  extends SsaPatternDetector {

  override def detectPatterns(from: File, to: File): Unit = {
    executor.execute(command(from, to))
  }

  private def command(from: File, to: File): String = {
    val from_path = from.getAbsolutePath
    val to_path = to.getAbsolutePath

    s"java -jar tools/ssa/pattern4.jar -target $from_path -output $to_path"
  }
}
