package at.qualisign.metrics.ckjm
import at.qualisign.domain._
import at.qualisign.metrics.ckjm.factories._
import at.qualisign.metrics.ckjm.jaxb.{CkjmType, ClassType, MethodType}
import at.qualisign.persistence.Tables
import at.qualisign.persistence.postgresql.extensions.DomainExtensions._
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.jdk.CollectionConverters._
import scala.util.{Failure, Success}

class CkjmMetricsPersistenceImpl(database: Database) extends CkjmMetricsPersistence {
  override def persistMetrics(project: Project, ckjmType: CkjmType): Unit = {
    var pakkages = Seq[Pakkage]()

    var clazzes = Seq[Clazz]()
    var clazzMetrics = Seq[ClazzMetricsCkjm]()

    for (classType: ClassType <- ckjmType.getClazz.asScala) {
      val pakkage = PakkageFactory.create(project, classType)

      pakkages :+= pakkage

      val clazz = ClazzFactory.create(pakkage, classType)

      var methods = Seq[Method]()
      var methodMetrics = Seq[MethodMetricsCkjm]()

      for (methodType: MethodType <- classType.getCc.getMethod.asScala) {
        val method = MethodFactory.create(clazz, methodType)
        val methodMetric = MethodMetricsFactory.create(method, methodType)

        methods :+= method
        methodMetrics :+= methodMetric
      }

      val clazzMetric = ClazzMetricsFactory.create(clazz, classType, methods, methodMetrics)

      clazzes :+= clazz
      clazzMetrics :+= clazzMetric
    }

    val actions = DBIO.seq(
      DBIO.seq(pakkages.distinct.map(x => Tables.Pakkages.insertOrUpdate(x.asRow)): _ *),

      DBIO.seq(clazzes.map(x => Tables.Clazzes.insertOrUpdate(x.asRow)): _ *),
      DBIO.seq(clazzMetrics.map(x => Tables.ClazzMetricsCkjm.insertOrUpdate(x.asRow)): _ *),
    ).asTry.map({
      case Success(_) => // do nothing
      case Failure(exception) => throw exception
    })

    database.run(actions)
  }
}
