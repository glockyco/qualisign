package at.qualisign.metrics

import java.io.File

import at.qualisign.metrics.jaxb.{ObjectFactory, SystemType}
import javax.xml.bind.{JAXBContext, JAXBElement}
import javax.xml.parsers.SAXParserFactory
import org.xml.sax.helpers.XMLFilterImpl
import org.xml.sax.{Attributes, InputSource, SAXException}

class JHawkMetricsReaderImpl extends JHawkMetricsReader {
  override def readMetrics(from: File): SystemType = {
    val context = JAXBContext.newInstance(classOf[ObjectFactory])

    // Create the XMLFilter
    val filter = new NamespaceFilter("jhawk")

    // Set the parent XMLReader on the XMLFilter
    val spf = SAXParserFactory.newInstance
    val sp = spf.newSAXParser
    val xr = sp.getXMLReader
    filter.setParent(xr)

    // Set UnmarshallerHandler as ContentHandler on XMLFilter
    val unmarshaller = context.createUnmarshaller
    val unmarshallerHandler = unmarshaller.getUnmarshallerHandler
    filter.setContentHandler(unmarshallerHandler)

    // Parse the XMLs
    val xml = new InputSource(from.getAbsolutePath)
    filter.parse(xml)

    val element = unmarshallerHandler.getResult.asInstanceOf[JAXBElement[_]]

    element.getValue.asInstanceOf[SystemType]
  }

  class NamespaceFilter(val namespace: String) extends XMLFilterImpl {
    @throws[SAXException]
    override def endElement(uri: String, localName: String, qName: String): Unit = {
      super.endElement(namespace, localName, qName)
    }

    @throws[SAXException]
    override def startElement(uri: String, localName: String, qName: String, atts: Attributes): Unit = {
      super.startElement(namespace, localName, qName, atts)
    }
  }
}
