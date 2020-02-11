package at.qualisign.languages.exceptions

import at.qualisign.core.exceptions.NestingException

class LanguageDetectionException(cause: Throwable) extends NestingException(cause) {}
