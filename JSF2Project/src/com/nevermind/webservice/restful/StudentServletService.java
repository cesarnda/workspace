package com.nevermind.webservice.restful;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.nevermind.entity.Student;
import com.nevermind.entity.StudentsList;
import com.nevermind.entity.finder.StudentFinder;

/**
 * Servlet implementation class StudentServletService
 */
@WebServlet(urlPatterns={"/StudentServletService"}, loadOnStartup=1)
public class StudentServletService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentFinder studentFinder;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServletService() {
        super();
        try {
			studentFinder = new StudentFinder();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null){
			System.err.println("The ID is null");
		}
		
		Student student = studentFinder.getUniqueStudent(Long.valueOf(id));
		StudentsList studentsList = new StudentsList();
		studentsList.getStudents().add(student);
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(StudentsList.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			PrintWriter writer = response.getWriter();
			marshaller.marshal(studentsList, writer);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
	}

}
