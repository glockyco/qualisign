package at.qualisign.patterns.exceptions

import at.qualisign.core.exceptions.NestingException

class PatternDetectionException(cause: Throwable) extends NestingException(cause) {}
