package at.qualisign.core.exceptions

import java.io.{PrintWriter, StringWriter}

// Adapted from: https://www.javaworld.com/article/2077595/java-tip-91--use-nested-exceptions-in-a-multitiered-environment.html

object NestingException {
  // String representation of stack trace - not transient!
  // Convert a stack trace to a String so it can be serialized.
  def generateStackTraceString(t: Throwable): String = {
    val s = new StringWriter
    t.printStackTrace(new PrintWriter(s))
    s.toString
  }
}

class NestingException(message: String) extends Exception(message) {
  private var nestedException: Throwable = _
  private var stackTraceString: String = _

  def this() {
    this("")
  }

  def this(nestedException: Throwable) {
    this()
    this.nestedException = nestedException
    stackTraceString = NestingException.generateStackTraceString(nestedException)
  }

  def this(message: String, nestedException: Throwable) {
    this(message)
    this.nestedException = nestedException
    stackTraceString = NestingException.generateStackTraceString(nestedException)
  }

  def getNestedException: Throwable = nestedException

  // Descend through linked-list of nesting exceptions, & output trace,
  // displaying the 'deepest' trace first.
  def getStackTraceString: String = {
    // If there's no nested exception, there's no stackTrace.
    if (nestedException == null) {
      return null
    }

    val traceBuffer = new StringBuffer

    nestedException match {
      case exception: NestingException =>
        traceBuffer.append(exception.getStackTraceString)
        traceBuffer.append("-------- nested by:\n")
      case _ =>
    }

    traceBuffer.append(stackTraceString)
    traceBuffer.toString
  }

  override def getMessage: String = {
    val superMessage = super.getMessage

    // If there's no nested exception, do like we would always do.
    if (getNestedException == null) {
      return superMessage
    }

    val theMessage = new StringBuffer
    // Get the nested exception's message.
    val nestedMessage = getNestedException.getMessage

    if (superMessage != null && !superMessage.isEmpty) {
      theMessage.append(superMessage).append(": ").append(nestedMessage)
    } else {
      theMessage.append(nestedMessage)
    }
    theMessage.toString
  }

  override def toString: String = {
    val theMessage = new StringBuffer(super.toString)
    if (getNestedException != null) {
      theMessage.append("; \n\t---> nested ").append(getNestedException)
    }
    theMessage.toString
  }
}