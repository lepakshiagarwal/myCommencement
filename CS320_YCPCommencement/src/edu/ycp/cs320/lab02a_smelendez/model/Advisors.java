package edu.ycp.cs320.lab02a_smelendez.model;

// model class for Advisor
//type of user, inherits username and password
public class Advisors inherits User{
	
	String username, password;
	int qrCode;
	public Advisors() {
	}
	
	public void setUsername(String userName) 
	{
		this.username=userName;
	}
	
	public String getUsername() 
	{
		return username;
	}
	
	public void setPassword(String passWord) {
		this.password = passWord;
	}
	
	public String getPassword() {
		return password;
	}
		//setting qrCode
	public void setQrCode(int qrcode)) {
		this.qrCode = qrCode;
	}

	//get method for qrCode
	public int getQrCode() {
		return qrCode;
	}
	
	public boolean isValid() {
		if(test1 == getUsername() ) {
			if(test2 == getPassword() ) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}