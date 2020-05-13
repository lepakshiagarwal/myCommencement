package edu.ycp.cs320.ycpdb.Queries;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.comm.model.Student;
import edu.ycp.cs320.prodb.persist.IDatabase2;
import edu.ycp.cs320.prodb.persist.ProjectDatabse;
import edu.ycp.cs320.prodb.persist.DatabaseProvider;

public class finContentByQR
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
	
		// Create the default IDatabase instance
		System.out.print("Enter QR");
		int qr = keyboard.nextInt();
		
		// get the DB instance and execute transaction
		DatabaseProvider.setInstance((IDatabase2) new ProjectDatabse());
		ProjectDatabse db = (ProjectDatabse) DatabaseProvider.getInstance();
		String studentContent = db.findContentByQR(qr);
		
		// check if anything was returned and output the list
		if (studentContent == "") 
		{
			System.out.println("No students found with QR: <" + qr + ">");
		}
		else 
		{
			System.out.print(studentContent);
			System.out.print("Success!");
			

		}
	}
}

