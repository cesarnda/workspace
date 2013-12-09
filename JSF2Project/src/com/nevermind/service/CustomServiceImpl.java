package com.nevermind.service;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(endpointInterface="com.nevermind.service.CustomService", serviceName="NevermindServiceName", name="NevermindName", portName="NevermindServicePort")
public class CustomServiceImpl implements CustomService {

	@Override
	public String sayHello(String name) {
		return "Nevermind's services says hi " + name;
	}

	public static void main(String ... args){
		Endpoint.publish("http://localhost:10000/nevermind", new CustomServiceImpl());
	}
	
}
