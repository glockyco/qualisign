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
 * <p>Java class for ClassMetricsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClassMetricsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="superclass" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="loc" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="dit" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="numberOfSuperclasses" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="numberOfSubclasses" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="numberOfMethods" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="numberOfCommands" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="numberOfQueries" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="numberOfStatements" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="cumulativeNumberOfComments" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="cumulativeNumberOfCommentLines" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="fanIn" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="fanOut" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="messagePassingCoupling" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="unweightedClassSize" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="responseForClass" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="maxcc" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="cbo" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="tcc" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="maintainabilityIndex" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="maintainabilityIndexNC" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="specializationRatio" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="reuseRatio" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="lcom" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="lcom2" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="avcc" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="coh" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="six" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="REVF" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="halsteadCumulativeBugs" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="halsteadEffort" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="halsteadCumulativeVolume" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="halsteadCumulativeLength" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="importedPackages" type="{jhawk}importedPackagesType" minOccurs="0"/>
 *         &lt;element name="classesReferenced" type="{jhawk}classesReferencedType" minOccurs="0"/>
 *         &lt;element name="localMethodCalls" type="{jhawk}localMethodCallsType" minOccurs="0"/>
 *         &lt;element name="externalMethodCalls" type="{jhawk}externalMethodCallsType" minOccurs="0"/>
 *         &lt;element name="externalMethodsCalled" type="{jhawk}externalMethodsCalledType" minOccurs="0"/>
 *         &lt;element name="hierarchyMethodCalls" type="{jhawk}hierarchyMethodCallsType" minOccurs="0"/>
 *         &lt;element name="interfaces" type="{jhawk}interfacesType" minOccurs="0"/>
 *         &lt;element name="modifiers" type="{jhawk}modifiersType" minOccurs="0"/>
 *         &lt;element name="instanceVariables" type="{jhawk}instanceVariablesType" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassMetricsType", propOrder = {

})
public class ClassMetricsType {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String superclass;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger loc;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger dit;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfSuperclasses;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfSubclasses;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfMethods;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfCommands;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfQueries;
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
    protected BigInteger fanIn;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger fanOut;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger messagePassingCoupling;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger unweightedClassSize;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger responseForClass;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger maxcc;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger cbo;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger tcc;
    protected float maintainabilityIndex;
    protected float maintainabilityIndexNC;
    protected float specializationRatio;
    protected float reuseRatio;
    protected float lcom;
    protected float lcom2;
    protected float avcc;
    protected float coh;
    protected float six;
    @XmlElement(name = "REVF")
    protected float revf;
    protected float halsteadCumulativeBugs;
    protected float halsteadEffort;
    protected float halsteadCumulativeVolume;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger halsteadCumulativeLength;
    protected ImportedPackagesType importedPackages;
    protected ClassesReferencedType classesReferenced;
    protected LocalMethodCallsType localMethodCalls;
    protected ExternalMethodCallsType externalMethodCalls;
    protected ExternalMethodsCalledType externalMethodsCalled;
    protected HierarchyMethodCallsType hierarchyMethodCalls;
    protected InterfacesType interfaces;
    protected ModifiersType modifiers;
    protected InstanceVariablesType instanceVariables;

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
     * Gets the value of the superclass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuperclass() {
        return superclass;
    }

    /**
     * Sets the value of the superclass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuperclass(String value) {
        this.superclass = value;
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
     * Gets the value of the dit property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDit() {
        return dit;
    }

    /**
     * Sets the value of the dit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDit(BigInteger value) {
        this.dit = value;
    }

    /**
     * Gets the value of the numberOfSuperclasses property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfSuperclasses() {
        return numberOfSuperclasses;
    }

    /**
     * Sets the value of the numberOfSuperclasses property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfSuperclasses(BigInteger value) {
        this.numberOfSuperclasses = value;
    }

    /**
     * Gets the value of the numberOfSubclasses property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfSubclasses() {
        return numberOfSubclasses;
    }

    /**
     * Sets the value of the numberOfSubclasses property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfSubclasses(BigInteger value) {
        this.numberOfSubclasses = value;
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
     * Gets the value of the numberOfCommands property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfCommands() {
        return numberOfCommands;
    }

    /**
     * Sets the value of the numberOfCommands property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfCommands(BigInteger value) {
        this.numberOfCommands = value;
    }

    /**
     * Gets the value of the numberOfQueries property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfQueries() {
        return numberOfQueries;
    }

    /**
     * Sets the value of the numberOfQueries property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfQueries(BigInteger value) {
        this.numberOfQueries = value;
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
     * Gets the value of the fanIn property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFanIn() {
        return fanIn;
    }

    /**
     * Sets the value of the fanIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFanIn(BigInteger value) {
        this.fanIn = value;
    }

    /**
     * Gets the value of the fanOut property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFanOut() {
        return fanOut;
    }

    /**
     * Sets the value of the fanOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFanOut(BigInteger value) {
        this.fanOut = value;
    }

    /**
     * Gets the value of the messagePassingCoupling property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMessagePassingCoupling() {
        return messagePassingCoupling;
    }

    /**
     * Sets the value of the messagePassingCoupling property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMessagePassingCoupling(BigInteger value) {
        this.messagePassingCoupling = value;
    }

    /**
     * Gets the value of the unweightedClassSize property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUnweightedClassSize() {
        return unweightedClassSize;
    }

    /**
     * Sets the value of the unweightedClassSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUnweightedClassSize(BigInteger value) {
        this.unweightedClassSize = value;
    }

    /**
     * Gets the value of the responseForClass property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getResponseForClass() {
        return responseForClass;
    }

    /**
     * Sets the value of the responseForClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setResponseForClass(BigInteger value) {
        this.responseForClass = value;
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
     * Gets the value of the cbo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCbo() {
        return cbo;
    }

    /**
     * Sets the value of the cbo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCbo(BigInteger value) {
        this.cbo = value;
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
     * Gets the value of the specializationRatio property.
     * 
     */
    public float getSpecializationRatio() {
        return specializationRatio;
    }

    /**
     * Sets the value of the specializationRatio property.
     * 
     */
    public void setSpecializationRatio(float value) {
        this.specializationRatio = value;
    }

    /**
     * Gets the value of the reuseRatio property.
     * 
     */
    public float getReuseRatio() {
        return reuseRatio;
    }

    /**
     * Sets the value of the reuseRatio property.
     * 
     */
    public void setReuseRatio(float value) {
        this.reuseRatio = value;
    }

    /**
     * Gets the value of the lcom property.
     * 
     */
    public float getLcom() {
        return lcom;
    }

    /**
     * Sets the value of the lcom property.
     * 
     */
    public void setLcom(float value) {
        this.lcom = value;
    }

    /**
     * Gets the value of the lcom2 property.
     * 
     */
    public float getLcom2() {
        return lcom2;
    }

    /**
     * Sets the value of the lcom2 property.
     * 
     */
    public void setLcom2(float value) {
        this.lcom2 = value;
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
     * Gets the value of the coh property.
     * 
     */
    public float getCoh() {
        return coh;
    }

    /**
     * Sets the value of the coh property.
     * 
     */
    public void setCoh(float value) {
        this.coh = value;
    }

    /**
     * Gets the value of the six property.
     * 
     */
    public float getSix() {
        return six;
    }

    /**
     * Sets the value of the six property.
     * 
     */
    public void setSix(float value) {
        this.six = value;
    }

    /**
     * Gets the value of the revf property.
     * 
     */
    public float getREVF() {
        return revf;
    }

    /**
     * Sets the value of the revf property.
     * 
     */
    public void setREVF(float value) {
        this.revf = value;
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

    /**
     * Gets the value of the importedPackages property.
     * 
     * @return
     *     possible object is
     *     {@link ImportedPackagesType }
     *     
     */
    public ImportedPackagesType getImportedPackages() {
        return importedPackages;
    }

    /**
     * Sets the value of the importedPackages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportedPackagesType }
     *     
     */
    public void setImportedPackages(ImportedPackagesType value) {
        this.importedPackages = value;
    }

    /**
     * Gets the value of the classesReferenced property.
     * 
     * @return
     *     possible object is
     *     {@link ClassesReferencedType }
     *     
     */
    public ClassesReferencedType getClassesReferenced() {
        return classesReferenced;
    }

    /**
     * Sets the value of the classesReferenced property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassesReferencedType }
     *     
     */
    public void setClassesReferenced(ClassesReferencedType value) {
        this.classesReferenced = value;
    }

    /**
     * Gets the value of the localMethodCalls property.
     * 
     * @return
     *     possible object is
     *     {@link LocalMethodCallsType }
     *     
     */
    public LocalMethodCallsType getLocalMethodCalls() {
        return localMethodCalls;
    }

    /**
     * Sets the value of the localMethodCalls property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalMethodCallsType }
     *     
     */
    public void setLocalMethodCalls(LocalMethodCallsType value) {
        this.localMethodCalls = value;
    }

    /**
     * Gets the value of the externalMethodCalls property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalMethodCallsType }
     *     
     */
    public ExternalMethodCallsType getExternalMethodCalls() {
        return externalMethodCalls;
    }

    /**
     * Sets the value of the externalMethodCalls property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalMethodCallsType }
     *     
     */
    public void setExternalMethodCalls(ExternalMethodCallsType value) {
        this.externalMethodCalls = value;
    }

    /**
     * Gets the value of the externalMethodsCalled property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalMethodsCalledType }
     *     
     */
    public ExternalMethodsCalledType getExternalMethodsCalled() {
        return externalMethodsCalled;
    }

    /**
     * Sets the value of the externalMethodsCalled property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalMethodsCalledType }
     *     
     */
    public void setExternalMethodsCalled(ExternalMethodsCalledType value) {
        this.externalMethodsCalled = value;
    }

    /**
     * Gets the value of the hierarchyMethodCalls property.
     * 
     * @return
     *     possible object is
     *     {@link HierarchyMethodCallsType }
     *     
     */
    public HierarchyMethodCallsType getHierarchyMethodCalls() {
        return hierarchyMethodCalls;
    }

    /**
     * Sets the value of the hierarchyMethodCalls property.
     * 
     * @param value
     *     allowed object is
     *     {@link HierarchyMethodCallsType }
     *     
     */
    public void setHierarchyMethodCalls(HierarchyMethodCallsType value) {
        this.hierarchyMethodCalls = value;
    }

    /**
     * Gets the value of the interfaces property.
     * 
     * @return
     *     possible object is
     *     {@link InterfacesType }
     *     
     */
    public InterfacesType getInterfaces() {
        return interfaces;
    }

    /**
     * Sets the value of the interfaces property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterfacesType }
     *     
     */
    public void setInterfaces(InterfacesType value) {
        this.interfaces = value;
    }

    /**
     * Gets the value of the modifiers property.
     * 
     * @return
     *     possible object is
     *     {@link ModifiersType }
     *     
     */
    public ModifiersType getModifiers() {
        return modifiers;
    }

    /**
     * Sets the value of the modifiers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifiersType }
     *     
     */
    public void setModifiers(ModifiersType value) {
        this.modifiers = value;
    }

    /**
     * Gets the value of the instanceVariables property.
     * 
     * @return
     *     possible object is
     *     {@link InstanceVariablesType }
     *     
     */
    public InstanceVariablesType getInstanceVariables() {
        return instanceVariables;
    }

    /**
     * Sets the value of the instanceVariables property.
     * 
     * @param value
     *     allowed object is
     *     {@link InstanceVariablesType }
     *     
     */
    public void setInstanceVariables(InstanceVariablesType value) {
        this.instanceVariables = value;
    }

}
