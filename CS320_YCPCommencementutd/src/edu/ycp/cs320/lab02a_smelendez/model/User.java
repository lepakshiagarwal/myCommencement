package edu.ycp.cs320.lab02a_smelendez.model;

public abstract class User 
{
	private String password;
	private String username;
	
	public User(String username, String password) {
		this.username=username;
		this.password=password;
	}
	public String getPassword()
	{
		return password;
		
	}
	public String getUsername()
	{
		return username;
		
	}
	
	public void setPassword(String pass)
	{
		this.password=pass;
	}
	
	public void setUsername(String name)
	{
		this.username=name;
	}
	

}
