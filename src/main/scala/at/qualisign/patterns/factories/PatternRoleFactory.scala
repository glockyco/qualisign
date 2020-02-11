package at.qualisign.patterns.factories

import java.util.UUID

import at.qualisign.domain.{PatternInstance, PatternRole}
import at.qualisign.patterns.jaxb.RoleType

object PatternRoleFactory {
  def create(patternInstance: PatternInstance, roleType: RoleType): PatternRole = {
    PatternRole(
      UUID.randomUUID(),
      patternInstance.id,
      roleType.getName,
      roleType.getElement,
    )
  }
}
