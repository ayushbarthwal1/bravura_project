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
 * Servlet implementation class Register2
 */
@WebServlet("/Register2")
public class Register2 extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		try{     
			//1.load the driver
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","ayush");
			PreparedStatement ps=conn.prepareStatement("insert into `login` (`username`,`password`) values (?,?)");
			ps.setString(1,username);
			ps.setString(2,password);
			
			
			ps.executeUpdate();
			out.println("done");
			
			
		}catch(Exception e)
		{
			out.println("error"+e);
		}

		  
   
	

}
}
