package edu.ycp.cs320.comm.controller;

import java.util.ArrayList;

import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;

/**
 * Controller for the Advisor
 */
public class StudentController {
	private Student model;

	 //Set the model.
	public StudentController(Student model) {
		this.model = model;
	}
	
	//method to check username
	public boolean checkUserName(String name)
	{
		if(name.equals(model.getUsername()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//method to validate password
	public boolean validateCredentials(String name, String password) 
	{
		if(checkUserName(name) && password.equals(model.getPassword()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
}