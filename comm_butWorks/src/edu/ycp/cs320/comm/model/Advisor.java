package edu.ycp.cs320.comm.model;

import java.util.ArrayList;

public class Advisor extends User
{
	private ArrayList<Student> advisees;
	private String lastname;
	private int advisorId;
	private String firstname;
	
	public Advisor(String username, String password) 
	{
		super(username, password);
		advisees = new ArrayList<Student>();
	}
	
	
	public Advisor() 
	{
		super(null, null);
		advisees = new ArrayList<Student>();
	}


	//adds new advisee
	public void addAdvisee(Student s)
	{
		advisees.add(s);
	}
	
	
	
	//finds student if it exists
	public Student getAdvisee(String username) 
	{
		try
		{
			for(Student s : advisees)
			{
				if(s.getUsername().equals(username))
				{
					return s;
				}
			}
		}
		catch(NullPointerException e)
		{
			System.out.print("Null pointer exception, no advisees for advisor");
		}
		return null;
	}
	
		
	public ArrayList<Student> adviseeList()
	{
		return advisees;
	}


	public void setLastname(String lastname ) {
		this.lastname=lastname;	
	}


	public void setAdvisorId(int int1) {
		this.advisorId=int1;	
	}
	
	public int getAdvisorId()
	{
		return advisorId;
	}
	
	


	public void setFirstname(String firstname) {
		this.firstname=firstname;	
	}


	public String getFirstname() {
		return firstname;
	}


	public String getLastname() {
		return lastname;
	}
	
}