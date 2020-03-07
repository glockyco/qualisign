package at.qualisign.core.exec

import java.io.{InputStream, OutputStream}

trait CommandLineExecutor {
  def execute(
    command: String,
    out: OutputStream = System.out,
    err: OutputStream = System.err,
    input: InputStream = null,
  ): Unit
}
