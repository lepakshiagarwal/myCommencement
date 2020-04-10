package edu.ycp.cs320.comm.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Student extends User {

	private double gpa;
	private String major;
	private String minor;
	private String lastname;
	private String firstname;
	private int advisorId;
	private int studentId;
	
	public Student(String username, String password)
	{
		super(username, password);
	}
	
	public void setMajor(String major) 
	{
		this.major=major;
	}
	public String getMajor() 
	{
		return major;
	}

	public int getAdvisorId() {
		return advisorId;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public double getGpa() {
		return gpa;
	}

	public String getMinor() {
		return minor;
	}

	public void setStudentId(int studentId) {
		this.studentId=studentId;;
		
	}

	public void setAdvisorId(int advisorId) {
		this.advisorId=advisorId;		
	}

	public void setFirstname(String firstname) {
		this.firstname=firstname;
	}

	public void setLastname(String lastname) {
		this.lastname=lastname;
	}

	public void setGpa(double gpa) {
		this.gpa=gpa;		
	}

	public void setMinor(String minor) {
		this.minor=minor;
		
	}
}