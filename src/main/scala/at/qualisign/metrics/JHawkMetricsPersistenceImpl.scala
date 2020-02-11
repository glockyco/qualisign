package at.qualisign.metrics

import at.qualisign.domain._
import at.qualisign.metrics.factories._
import at.qualisign.metrics.jaxb.{ClassType, MethodType, PackageType, SystemType}
import at.qualisign.persistence.Tables
import at.qualisign.persistence.postgresql.extensions.DomainExtensions._
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.jdk.CollectionConverters._
import scala.util.{Failure, Success}

class JHawkMetricsPersistenceImpl(database: Database) extends JHawkMetricsPersistence {
  override def persistMetrics(project: Project, systemType: SystemType): Future[Unit] = {
    val projectMetrics = ProjectMetricsFactory.create(project, systemType.getLOC)

    var pakkages = Seq[Pakkage]()
    var pakkageMetrics = Seq[PakkageMetrics]()

    var clazzes = Seq[Clazz]()
    var clazzMetrics = Seq[ClazzMetrics]()

    var methods = Seq[Method]()
    var methodMetrics = Seq[MethodMetrics]()

    for (packageType: PackageType <- systemType.getPackages.getPackage.asScala) {
      val pakkage = PakkageFactory.create(project, packageType)
      val pakkageMetric = PakkageMetricsFactory.create(pakkage, packageType.getMetrics)

      pakkages :+= pakkage
      pakkageMetrics :+= pakkageMetric

      for (classType: ClassType <- packageType.getClasses.getClazz.asScala) {
        val clazz = ClazzFactory.create(pakkage, classType)
        val clazzMetric = ClazzMetricsFactory.create(clazz, classType.getMetrics)

        clazzes :+= clazz
        clazzMetrics :+= clazzMetric

        for (methodType: MethodType <- classType.getMethods.getMethod.asScala) {
          val method = MethodFactory.create(clazz, methodType)
          val methodMetric = MethodMetricsFactory.create(method, methodType.getMetrics)

          methods :+= method
          methodMetrics :+= methodMetric
        }
      }
    }

    val actions = DBIO.seq(
      DBIO.seq(pakkages.map(x => Tables.Pakkages.insertOrUpdate(x.asRow)): _ *),
      DBIO.seq(pakkageMetrics.map(x => Tables.PakkageMetrics.insertOrUpdate(x.asRow)): _ *),

      DBIO.seq(clazzes.map(x => Tables.Clazzes.insertOrUpdate(x.asRow)): _ *),
      DBIO.seq(clazzMetrics.map(x => Tables.ClazzMetrics.insertOrUpdate(x.asRow)): _ *),

      DBIO.seq(methods.map(x => Tables.Methods.insertOrUpdate(x.asRow)): _ *),
      DBIO.seq(methodMetrics.map(x => Tables.MethodMetrics.insertOrUpdate(x.asRow)): _ *),

      Tables.ProjectMetrics.insertOrUpdate(projectMetrics.asRow),
    ).asTry.map({
      case Success(_) => // do nothing
      case Failure(value) => println(value)
    })

    database.run(actions)
  }
}
