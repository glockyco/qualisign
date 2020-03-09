package at.qualisign.core.exec

import java.io.{InputStream, OutputStream}

import org.apache.commons.exec.{CommandLine, DefaultExecutor, ExecuteWatchdog, PumpStreamHandler}

import scala.util.{Failure, Success, Try}

class CommandLineExecutorImpl extends CommandLineExecutor {

  override def execute(
    command: String,
    out: OutputStream = System.out,
    err: OutputStream = System.err,
    input: InputStream = null,
  ): Unit = {
    execute(CommandLine.parse(command), out, err, input)
  }

  private def execute(
    command: CommandLine,
    out: OutputStream,
    err: OutputStream,
    input: InputStream,
  ): Unit = {
    val executor: DefaultExecutor = new DefaultExecutor

    val streamHandler = new PumpStreamHandler(out, err, input)
    executor.setStreamHandler(streamHandler)

    val watchdog = new ExecuteWatchdog(120000)
    executor.setWatchdog(watchdog)

    try {
      executor.execute(command)
    } catch {
      case exception: Exception =>
        if (watchdog.killedProcess()) {
          throw new TimeoutException(exception)
        } else {
          throw new ExecuteException(exception)
        }
    }
  }
}
