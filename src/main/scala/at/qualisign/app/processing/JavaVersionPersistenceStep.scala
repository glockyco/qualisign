package at.qualisign.app.processing

import at.qualisign.domain.ProcessingStatus.{FAILED, PENDING, SUCCEEDED}
import at.qualisign.domain.Project
import at.qualisign.version.MavenProjectJavaVersionPersistence
import at.qualisign.version.exceptions.JavaVersionPersistenceException

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

class JavaVersionPersistenceStep(
  persistence: MavenProjectJavaVersionPersistence
) extends ProcessingStep {
  override def execute(project: Project): Either[(Project, Exception), Project] = {
    val result: Future[Project] = Await.ready(persistence.persistProjectJavaVersion(project), Duration.Inf)

    result.value.get match {
      case Success(p) =>
        Right(p.copy(javaVersionPersistenceStatus = SUCCEEDED))
      case Failure(e) =>
        val exception = new JavaVersionPersistenceException(e)
        Left(project.copy(javaVersionPersistenceStatus = FAILED), exception)
    }
  }

  override def isPending(project: Project): Boolean = {
    project.javaVersionPersistenceStatus == PENDING
  }
}
