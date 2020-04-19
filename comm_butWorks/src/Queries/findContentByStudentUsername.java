package Queries;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.comm.model.Content;
import edu.ycp.cs320.comm.model.Student;
import edu.ycp.cs320.ycpdb.persist.DatabaseProvider;
import edu.ycp.cs320.ycpdb.persist.DerbyDatabase;

public class findContentByStudentUsername
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
	
		// Create the default IDatabase instance
		System.out.print("Enter studentername");
		String username = keyboard.nextLine();
		
		// get the DB instance and execute transaction
		DatabaseProvider.setInstance(new DerbyDatabase());
		DerbyDatabase db = (DerbyDatabase) DatabaseProvider.getInstance();
		Content studentContent = db.findContentByStudentUsername(username);
		
		// check if anything was returned and output the list
		if (studentContent.equals(null)) 
		{
			System.out.println("No students found with username: <" + username + ">");
		}
		else 
		{
			System.out.print("Success!");
			
		
		}
	}
}

