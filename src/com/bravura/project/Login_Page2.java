package com.bravura.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login_Page2
 */
@WebServlet("/Login_Page2")
public class Login_Page2 extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		
		
		
		response.setContentType("text/html");
		
		try{  
			
			
			//1.load the driver
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","ayush");
			PreparedStatement st = conn.prepareStatement("select * from login where username=? and password=?");
			st.setString(1, username);
			st.setString(2, password);

			
			ResultSet rs=st.executeQuery();
			
			if(rs.next())
			{
				RequestDispatcher rd=request.getRequestDispatcher("bravo.html");
				rd.include(request, response);
				//out.println("Valid user");
			}
			
			else{
				out.println("Invalid user");
				RequestDispatcher rd=request.getRequestDispatcher("registration2.html");
				rd.include(request, response);
			}
			
			
			
			
		
		}catch(Exception e)
		{
			e.printStackTrace();
			out.println("error"+e);
		}

		  
   
	

}

}
