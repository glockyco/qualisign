package at.qualisign.patterns
import java.io.File

import at.qualisign.patterns.jaxb.{ObjectFactory, SystemType}
import javax.xml.bind.{JAXBContext, JAXBElement}

class SsaPatternReaderImpl extends SsaPatternReader {
  override def readPatterns(from: File): SystemType = {
    val context = JAXBContext.newInstance(classOf[ObjectFactory])
    val unmarshaller = context.createUnmarshaller()
    val element = unmarshaller.unmarshal(from).asInstanceOf[JAXBElement[_]]
    element.getValue.asInstanceOf[SystemType]
  }
}
