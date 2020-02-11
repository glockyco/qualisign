package at.qualisign.patterns.exceptions

import at.qualisign.core.exceptions.NestingException

class PatternPersistenceException(cause: Throwable) extends NestingException(cause) {}
