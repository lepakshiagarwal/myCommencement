package edu.ycp.cs320.ycpdb.Queries;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import edu.ycp.cs320.comm.model.Content;
import edu.ycp.cs320.prodb.persist.DatabaseProvider;
import edu.ycp.cs320.prodb.persist.IDatabase2;
import edu.ycp.cs320.prodb.persist.ProjectDatabse;

public class insertNotificationbyAdvisorUsername 
{

	public static void main(String[] args) throws FileNotFoundException, SQLException
	{
		Scanner keyboard = new Scanner(System.in);
	
		// Create the default IDatabase instance
		System.out.print("Enter advisor username");
		String username = keyboard.nextLine();
		System.out.print("Enter Notification");
		int notification = keyboard.nextInt();
		// get the DB instance and execute transaction
		DatabaseProvider.setInstance((IDatabase2) new ProjectDatabse());
		ProjectDatabse db = (ProjectDatabse) DatabaseProvider.getInstance();
		
		boolean inserted = db.insertNotificationByUsernameAdvisor(username, notification);
		
		// check if anything was returned and output the list
		if (inserted==false) 
		{
			System.out.println("insertion error");
		}
		else 
		{
			System.out.print("Success!");
			
		
		}
	}
}
