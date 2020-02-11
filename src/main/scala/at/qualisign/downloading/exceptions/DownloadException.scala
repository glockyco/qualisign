package at.qualisign.downloading.exceptions

import at.qualisign.core.exceptions.NestingException

class DownloadException(cause: Throwable) extends NestingException(cause) {}
