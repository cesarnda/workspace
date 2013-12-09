
package com.nevermind.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for welcomeOperation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="welcomeOperation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="usernameParam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "welcomeOperation", propOrder = {
    "usernameParam"
})
public class WelcomeOperation {

    protected String usernameParam;

    /**
     * Gets the value of the usernameParam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsernameParam() {
        return usernameParam;
    }

    /**
     * Sets the value of the usernameParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsernameParam(String value) {
        this.usernameParam = value;
    }

}
