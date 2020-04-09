package at.qualisign.metrics.ckjm
import java.io.File

import at.qualisign.metrics.ckjm.jaxb.{CkjmType, ObjectFactory}
import javax.xml.bind.{JAXBContext, JAXBElement}

class CkjmMetricsReaderImpl extends CkjmMetricsReader {
  override def readMetrics(from: File): CkjmType = {
    val context = JAXBContext.newInstance(classOf[ObjectFactory])
    val unmarshaller = context.createUnmarshaller()
    val element = unmarshaller.unmarshal(from).asInstanceOf[JAXBElement[_]]
    element.getValue.asInstanceOf[CkjmType]
  }
}
