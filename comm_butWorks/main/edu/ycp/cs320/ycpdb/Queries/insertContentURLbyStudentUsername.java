package edu.ycp.cs320.ycpdb.Queries;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import edu.ycp.cs320.prodb.persist.DatabaseProvider;
import edu.ycp.cs320.prodb.persist.IDatabase2;
import edu.ycp.cs320.prodb.persist.ProjectDatabse;

public class insertContentURLbyStudentUsername 
{

	public static void main(String[] args) throws FileNotFoundException, SQLException
	{
		Scanner keyboard = new Scanner(System.in);
	
		// Create the default IDatabase instance
		System.out.print("Enter Student Username");
		String username = keyboard.nextLine();
		System.out.print("Enter File Name");
		String fileName = keyboard.nextLine();
		// get the DB instance and execute transaction
		DatabaseProvider.setInstance((IDatabase2) new ProjectDatabse());
		ProjectDatabse db = (ProjectDatabse) DatabaseProvider.getInstance();
		
		boolean inserted = db.insertContentURLByStudentUsername(username, fileName);
		
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
