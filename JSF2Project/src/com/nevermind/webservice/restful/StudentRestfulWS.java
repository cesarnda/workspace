package com.nevermind.webservice.restful;

import java.net.UnknownHostException;

import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.ws.BindingType;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

import org.w3c.dom.Document;

import com.nevermind.entity.Student;
import com.nevermind.entity.StudentsList;
import com.nevermind.entity.finder.StudentFinder;

@WebServiceProvider
@ServiceMode(Mode.MESSAGE)
@BindingType(HTTPBinding.HTTP_BINDING)
public class StudentRestfulWS implements Provider<Source> {

	private StudentFinder studentFinder;
	
	// Weblogic 12.1.1 seems to have a bug with the resource
	// annotation and the WebServiceContext. So a name has to 
	// be specified
	@Resource(name="webServiceContext")
	private WebServiceContext webServiceContext;
	
	public StudentRestfulWS(){
		try {
			studentFinder = new StudentFinder();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Source invoke(Source request) {
		if(webServiceContext == null){
			throw new RuntimeException("Injection failed on WebServiceContext");
		}
		
		MessageContext messageContext = webServiceContext.getMessageContext();
		Object queryObject = messageContext.get(MessageContext.QUERY_STRING);
		String query = queryObject.toString();
		String[] queryArray = query.split("=");
		if(!"id".equals(queryArray[0].toLowerCase())){
			return null;
		}
		
		String id = queryArray[1];
		if(id == null){
			System.err.println("The ID is null");
		}
		
		Student student = studentFinder.getUniqueStudent(Long.valueOf(id));
		StudentsList studentsList = new StudentsList();
		studentsList.getStudents().add(student);
		return getXML(studentsList);
	}
	
	private Source getXML(StudentsList studentsList){
		Document document = null;
		
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(StudentsList.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			
			DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			document = parser.newDocument();
			marshaller.marshal(studentsList, document);
			
		} catch (JAXBException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new DOMSource(document);
		
	}

	public WebServiceContext getWebServiceContext() {
		return webServiceContext;
	}

	public void setWebServiceContext(WebServiceContext webServiceContext) {
		this.webServiceContext = webServiceContext;
	}

	public static void main(String ... args){
		int port = 9000;
		String url = "http://localhost:" + port + "/";
		Endpoint.publish(url, new StudentRestfulWS());
	}

}
