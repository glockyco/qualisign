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
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for localInstanceVariablesReferencedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="localInstanceVariablesReferencedType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="localInstanceVariableReferenced" type="{jhawk}countableReferenceType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "localInstanceVariablesReferencedType", propOrder = {
    "localInstanceVariableReferenced"
})
public class LocalInstanceVariablesReferencedType {

    @XmlElement(required = true)
    protected List<CountableReferenceType> localInstanceVariableReferenced;

    /**
     * Gets the value of the localInstanceVariableReferenced property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the localInstanceVariableReferenced property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocalInstanceVariableReferenced().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CountableReferenceType }
     * 
     * 
     */
    public List<CountableReferenceType> getLocalInstanceVariableReferenced() {
        if (localInstanceVariableReferenced == null) {
            localInstanceVariableReferenced = new ArrayList<CountableReferenceType>();
        }
        return this.localInstanceVariableReferenced;
    }

}
