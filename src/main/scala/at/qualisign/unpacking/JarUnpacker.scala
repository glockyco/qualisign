package at.qualisign.unpacking

import java.io.File

trait JarUnpacker {
  def unpack(from: File, to: File): Unit
}
