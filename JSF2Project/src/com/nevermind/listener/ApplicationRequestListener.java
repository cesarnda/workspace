package com.nevermind.listener;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class ApplicationRequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("Request destroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		HttpServletRequest request = HttpServletRequest.class.cast(event.getServletRequest());
		StringBuffer parameterValue = new StringBuffer("?");
		Map<String, String[]> parameterMap = request.getParameterMap();
		
		for(Entry<String, String[]> entry : parameterMap.entrySet()){
			parameterValue.append(entry.getKey() + "=" + entry.getValue() + "&");
		}
		
		System.out.println("Request created: " + request.getRequestURL() + parameterValue.toString().substring(0, parameterValue.length() - 1));
	}

}
