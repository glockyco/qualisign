package at.qualisign.patterns

import at.qualisign.domain.{PatternInstance, PatternRole, Project}
import at.qualisign.patterns.factories.{PatternInstanceFactory, PatternRoleFactory}
import at.qualisign.patterns.jaxb.{InstanceType, PatternType, RoleType, SystemType}
import at.qualisign.persistence.Tables
import at.qualisign.persistence.postgresql.extensions.DomainExtensions._
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.jdk.CollectionConverters._
import scala.util.{Failure, Success}

class SsaPatternPersistenceImpl(database: Database) extends SsaPatternPersistence {
  override def persistPatterns(project: Project, systemType: SystemType): Future[Unit] = {
    var patternInstances = Seq[PatternInstance]()
    var patternRoles = Seq[PatternRole]()

    for (patternType: PatternType <- systemType.getPattern.asScala) {
      for (instanceType: InstanceType <- patternType.getInstance.asScala) {
        val patternInstance = PatternInstanceFactory.create(project, patternType)

        patternInstances :+= patternInstance

        for (roleType: RoleType <- instanceType.getRole.asScala) {
          val patternRole = PatternRoleFactory.create(patternInstance, roleType)

          patternRoles :+= patternRole
        }
      }
    }

    val deletePatternData = Tables.PatternInstances.filter(_.project === project.name).delete
    val insertPatternInstances = Tables.PatternInstances ++= patternInstances.map(i => i.asRow)
    val insertPatternRoles = Tables.PatternRoles ++= patternRoles.map(r => r.asRow)

    val actions = DBIO.seq(
      deletePatternData,
      insertPatternInstances,
      insertPatternRoles,
    ).transactionally.asTry.map({
      case Success(_) => // do nothing
      case Failure(value) => println(value)
    })

    database.run(actions)
  }
}
