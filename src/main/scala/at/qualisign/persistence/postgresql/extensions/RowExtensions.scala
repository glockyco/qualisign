package at.qualisign.persistence.postgresql.extensions

import at.qualisign.domain._
import at.qualisign.persistence.Tables

object RowExtensions {

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

}
