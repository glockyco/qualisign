package at.qualisign.domain

import java.util.UUID

case class PatternRole(
  id: UUID,
  instanceId: UUID,
  role: String,
  element: String,
)
