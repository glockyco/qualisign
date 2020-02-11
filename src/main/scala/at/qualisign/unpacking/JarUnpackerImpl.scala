package at.qualisign.unpacking

import java.io.File

import at.qualisign.core.exec.CommandLineExecutor
import org.apache.commons.exec.OS

class JarUnpackerImpl(executor: CommandLineExecutor) extends JarUnpacker {
  override def unpack(from: File, to: File): Unit = {
    executor.execute(command(from, to))
  }

  private def command(from: File, to: File): String = {
    if (OS.isFamilyWindows) windowsCommand(from, to) else unixCommand(from, to)
  }

  private def windowsCommand(from: File, to: File): String = {
    s"cmd.exe /c cd ${to.getAbsolutePath} & jar xf ${from.getAbsolutePath}"
  }

  private def unixCommand(from: File, to: File): String = {
    s"unzip ${from.getAbsolutePath} -d ${to.getAbsolutePath}"
  }
}
