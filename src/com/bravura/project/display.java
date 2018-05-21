package com.bravura.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






/**
 * Servlet implementation class display
 */
@WebServlet("/display")
public class display extends HttpServlet {
	
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		
		
		
		
		
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Records</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		//request.getRequestDispatcher("navaccountant.html").include(request, response);
		out.println("<div class='container'>");
		
		out.print("<h1>View Records</h1>");
	
		List<StudentBean> list=StudentDao.getAllRecords();
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><th>Name</th><th>lastname</th><th>email</th><th>phone</th><th>department</th><th>gender</th><th>city</th><th>state</th><th>qualification</th></tr>");
		for(StudentBean bean:list){
			out.print("<tr><td>"+bean.getFirstname()+"</td><td>"+bean.getLastname()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPhone()+"</td><td>"+bean.getDepartment()+"</td><td>"+bean.getGender()+"</td><td>"+bean.getCity()+"</td><td>"+bean.getState()+"</td><td>"+bean.getQualification()+"</td></tr>");
		}
		out.println("</table>");
		out.println("</div>");
		//request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		//out.close();
		
		
	}
}

