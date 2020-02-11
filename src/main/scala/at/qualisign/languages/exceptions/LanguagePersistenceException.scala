package at.qualisign.languages.exceptions

import at.qualisign.core.exceptions.NestingException

class LanguagePersistenceException(cause: Throwable) extends NestingException(cause) {}
