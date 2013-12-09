
package com.nevermind.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.nevermind.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _WelcomeOperation_QNAME = new QName("http://service.nevermind.com/", "welcomeOperation");
    private final static QName _WelcomeOperationResponse_QNAME = new QName("http://service.nevermind.com/", "welcomeOperationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.nevermind.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WelcomeOperation }
     * 
     */
    public WelcomeOperation createWelcomeOperation() {
        return new WelcomeOperation();
    }

    /**
     * Create an instance of {@link WelcomeOperationResponse }
     * 
     */
    public WelcomeOperationResponse createWelcomeOperationResponse() {
        return new WelcomeOperationResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WelcomeOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.nevermind.com/", name = "welcomeOperation")
    public JAXBElement<WelcomeOperation> createWelcomeOperation(WelcomeOperation value) {
        return new JAXBElement<WelcomeOperation>(_WelcomeOperation_QNAME, WelcomeOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WelcomeOperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.nevermind.com/", name = "welcomeOperationResponse")
    public JAXBElement<WelcomeOperationResponse> createWelcomeOperationResponse(WelcomeOperationResponse value) {
        return new JAXBElement<WelcomeOperationResponse>(_WelcomeOperationResponse_QNAME, WelcomeOperationResponse.class, null, value);
    }

}
