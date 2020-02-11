package at.qualisign.patterns.factories

import java.util.UUID

import at.qualisign.domain.{PatternInstance, Project}
import at.qualisign.patterns.jaxb.PatternType

object PatternInstanceFactory {
  def create(project: Project, patternType: PatternType): PatternInstance = {
    PatternInstance(UUID.randomUUID(), project.name, patternType.getName)
  }
}
