package at.qualisign.downloading

import java.io.{FileOutputStream, InputStream}
import java.net.URL
import java.nio.channels.{Channels, FileChannel, ReadableByteChannel}

class FileDownloaderImpl extends FileDownloader {
  override def download(from: String, to: String): Unit = {
    // @TODO: use "better-files" for file operations

    val inputStream: InputStream = new URL(from).openStream()
    val inputChannel: ReadableByteChannel = Channels.newChannel(inputStream)
    val outputStream: FileOutputStream = new FileOutputStream(to)
    val outputChannel: FileChannel = outputStream.getChannel

    outputChannel.transferFrom(inputChannel, 0, Long.MaxValue)

    inputChannel.close()
    outputChannel.close()
  }
}
