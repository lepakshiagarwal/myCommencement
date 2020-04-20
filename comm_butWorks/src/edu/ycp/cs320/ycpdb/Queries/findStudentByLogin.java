package edu.ycp.cs320.ycpdb.Queries;

import java.util.Scanner;

import edu.ycp.cs320.comm.model.Content;
import edu.ycp.cs320.comm.model.Student;
import edu.ycp.cs320.ycpdb.persist.DatabaseProvider;
import edu.ycp.cs320.ycpdb.persist.DerbyDatabase;

public class findStudentByLogin {

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
		Student student = db.findStudentByLogin(username, password);
		
		// check if anything was returned and output the list
		if (student.equals(null)) 
		{
			System.out.println("No students found. \n");
		}
		else 
		{
			System.out.print("Success! "+student.getUsername()+" has been logged in.");
			System.out.print(student.getMajor());
			
		
		}

	}

}
