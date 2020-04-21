package edu.ycp.cs320.ycpdb.Queries;

import java.util.Scanner;

import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.ycpdb.persist.DatabaseProvider;
import edu.ycp.cs320.ycpdb.persist.DerbyDatabase;

public class findAdvisorByLogin {

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
	
	// Create the default IDatabase instance
	System.out.print("Enter Username");
	String username = keyboard.nextLine();
	System.out.print("Enter password");
	String password = keyboard.nextLine();
	// get the DB instance and execute transaction
	DatabaseProvider.setInstance(new DerbyDatabase());
	DerbyDatabase db = (DerbyDatabase) DatabaseProvider.getInstance();
	Advisor a = db.findAdvisorByLogin(username, password);
	
	// check if anything was returned and output the list
	if (a==null) 
	{
		System.out.println("No advisors found. \n");
	}
	else 
	{
		System.out.print("Success! "+a.getUsername()+" has been logged in.");
		System.out.print(a.getFirstname());
		
	
	}

	}

}
