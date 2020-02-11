package at.qualisign.domain

case class ProjectMetrics(
  project: String,
  tl: Int,
  bl: Int,
  ci: Int,
  co: Int,
)
