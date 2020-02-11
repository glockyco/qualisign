package at.qualisign.domain

object Project {
  def apply(
    groupId: String,
    artifactId: String,
    version: String,
    hasSources: Boolean,
  ): Project = {
    val name: String = s"${groupId}.${artifactId}.${version}"

    Project(
      name,
      groupId,
      artifactId,
      version,
      hasSources,
      ProcessingStatus.PENDING,
      ProcessingStatus.PENDING,
      ProcessingStatus.PENDING,
      ProcessingStatus.PENDING,
      ProcessingStatus.PENDING,
      ProcessingStatus.PENDING,
      ProcessingStatus.PENDING,
      ProcessingStatus.PENDING,
    )
  }
}

case class Project(
  name: String,
  groupId: String,
  artifactId: String,
  version: String,
  hasSources: Boolean,
  jarDownloadStatus: Int,
  jarUnpackingStatus: Int,
  languageDetectionStatus: Int,
  languagePersistenceStatus: Int,
  metricsCalculationStatus: Int,
  metricsPersistenceStatus: Int,
  patternDetectionStatus: Int,
  patternPersistenceStatus: Int,
)
