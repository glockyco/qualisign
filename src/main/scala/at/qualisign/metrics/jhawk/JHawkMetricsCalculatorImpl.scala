package at.qualisign.metrics.jhawk

import java.io.{File, FileOutputStream}

import at.qualisign.core.exec.CommandLineExecutor

class JHawkMetricsCalculatorImpl(executor: CommandLineExecutor)
  extends JHawkMetricsCalculator {

  override def calculateMetrics(from: File, to: File, error: File): Unit = {
    val err = new FileOutputStream(error)

    executor.execute(command(from, to), err = err)
  }

  private def command(from: File, to: File): String = {
    val from_path = from.getAbsolutePath

    // JHawk always adds ".xml" to the path, so we have to remove it first
    // here. Since this is a peculiarity of JHawk, it seems most appropriate
    // to handle here rather than e.g. provide the extension-less path through
    // an additional method in the ProjectExtensions class.
    val to_path = to.getAbsolutePath.replaceAll("\\.xml$", "")

    s"java -jar tools/jhawk-command-line/JHawkCommandLine.jar -p tools/jhawk-command-line/jhawkfull.properties -f .*\\.java -r -l pcm -s ${from_path} -x ${to_path}"
  }
}
