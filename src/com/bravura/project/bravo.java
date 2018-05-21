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
 * Servlet implementation class bravo
 this is edited by ayush
 edited twice
 */
@WebServlet("/bravo")

public class bravo extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		
		String ename=request.getParameter("ename");
		out.println(ename);
		
		
		
		//out.println("done"+First_Name+Salary);
		
		
		try{     
			//1.load the driver
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","ayush");
			
			PreparedStatement st = conn.prepareStatement("select * from bravo where ename=?");
			st.setString(1, ename);

			
			ResultSet rs=st.executeQuery();
			int counter = 5;
			while(rs.next())
			{
				counter=rs.getInt("counter");
				//out.println(counter);
			}
			
			
			counter=counter+1;
			
			
			
			
			PreparedStatement ps=conn.prepareStatement("update bravo set counter=? where ename=?");
			
			ps.setInt(1, counter);
		ps.setString(2, ename);
			
			ps.executeUpdate();
			
			
		}catch(Exception e)
		{
			out.println("error"+e);
		}

		  
   
	

}}