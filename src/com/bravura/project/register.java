package com.bravura.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
@WebServlet("/save.php")
public class register extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		
		String phone=request.getParameter("phone");

		String department=request.getParameter("department");

		String salary=request.getParameter("salary");
		String gender=request.getParameter("gender");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String qualification=request.getParameter("qualification");
		
		//out.println("done"+First_Name+Salary);
		
		
		try{     
			//1.load the driver
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","ayush");
			PreparedStatement ps=conn.prepareStatement("insert into `data` (`firstname`,`lastname`,`email`,`phone`,`department`,`gender`,`city`,`state`,`qualification`) values (?,?,?,?,?,?,?,?,?)");
			ps.setString(1,firstname);
			ps.setString(2,lastname);
			ps.setString(3,email);
			
			ps.setString(4,phone);
			ps.setString(5,department);
			ps.setString(6,gender);
			ps.setString(7,city);
			ps.setString(8,state);
			ps.setString(9,qualification);
			
			ps.executeUpdate();
			out.println("done");
			
			
		}catch(Exception e)
		{
			out.println("error"+e);
		}

		  
   
	

}}
