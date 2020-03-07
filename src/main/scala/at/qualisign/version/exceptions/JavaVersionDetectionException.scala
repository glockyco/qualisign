package at.qualisign.version.exceptions

import at.qualisign.core.exceptions.NestingException

class JavaVersionDetectionException(cause: Throwable) extends NestingException(cause) {}
