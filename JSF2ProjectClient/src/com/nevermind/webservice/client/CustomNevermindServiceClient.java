package com.nevermind.webservice.client;

import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.AddressingFeature;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.MTOMFeature;
import javax.xml.ws.soap.SOAPBinding;

import com.nevermind.service.NevermindName;
import com.nevermind.service.NevermindServiceName;


public class CustomNevermindServiceClient {
	
	@MTOM
	@Addressing
	@WebServiceRef(value=NevermindServiceName.class)
	private NevermindName port;

	public static void main(String ... args) throws SOAPException{
		normalClient();
		normalClientRetrievingThePortDirectly();
		clientWithMTOM();
		clientWithAddressing();
		clientWithMTOMUsingDispatch();
		clientWithMTOMInBinding();
	}
	
	public static void normalClient(){
		NevermindServiceName nevermindServiceName = new NevermindServiceName();
		NevermindName nevermindName = nevermindServiceName.getPort(NevermindName.class);
		System.out.println("Result: "+ nevermindName.welcomeOperation("Client"));
	}
	
	public static void normalClientRetrievingThePortDirectly(){
		NevermindServiceName nevermindServiceName = new NevermindServiceName();
		NevermindName nevermindName = nevermindServiceName.getNevermindServicePort();
		System.out.println("Result: "+ nevermindName.welcomeOperation("Client"));
	}
	
	public static void clientWithMTOM(){
		NevermindServiceName nevermindServiceName = new NevermindServiceName();
		NevermindName nevermindName = nevermindServiceName.getPort(NevermindName.class, new MTOMFeature());
		System.out.println("Result: "+ nevermindName.welcomeOperation("Client"));
	}
	
	public static void clientWithMTOMInBinding(){
		System.out.println("clientWithMTOMInBinding");
		NevermindServiceName nevermindServiceName = new NevermindServiceName();
		NevermindName nevermindName = nevermindServiceName.getNevermindServicePort();
		BindingProvider bindingProvider = BindingProvider.class.cast(nevermindName);
		SOAPBinding soapBinding = SOAPBinding.class.cast(bindingProvider.getBinding());
		soapBinding.setMTOMEnabled(true);
		System.out.println("Result: "+ nevermindName.welcomeOperation("Client"));
	}
	
	public static void clientWithMTOMUsingDispatch() throws SOAPException{
		System.out.println("clientWithMTOMUsingDispatch");
		QName portName = new QName("http://service.nevermind.com/", "NevermindServicePort");
		NevermindServiceName nevermindServiceName = new NevermindServiceName();
		Dispatch<SOAPMessage> dispatch = nevermindServiceName.createDispatch(portName, SOAPMessage.class, Mode.MESSAGE, new MTOMFeature());
		SOAPBinding soapBinding = SOAPBinding.class.cast(dispatch.getBinding());
		soapBinding.setMTOMEnabled(true);
		
		MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
		SOAPMessage request = messageFactory.createMessage();
		SOAPPart soapPart = request.getSOAPPart();
		SOAPEnvelope soapEnvelop = soapPart.getEnvelope();
		SOAPBody soapBody = soapEnvelop.getBody();
		
		SOAPElement operation = soapBody.addChildElement("welcomeOperation", "ns1", "http://service.nevermind.com/");
		SOAPElement value = operation.addChildElement("usernameParam");
		value.addTextNode("Client using Dispatch");
		request.saveChanges();
		
		SOAPMessage soapResponse = dispatch.invoke(request);
		
		SOAPBody bodyResponse = soapResponse.getSOAPBody();
		Iterator<SOAPElement> children = bodyResponse.getChildElements();
		while(children.hasNext()){
			SOAPElement valueResponse = children.next();
			System.out.println("Response from dispatch: " + valueResponse.getTextContent());
		}
	}
	
	public static void clientWithAddressing(){
		NevermindServiceName nevermindServiceName = new NevermindServiceName();
		NevermindName nevermindName = nevermindServiceName.getPort(NevermindName.class, new AddressingFeature());
		System.out.println("Result: "+ nevermindName.welcomeOperation("Client"));
	}
}
