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

  implicit class ProjectMetricsJHawkAsRowExtension(metrics: ProjectMetricsJHawk) {
    def asRow: Tables.ProjectMetricsJhawkRow = {
      Tables.ProjectMetricsJhawkRow(
        metrics.project,
        metrics.tl,
        metrics.bl,
        metrics.ci,
        metrics.co,
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

  implicit class PakkageMetricsJHawkAsRowExtension(metrics: PakkageMetricsJHawk) {
    def asRow: Tables.PakkageMetricsJhawkRow = {
      Tables.PakkageMetricsJhawkRow(
        metrics.pakkage,
        metrics.abstractness,
        metrics.avcc,
        metrics.cumulativeNumberOfCommentLines,
        metrics.cumulativeNumberOfComments,
        metrics.distance,
        metrics.fanin,
        metrics.fanout,
        metrics.halsteadCumulativeBugs,
        metrics.halsteadCumulativeLength,
        metrics.halsteadCumulativeVolume,
        metrics.halsteadEffort,
        metrics.instability,
        metrics.loc,
        metrics.maintainabilityIndex,
        metrics.maintainabilityIndexNC,
        metrics.maxcc,
        metrics.numberOfClasses,
        metrics.numberOfMethods,
        metrics.numberOfStatements,
        metrics.rvf,
        metrics.tcc,
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
        metrics.npm,
        metrics.rfc,
        metrics.wmc,
      )
    }
  }

  implicit class ClazzMetricsJHawkAsRowExtension(metrics: ClazzMetricsJHawk) {
    def asRow: Tables.ClazzMetricsJhawkRow = {
      Tables.ClazzMetricsJhawkRow(
        metrics.clazz,
        metrics.avcc,
        metrics.cbo,
        metrics.coh,
        metrics.cumulativeNumberOfCommentLines,
        metrics.cumulativeNumberOfComments,
        metrics.dit,
        metrics.fanIn,
        metrics.fanOut,
        metrics.halsteadCumulativeBugs,
        metrics.halsteadCumulativeLength,
        metrics.halsteadCumulativeVolume,
        metrics.halsteadEffort,
        metrics.lcom,
        metrics.lcom2,
        metrics.loc,
        metrics.maintainabilityIndex,
        metrics.maintainabilityIndexNC,
        metrics.maxcc,
        metrics.messagePassingCoupling,
        metrics.numberOfCommands,
        metrics.numberOfMethods,
        metrics.numberOfQueries,
        metrics.numberOfStatements,
        metrics.numberOfSubClasses,
        metrics.numberOfSuperClasses,
        metrics.responseForClass,
        metrics.reuseRation,
        metrics.revf,
        metrics.six,
        metrics.specializationRation,
        metrics.tcc,
        metrics.unweightedClassSize,
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

  implicit class MethodMetricsJHawkAsRowExtension(metrics: MethodMetricsJHawk) {
    def asRow: Tables.MethodMetricsJhawkRow = {
      Tables.MethodMetricsJhawkRow(
        metrics.method,
        metrics.cyclomaticComplexity,
        metrics.halsteadBugs,
        metrics.halsteadDifficulty,
        metrics.halsteadEffort,
        metrics.halsteadLength,
        metrics.halsteadVocabulary,
        metrics.halsteadVolume,
        metrics.loc,
        metrics.maxDepthOfNesting,
        metrics.numberOfArguments,
        metrics.numberOfCasts,
        metrics.numberOfCommentLines,
        metrics.numberOfComments,
        metrics.numberOfExpressions,
        metrics.numberOfLoops,
        metrics.numberOfOperands,
        metrics.numberOfOperators,
        metrics.numberOfStatements,
        metrics.numberOfVariableDeclarations,
        metrics.numberOfVariableReferences,
        metrics.totalNesting,
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
