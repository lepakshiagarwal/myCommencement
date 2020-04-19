package Queries;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.comm.model.Student;
import edu.ycp.cs320.ycpdb.persist.DerbyDatabase;
import edu.ycp.cs320.ycpdb.persist.IDatabase;
import edu.ycp.cs320.ycpdb.persist.DatabaseProvider;

public class FindStudentsByAdvisorUsername
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
	
		// Create the default IDatabase instance
		System.out.print("Enter advisor username");
		String AdvUsername = keyboard.nextLine();
		
		// get the DB instance and execute transaction
		DatabaseProvider.setInstance(new DerbyDatabase());
		DerbyDatabase db = (DerbyDatabase) DatabaseProvider.getInstance();
		List<Student> students = db.findStudentsByAdvisorUsername(AdvUsername);
		
		// check if anything was returned and output the list
		if (students.isEmpty()) 
		{
			System.out.println("No students found with advisor: <" + AdvUsername + ">");
		}
		else 
		{
			for (Student s : students) 
			{
				System.out.println(s.getLastname() + "," + s.getFirstname() + "," + s.getMajor());
			}
		}
	}
}

