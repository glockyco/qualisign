package at.qualisign.metrics.exceptions

import at.qualisign.core.exceptions.NestingException

class MetricsCalculationException(cause: Throwable) extends NestingException(cause) {}
