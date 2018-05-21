package com.bravura.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bravoadmin
 */
@WebServlet("/Bravoadmin")
public class Bravoadmin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		
	
		
		
		
		
		
		
		try{     
			//1.load the driver
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","ayush");
			
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery("select * from bravo where counter=(select MAX(counter) from bravo)");
			
			
			
			
			
			while(rs.next())
			{
			out.println("<br>bravo award winner is   -"+rs.getString("ename"));
			
			}
			
			
			
			
			
			
			
		}catch(Exception e)
		{
			out.println("error"+e);
		}

		  
	}}
	