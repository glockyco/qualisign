package at.qualisign.downloading

import at.qualisign.domain.Project
import at.qualisign.domain.extensions.ProjectExtensions._
import at.qualisign.downloading.GavExtensions._
import at.qualisign.downloading.exceptions.DownloadException

class MavenProjectDownloaderImpl(downloader: FileDownloader)
  extends MavenProjectDownloader {

  override def downloadProject(project: Project): Unit = {
    try {
      project.jarsDirectory.mkdirs()

      downloadSourcesJar(project)
      downloadBinariesJar(project)
    } catch {
      case exception: Exception => throw new DownloadException(exception)
    }
  }

  private def downloadSourcesJar(project: Project): Unit = {
    val from: String = SourcesGav(project).toUrl
    val to: String = project.sourcesJarFile.getPath
    downloader.download(from, to)
  }

  private def downloadBinariesJar(project: Project): Unit = {
    val from: String = BinariesGav(project).toUrl
    val to: String = project.binariesJarFile.getPath
    downloader.download(from, to)
  }
}
