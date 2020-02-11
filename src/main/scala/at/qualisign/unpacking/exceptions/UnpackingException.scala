package at.qualisign.unpacking.exceptions

import at.qualisign.core.exceptions.NestingException

class UnpackingException(cause: Throwable) extends NestingException(cause) {}
