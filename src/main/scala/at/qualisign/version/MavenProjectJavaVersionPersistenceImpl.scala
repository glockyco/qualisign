package at.qualisign.version

import at.qualisign.domain.Project
import at.qualisign.domain.extensions.ProjectExtensions._

import scala.concurrent.Future

class MavenProjectJavaVersionPersistenceImpl(
  reader: JavapVersionReader,
  writer: JavapVersionPersistence
) extends MavenProjectJavaVersionPersistence {
  override def persistProjectJavaVersion(project: Project): Future[Project] = {
    writer.persistJavaVersion(project, reader.readJavaVersion(project.javaVersionFile))
  }
}
