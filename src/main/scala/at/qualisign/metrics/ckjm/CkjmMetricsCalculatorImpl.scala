package at.qualisign.metrics.ckjm
import java.io.{File, FileOutputStream}

import at.qualisign.core.exec.CommandLineExecutor

class CkjmMetricsCalculatorImpl(executor: CommandLineExecutor)
  extends CkjmMetricsCalculator {

  override def calculateMetrics(from: File, to: File, error: File): Unit = {
    val out = new FileOutputStream(to)
    val err = new FileOutputStream(error)

    executor.execute(command(from), out, err)
  }

  private def command(from: File): String = {
    val from_path = from.getAbsolutePath

    s"java -jar tools/ckjm-extended/ckjm_ext.jar -x $from_path"
  }
}
