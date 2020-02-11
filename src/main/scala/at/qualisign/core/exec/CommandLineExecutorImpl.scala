package at.qualisign.core.exec

import java.io.OutputStream

import org.apache.commons.exec.{CommandLine, DefaultExecutor, PumpStreamHandler}

class CommandLineExecutorImpl(
  out: OutputStream = System.out,
  err: OutputStream = System.err,
) extends CommandLineExecutor {

  @throws[ExecuteException]("if execution of the command failed")
  override def execute(
    command: String,
    out: OutputStream = System.out,
    err: OutputStream = System.err,
  ): Unit = {
    execute(CommandLine.parse(command), out, err)
  }

  @throws[ExecuteException]("if execution of the command failed")
  private def execute(
    command: CommandLine,
    out: OutputStream,
    err: OutputStream,
  ): Unit = {
    val executor: DefaultExecutor = new DefaultExecutor
    executor.setStreamHandler(new PumpStreamHandler(out, err))

    // @TODO: log command line output/errors
    //executor.setStreamHandler(new PumpStreamHandler(System.out, System.err, null))

    try {
      executor.execute(command)
    } catch {
      case exception: Exception => throw new ExecuteException(exception)
    }
  }
}
