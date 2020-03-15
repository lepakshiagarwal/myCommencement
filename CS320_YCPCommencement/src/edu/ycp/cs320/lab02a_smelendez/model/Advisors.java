package edu.ycp.cs320.lab02a_smelendez.model;

// model class for GuessingGame
// only the controller should be allowed to call the set methods
// the JSP will call the "get" and "is" methods implicitly
// when the JSP specifies game.min, that gets converted to
//    a call to model.getMin()
// when the JSP specifies if(game.done), that gets converted to
//    a call to model.isDone()
public class Advisors {
	private String username;
	private String password;
	
	public Advisors() 
	{
		
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
	

}
