package edu.ycp.cs320.comm.model;

import java.awt.Image;
import java.io.File;
import java.util.List;

public class Student extends User {

	private float gpa;
	private String major;
	private String minor;
	private String lastname;
	private String firstname;
	private int advisorId;
	private int studentId;
	private Content studentContent;
	
	public Student(String username, String password)
	{
		super(username, password);
	}
	
	public Student()
	{
		super(null,null);
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

	public float getGpa() {
		return gpa;
	}

	public String getMinor() {
		return minor;
	}

	public void setStudentId(int studentId) {
		this.studentId=studentId;;
		
	}
	public int getStudentId()
	{
		return studentId;
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

	public void setGpa(float gpa) {
		this.gpa=gpa;		
	}

	public void setMinor(String minor) {
		this.minor=minor;
		
	}
	
	public void setContent(Content newContent)
	{
		this.studentContent=newContent;
	}
	
	public Content getContent()
	{
		return studentContent;
		
	}
	
	public void setContent(Image img, List<Image> imgs, File Video)
	{
		studentContent.setStaticImage(img);
		studentContent.setSlideShowImgs(imgs);
		studentContent.setVideoFile(Video);
	}
	
}