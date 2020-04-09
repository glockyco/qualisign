package at.qualisign.persistence.postgresql.extensions

import at.qualisign.domain._
import at.qualisign.persistence.Tables

object RowExtensions {

  implicit class ClazzesRowAsDomainExtension(row: Tables.ClazzesRow) {
    def asDomain: Clazz = {
      Clazz(
        row.pakkage,
        row.name,
      )
    }
  }

  implicit class ClazzMetricsRowAsDomainExtension(row: Tables.ClazzMetricsJhawkRow) {
    def asDomain: ClazzMetricsJHawk = {
      ClazzMetricsJHawk(
        row.clazz,
        row.avcc,
        row.cbo,
        row.coh,
        row.cumulativeNumberOfCommentLines,
        row.cumulativeNumberOfComments,
        row.dit,
        row.fanIn,
        row.fanOut,
        row.halsteadCumulativeBugs,
        row.halsteadCumulativeLength,
        row.halsteadCumulativeVolume,
        row.halsteadEffort,
        row.lcom,
        row.lcom2,
        row.loc,
        row.maintainabilityIndex,
        row.maintainabilityIndexNc,
        row.maxcc,
        row.messagePassingCoupling,
        row.numberOfCommands,
        row.numberOfMethods,
        row.numberOfQueries,
        row.numberOfStatements,
        row.numberOfSubClasses,
        row.numberOfSuperClasses,
        row.responseForClass,
        row.reuseRation,
        row.revf,
        row.six,
        row.specializationRation,
        row.tcc,
        row.unweightedClassSize,
      )
    }
  }

  implicit class MethodsRowAsDomainExtension(row: Tables.MethodsRow) {
    def asDomain: Method = {
      Method(
        row.clazz,
        row.name,
      )
    }
  }

  implicit class MethodMetricsRowAsDomainExtension(row: Tables.MethodMetricsJhawkRow) {
    def asDomain: MethodMetricsJHawk = {
      MethodMetricsJHawk(
        row.method,
        row.cyclomaticComplexity,
        row.halsteadBugs,
        row.halsteadDifficulty,
        row.halsteadEffort,
        row.halsteadLength,
        row.halsteadVocabulary,
        row.halsteadVolume,
        row.loc,
        row.maxDepthOfNesting,
        row.numberOfArguments,
        row.numberOfCasts,
        row.numberOfCommentLines,
        row.numberOfComments,
        row.numberOfExpressions,
        row.numberOfLoops,
        row.numberOfOperands,
        row.numberOfOperators,
        row.numberOfStatements,
        row.numberOfVariableDeclarations,
        row.numberOfVariableReferences,
        row.totalNesting,
      )
    }
  }

  implicit class PakkagesRowAsDomainExtension(row: Tables.PakkagesRow) {
    def asDomain: Pakkage = {
      Pakkage(
        row.project,
        row.name,
      )
    }
  }

  implicit class PakkageMetricsRowAsDomainExtension(row: Tables.PakkageMetricsJhawkRow) {
    def asDomain: PakkageMetricsJHawk = {
      PakkageMetricsJHawk(
        row.pakkage,
        row.abstractness,
        row.avcc,
        row.cumulativeNumberOfCommentLines,
        row.cumulativeNumberOfComments,
        row.distance,
        row.fanin,
        row.fanout,
        row.halsteadCumulativeBugs,
        row.halsteadCumulativeLength,
        row.halsteadCumulativeVolume,
        row.halsteadEffort,
        row.instability,
        row.loc,
        row.maintainabilityIndex,
        row.maintainabilityIndexNc,
        row.maxcc,
        row.numberOfClasses,
        row.numberOfMethods,
        row.numberOfStatements,
        row.rvf,
        row.tcc,
      )
    }
  }

  implicit class ProjectsRowAsDomainExtension(row: Tables.ProjectsRow) {
    def asDomain: Project = {
      Project(
        row.name,
        row.groupId,
        row.artifactId,
        row.version,
        row.hasSources,
        row.jarsDownloadStatus,
        row.jarsUnpackingStatus,
        row.languageDetectionStatus,
        row.languagePersistenceStatus,
        row.metricsCalculationStatus,
        row.metricsPersistenceStatus,
        row.patternDetectionStatus,
        row.patternPersistenceStatus,
        row.javaVersionDetectionStatus,
        row.javaVersionPersistenceStatus,
        row.javaVersion,
      )
    }
  }

  implicit class ProjectMetricsRowAsDomainExtension(row: Tables.ProjectMetricsJhawkRow) {
    def asDomain: ProjectMetricsJHawk = {
      ProjectMetricsJHawk(
        row.project,
        row.tl,
        row.bl,
        row.ci,
        row.co,
      )
    }
  }

}
