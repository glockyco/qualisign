package at.qualisign.app.processing

import at.qualisign.domain.Project

trait ProcessingStep {
  def execute(project: Project): Either[(Project, Exception), Project]
  def isPending(project: Project): Boolean
}
