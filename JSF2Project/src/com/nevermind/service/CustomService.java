package com.nevermind.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService(serviceName="NevermindServiceName", name="NevermindName", portName="NevermindServicePort")
@SOAPBinding(style=Style.DOCUMENT, parameterStyle=ParameterStyle.WRAPPED, use=Use.LITERAL)
public interface CustomService {

	@WebMethod(operationName="welcomeOperation")
	@WebResult(name="greetingResult")
	public String sayHello(@WebParam(name="usernameParam") String name);
	
}
