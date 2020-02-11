package at.qualisign.app.processing

import at.qualisign.domain.ProcessingStatus.{FAILED, PENDING, SUCCEEDED}
import at.qualisign.domain.Project
import at.qualisign.downloading.MavenProjectDownloader

class JarDownloadStep(
  downloader: MavenProjectDownloader,
) extends ProcessingStep {
  override def execute(project: Project): Either[(Project, Exception), Project] = {
    try {
      downloader.downloadProject(project)
      Right(project.copy(jarDownloadStatus = SUCCEEDED))
    } catch {
      case exception: Exception =>
        Left(project.copy(jarDownloadStatus = FAILED), exception)
    }
  }

  override def isPending(project: Project): Boolean = {
    project.jarDownloadStatus == PENDING
  }
}
