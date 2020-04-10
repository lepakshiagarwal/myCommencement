package edu.ycp.cs320.comm.model;

public class User {
	protected String password;
	protected String username;
	
	//user constructor
	public User(String username, String password) {
		this.username=username;
		this.password=password;
	}
	
	//get password method
	public String getPassword()
	{
		return password;
		
	}
	
	//get username method
	public String getUsername()
	{
		return username;
		
	}
	
	//set password method
	public void setPassword(String pass)
	{
		this.password=pass;
	}
	
	//set username method
	public void setUsername(String name)
	{
		this.username=name;
	}
}