package edu.ycp.cs320.comm.controller;

import java.util.ArrayList;

import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;

/**
 * Controller for the Advisor
 */
public class AdvisorController {
	private Advisor model;

	 //Set the model.
	public AdvisorController(Advisor model) {
		this.model = model;
	}
	
	//method to getAdvisee
	public Student getAdvisee(String name) {
		return model.getAdvisee(name);
	}
	
	//adds new advisee
	public void addAdvisee(Student s)
	{
		model.addAdvisee(s);
	}
	
	//finds student and validates password
	public boolean validateCredentials(String name, String password)
	{
		
		//check if username and password is set
		if(model.getUsername()== null || model.getPassword()==null)
		{
			System.out.print("No username and password set");
		}
		
		
		if(name.equals(model.getUsername()) && password.equals(model.getPassword()))
		{
			return true;
		}
		
		return false;
	}
	
	//method to get advices list for a advisor
	public ArrayList<Student> getAdviseeList(){
		return model.adviseeList();
	}
}