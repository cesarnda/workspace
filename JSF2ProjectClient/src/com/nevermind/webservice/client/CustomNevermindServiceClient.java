package com.nevermind.webservice.client;

import com.nevermind.service.NevermindName;
import com.nevermind.service.NevermindServiceName;


public class CustomNevermindServiceClient {

	public static void main(String ... args){
		normalClient();
	}
	
	public static void normalClient(){
		NevermindServiceName nevermindServiceName = new NevermindServiceName();
		NevermindName nevermindName = nevermindServiceName.getPort(NevermindName.class);
		System.out.println("Result: "+ nevermindName.welcomeOperation("Client"));
	}
	
}
