package edu.ycp.cs320.ycpdb.Queries;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.comm.model.Student;
import edu.ycp.cs320.prodb.persist.IDatabase2;
import edu.ycp.cs320.prodb.persist.ProjectDatabse;
import edu.ycp.cs320.prodb.persist.DatabaseProvider2;

public class findNotificationByStudentUsername
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
	
		// Create the default IDatabase instance
		System.out.print("Enter Student username");
		String username = keyboard.next();
		
		// get the DB instance and execute transaction
		DatabaseProvider2.setInstance((IDatabase2) new ProjectDatabse());
		ProjectDatabse db = (ProjectDatabse) DatabaseProvider2.getInstance();
		int notification = db.findNotificationByUsername(username);
		
		// check if anything was returned and output the list
		if (notification == -1) 
		{
			System.out.println("No students found with username : <" + username + ">");
		}
		else 
		{
			System.out.print("Success!");
			System.out.println(notification);
			
		
		}
	}
}

