package edu.ycp.cs320.comm.model;

public class Student extends User {
	int qrCode;
	
	//studnet is a user
	public Student(String username, String password) {
		super(username,password);
	}
	
	//get qrcode
	public int getQrCode() {
		return qrCode;
	}
	
	//set qrcode
	public void setQrCode(int qr) {
		this.qrCode=qr;
	}
}
