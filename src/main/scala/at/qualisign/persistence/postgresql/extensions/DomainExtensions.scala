package at.qualisign.persistence.postgresql.extensions

import at.qualisign.domain._
import at.qualisign.persistence.Tables

object DomainExtensions {

  implicit class ProjectAsRowExtension(project: Project) {
    def asRow: Tables.ProjectsRow = {
      Tables.ProjectsRow(
        project.name,
        project.groupId,
        project.artifactId,
        project.version,
        project.hasSources,
        project.jarDownloadStatus,
        project.jarUnpackingStatus,
        project.languageDetectionStatus,
        project.languagePersistenceStatus,
        project.metricsCalculationStatus,
        project.metricsPersistenceStatus,
        project.patternDetectionStatus,
        project.patternPersistenceStatus,
        project.javaVersionDetectionStatus,
        project.javaVersionPersistenceStatus,
        project.javaVersion,
      )
    }
  }

  implicit class ProjectLanguageAsRowExtension(language: ProjectLanguage) {
    def asRow: Tables.ProjectLanguagesRow = {
      Tables.ProjectLanguagesRow(
        language.project,
        language.name,
        language.fraction,
      )
    }
  }

  implicit class PakkageAsRowExtension(pakkage: Pakkage) {
    def asRow: Tables.PakkagesRow = {
      Tables.PakkagesRow(
        pakkage.project,
        pakkage.name,
      )
    }
  }

  implicit class ClazzAsRowExtension(clazz: Clazz) {
    def asRow: Tables.ClazzesRow = {
      Tables.ClazzesRow(
        clazz.pakkage,
        clazz.name,
      )
    }
  }

  implicit class ClazzMetricsCkjmAsRowExtension(metrics: ClazzMetricsCkjm) {
    def asRow: Tables.ClazzMetricsCkjmRow = {
      Tables.ClazzMetricsCkjmRow(
        metrics.clazz,
        metrics.amc,
        metrics.ca,
        metrics.cam,
        metrics.cbm,
        metrics.cbo,
        metrics.cc,
        metrics.ce,
        metrics.dam,
        metrics.dit,
        metrics.ic,
        metrics.lcom,
        metrics.lcom3,
        metrics.loc,
        metrics.mfa,
        metrics.moa,
        metrics.noc,
        metrics.nom,
        metrics.nop,
        metrics.npm,
        metrics.rfc,
        metrics.wmc,
      )
    }
  }

  implicit class MethodAsRowExtension(method: Method) {
    def asRow: Tables.MethodsRow = {
      Tables.MethodsRow(
        method.clazz,
        method.name,
        method.accessModifier,
      )
    }
  }

  implicit class MethodMetricsCkjmAsRowExtension(metrics: MethodMetricsCkjm) {
    def asRow: Tables.MethodMetricsCkjmRow = {
      Tables.MethodMetricsCkjmRow(
        metrics.method,
        metrics.cc,
      )
    }
  }

  implicit class PatternInstanceAsRowExtension(patternInstance: PatternInstance) {
    def asRow: Tables.PatternInstancesRow = {
      Tables.PatternInstancesRow(
        patternInstance.id,
        patternInstance.project,
        patternInstance.pattern,
      )
    }
  }

  implicit class PatternRoleAsRowExtension(patternRole: PatternRole) {
    def asRow: Tables.PatternRolesRow = {
      Tables.PatternRolesRow(
        patternRole.id,
        patternRole.instanceId,
        patternRole.role,
        patternRole.element,
      )
    }
  }

}
