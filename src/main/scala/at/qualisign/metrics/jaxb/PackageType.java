//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.11.11 at 08:27:51 PM CET 
//


package at.qualisign.metrics.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PackageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PackageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OwningSystem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Metrics" type="{jhawk}PackageMetricsType"/>
 *         &lt;element name="Classes" type="{jhawk}ClassesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PackageType", propOrder = {
    "owningSystem",
    "name",
    "metrics",
    "classes"
})
public class PackageType {

    @XmlElement(name = "OwningSystem", required = true)
    protected String owningSystem;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Metrics", required = true)
    protected PackageMetricsType metrics;
    @XmlElement(name = "Classes")
    protected ClassesType classes;

    /**
     * Gets the value of the owningSystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwningSystem() {
        return owningSystem;
    }

    /**
     * Sets the value of the owningSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwningSystem(String value) {
        this.owningSystem = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the metrics property.
     * 
     * @return
     *     possible object is
     *     {@link PackageMetricsType }
     *     
     */
    public PackageMetricsType getMetrics() {
        return metrics;
    }

    /**
     * Sets the value of the metrics property.
     * 
     * @param value
     *     allowed object is
     *     {@link PackageMetricsType }
     *     
     */
    public void setMetrics(PackageMetricsType value) {
        this.metrics = value;
    }

    /**
     * Gets the value of the classes property.
     * 
     * @return
     *     possible object is
     *     {@link ClassesType }
     *     
     */
    public ClassesType getClasses() {
        return classes;
    }

    /**
     * Sets the value of the classes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassesType }
     *     
     */
    public void setClasses(ClassesType value) {
        this.classes = value;
    }

}
