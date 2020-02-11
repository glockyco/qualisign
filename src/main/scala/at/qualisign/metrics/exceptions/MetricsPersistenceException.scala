package at.qualisign.metrics.exceptions

import at.qualisign.core.exceptions.NestingException

class MetricsPersistenceException(cause: Throwable) extends NestingException(cause) {}
