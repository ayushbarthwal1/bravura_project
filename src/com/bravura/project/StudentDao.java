package com.bravura.project;

import java.io.IOException;
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



public class StudentDao {
	

	

public static List<StudentBean> getAllRecords(){
	List<StudentBean> list=new ArrayList<StudentBean>();
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","ayush");
		PreparedStatement ps=conn.prepareStatement("select * from data");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			StudentBean bean=new StudentBean();
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setEmail(rs.getString(4));
			bean.setPhone(rs.getString(5));
			bean.setDepartment(rs.getString(6));
			bean.setGender(rs.getString(7));

			bean.setCity(rs.getString(8));

			bean.setState(rs.getString(9));

			bean.setQualification(rs.getString(10));

			
			list.add(bean);
		}
		conn.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return list;
}


}