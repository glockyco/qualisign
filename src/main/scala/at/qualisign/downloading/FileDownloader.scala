package at.qualisign.downloading

trait FileDownloader {
  def download(from: String, to: String): Unit
}
