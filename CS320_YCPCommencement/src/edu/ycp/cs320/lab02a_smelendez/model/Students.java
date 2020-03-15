package edu.ycp.cs320.lab02a_smelendez.model;

public class Students extends User {
	private int qrCode;
	
	//inheriting username and password from user class
	public Students(username,password) {
		super(username,password);
	}
	
	//setting qrCode
	public void setQrCode(int qrcode)) {
		this.qrCode = qrCode;
	}
	
	//get method for qrCode
	public Double getQrCode() {
		return qrCode;
	}
	
}
