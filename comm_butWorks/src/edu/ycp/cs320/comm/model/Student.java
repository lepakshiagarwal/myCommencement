
package edu.ycp.cs320.comm.model;

import java.awt.Image;
import java.io.File;
import java.sql.Blob;
import java.util.List;

public class Student extends User {

	private float gpa;
	private String major;
	private String minor;
	private String lastname;
	private String firstname;
	private int advisorId;
	private int studentId;
	private Blob studentContent;
	private String comment;
	private String status;
	private int QR;
	private String contentURL;
	
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
	public String getContentURL()
	{
		return contentURL;
	}
	
	public void setContentURL(String URL)
	{
		this.contentURL = URL;
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
	
	public void setContent(Blob newContent)
	{
		this.studentContent=newContent;
	}
	
	public Blob getContent()
	{
		return studentContent;
		
	}
	
//	public void setContent(Image img, List<Image> imgs, File Video)
//	{
//		studentContent.setStaticImage(img);
//		studentContent.setSlideShowImgs(imgs);
//		studentContent.setVideoFile(Video);
//	}

	public void setComment(String next) {
		this.comment=next;	
	}

	public void setStatus(String next) {
		this.status=next;
	}

	public String getStatus() {
		return status;
	}

	public String getComment() {
		return comment;
	}
	public void setQR(int QR) {
		this.QR=QR;
		
	}
	public int getQR()
	{
		return studentId;
	}


}