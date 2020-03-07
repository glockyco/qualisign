package at.qualisign.version

import java.io.{ByteArrayInputStream, ByteArrayOutputStream, File, FileOutputStream, InputStream}

import at.qualisign.core.exec.CommandLineExecutor

class JavapVersionDetectorImpl(executor: CommandLineExecutor)
  extends JavapVersionDetector {

  override def detectJavaVersion(from: File, to: File): Unit = {
    val out = new ByteArrayOutputStream()
    executor.execute(javapCommand(from), out)

    val in = new ByteArrayInputStream(out.toByteArray)
    executor.execute(grepCommand(), new FileOutputStream(to), System.err, in)
  }

  private def javapCommand(from: File): String = {
    s"""javap -verbose ${from.getAbsolutePath}"""
  }

  private def grepCommand(): String = {
    s"""findstr major"""
  }
}
