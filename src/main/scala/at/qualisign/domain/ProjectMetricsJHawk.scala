package at.qualisign.domain

case class ProjectMetricsJHawk(
  project: String,
  tl: Int,
  bl: Int,
  ci: Int,
  co: Int,
)
