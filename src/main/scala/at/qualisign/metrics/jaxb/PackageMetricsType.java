//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.11.11 at 08:27:51 PM CET 
//


package at.qualisign.metrics.jaxb;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Java class for PackageMetricsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PackageMetricsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numberOfClasses" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="numberOfMethods" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="numberOfStatements" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="cumulativeNumberOfComments" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="cumulativeNumberOfCommentLines" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="loc" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="RVF" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="tcc" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="fanin" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="fanout" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="maxcc" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="maintainabilityIndex" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="maintainabilityIndexNC" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="abstractness" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="instability" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="avcc" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="halsteadCumulativeBugs" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="halsteadEffort" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="halsteadCumulativeVolume" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="halsteadCumulativeLength" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PackageMetricsType", propOrder = {

})
public class PackageMetricsType {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfClasses;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfMethods;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfStatements;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger cumulativeNumberOfComments;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger cumulativeNumberOfCommentLines;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger loc;
    @XmlElement(name = "RVF", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger rvf;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger tcc;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger fanin;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger fanout;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger maxcc;
    protected float maintainabilityIndex;
    protected float maintainabilityIndexNC;
    protected float abstractness;
    protected float instability;
    protected float distance;
    protected float avcc;
    protected float halsteadCumulativeBugs;
    protected float halsteadEffort;
    protected float halsteadCumulativeVolume;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger halsteadCumulativeLength;

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
     * Gets the value of the numberOfClasses property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfClasses() {
        return numberOfClasses;
    }

    /**
     * Sets the value of the numberOfClasses property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfClasses(BigInteger value) {
        this.numberOfClasses = value;
    }

    /**
     * Gets the value of the numberOfMethods property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfMethods() {
        return numberOfMethods;
    }

    /**
     * Sets the value of the numberOfMethods property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfMethods(BigInteger value) {
        this.numberOfMethods = value;
    }

    /**
     * Gets the value of the numberOfStatements property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfStatements() {
        return numberOfStatements;
    }

    /**
     * Sets the value of the numberOfStatements property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfStatements(BigInteger value) {
        this.numberOfStatements = value;
    }

    /**
     * Gets the value of the cumulativeNumberOfComments property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCumulativeNumberOfComments() {
        return cumulativeNumberOfComments;
    }

    /**
     * Sets the value of the cumulativeNumberOfComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCumulativeNumberOfComments(BigInteger value) {
        this.cumulativeNumberOfComments = value;
    }

    /**
     * Gets the value of the cumulativeNumberOfCommentLines property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCumulativeNumberOfCommentLines() {
        return cumulativeNumberOfCommentLines;
    }

    /**
     * Sets the value of the cumulativeNumberOfCommentLines property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCumulativeNumberOfCommentLines(BigInteger value) {
        this.cumulativeNumberOfCommentLines = value;
    }

    /**
     * Gets the value of the loc property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLoc() {
        return loc;
    }

    /**
     * Sets the value of the loc property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLoc(BigInteger value) {
        this.loc = value;
    }

    /**
     * Gets the value of the rvf property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRVF() {
        return rvf;
    }

    /**
     * Sets the value of the rvf property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRVF(BigInteger value) {
        this.rvf = value;
    }

    /**
     * Gets the value of the tcc property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTcc() {
        return tcc;
    }

    /**
     * Sets the value of the tcc property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTcc(BigInteger value) {
        this.tcc = value;
    }

    /**
     * Gets the value of the fanin property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFanin() {
        return fanin;
    }

    /**
     * Sets the value of the fanin property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFanin(BigInteger value) {
        this.fanin = value;
    }

    /**
     * Gets the value of the fanout property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFanout() {
        return fanout;
    }

    /**
     * Sets the value of the fanout property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFanout(BigInteger value) {
        this.fanout = value;
    }

    /**
     * Gets the value of the maxcc property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxcc() {
        return maxcc;
    }

    /**
     * Sets the value of the maxcc property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxcc(BigInteger value) {
        this.maxcc = value;
    }

    /**
     * Gets the value of the maintainabilityIndex property.
     * 
     */
    public float getMaintainabilityIndex() {
        return maintainabilityIndex;
    }

    /**
     * Sets the value of the maintainabilityIndex property.
     * 
     */
    public void setMaintainabilityIndex(float value) {
        this.maintainabilityIndex = value;
    }

    /**
     * Gets the value of the maintainabilityIndexNC property.
     * 
     */
    public float getMaintainabilityIndexNC() {
        return maintainabilityIndexNC;
    }

    /**
     * Sets the value of the maintainabilityIndexNC property.
     * 
     */
    public void setMaintainabilityIndexNC(float value) {
        this.maintainabilityIndexNC = value;
    }

    /**
     * Gets the value of the abstractness property.
     * 
     */
    public float getAbstractness() {
        return abstractness;
    }

    /**
     * Sets the value of the abstractness property.
     * 
     */
    public void setAbstractness(float value) {
        this.abstractness = value;
    }

    /**
     * Gets the value of the instability property.
     * 
     */
    public float getInstability() {
        return instability;
    }

    /**
     * Sets the value of the instability property.
     * 
     */
    public void setInstability(float value) {
        this.instability = value;
    }

    /**
     * Gets the value of the distance property.
     * 
     */
    public float getDistance() {
        return distance;
    }

    /**
     * Sets the value of the distance property.
     * 
     */
    public void setDistance(float value) {
        this.distance = value;
    }

    /**
     * Gets the value of the avcc property.
     * 
     */
    public float getAvcc() {
        return avcc;
    }

    /**
     * Sets the value of the avcc property.
     * 
     */
    public void setAvcc(float value) {
        this.avcc = value;
    }

    /**
     * Gets the value of the halsteadCumulativeBugs property.
     * 
     */
    public float getHalsteadCumulativeBugs() {
        return halsteadCumulativeBugs;
    }

    /**
     * Sets the value of the halsteadCumulativeBugs property.
     * 
     */
    public void setHalsteadCumulativeBugs(float value) {
        this.halsteadCumulativeBugs = value;
    }

    /**
     * Gets the value of the halsteadEffort property.
     * 
     */
    public float getHalsteadEffort() {
        return halsteadEffort;
    }

    /**
     * Sets the value of the halsteadEffort property.
     * 
     */
    public void setHalsteadEffort(float value) {
        this.halsteadEffort = value;
    }

    /**
     * Gets the value of the halsteadCumulativeVolume property.
     * 
     */
    public float getHalsteadCumulativeVolume() {
        return halsteadCumulativeVolume;
    }

    /**
     * Sets the value of the halsteadCumulativeVolume property.
     * 
     */
    public void setHalsteadCumulativeVolume(float value) {
        this.halsteadCumulativeVolume = value;
    }

    /**
     * Gets the value of the halsteadCumulativeLength property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHalsteadCumulativeLength() {
        return halsteadCumulativeLength;
    }

    /**
     * Sets the value of the halsteadCumulativeLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setHalsteadCumulativeLength(BigInteger value) {
        this.halsteadCumulativeLength = value;
    }

}
