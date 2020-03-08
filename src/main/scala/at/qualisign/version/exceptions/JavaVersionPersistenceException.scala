package at.qualisign.version.exceptions

import at.qualisign.core.exceptions.NestingException

class JavaVersionPersistenceException(cause: Throwable) extends NestingException(cause) {}
