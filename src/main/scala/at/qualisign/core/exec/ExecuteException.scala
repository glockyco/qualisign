package at.qualisign.core.exec

import at.qualisign.core.exceptions.NestingException

class ExecuteException(cause: Throwable) extends NestingException(cause) {}
