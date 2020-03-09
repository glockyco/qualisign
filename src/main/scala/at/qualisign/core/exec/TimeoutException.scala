package at.qualisign.core.exec

import at.qualisign.core.exceptions.NestingException

class TimeoutException(cause: Throwable) extends NestingException(cause) {}
