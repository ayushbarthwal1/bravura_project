package com.bravura.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentBean {
private int userid;
private String firstname,lastname,email,phone,department,gender,city,state,qualification;


public StudentBean() {}

public StudentBean(String firstname, String email, String lastname, String phone, String department,String gender ,String city, String state, String qualification)
{
	super();
	this.firstname = firstname;
	this.email = email;
	this.lastname = lastname;
	this.phone = phone;
	this.department = department;
	this.gender = gender;
	this.city = city;
	this.state = state;
	this.qualification = qualification;

	
}



public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getQualification() {
	return qualification;
}

public void setQualification(String qualification) {
	this.qualification = qualification;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public int getUserid() {
	return userid;
}

public void setUserid(int userid) {
	this.userid = userid;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

}
