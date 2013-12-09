
package com.nevermind.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for welcomeOperationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="welcomeOperationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="greetingResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "welcomeOperationResponse", propOrder = {
    "greetingResult"
})
public class WelcomeOperationResponse {

    protected String greetingResult;

    /**
     * Gets the value of the greetingResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGreetingResult() {
        return greetingResult;
    }

    /**
     * Sets the value of the greetingResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGreetingResult(String value) {
        this.greetingResult = value;
    }

}
