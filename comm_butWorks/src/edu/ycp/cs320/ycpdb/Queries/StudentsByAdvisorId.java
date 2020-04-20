package edu.ycp.cs320.ycpdb.Queries;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.ycpdb.persist.DatabaseProvider;
import edu.ycp.cs320.ycpdb.persist.DerbyDatabase;
import edu.ycp.cs320.ycpdb.persist.IDatabase;
import edu.ycp.cs320.comm.model.Student;
public class StudentsByAdvisorId 
{

	public static void main(String[] args) throws SQLException 
	{
		Scanner keyboard = new Scanner(System.in);
		
		// Create the default IDatabase instance
		System.out.print("Enter advisor Id");
		int AdvId = keyboard.nextInt();
		
		// get the DB instance and execute transaction
		DatabaseProvider.setInstance(new DerbyDatabase());
		DerbyDatabase db = (DerbyDatabase) DatabaseProvider.getInstance();
		List<Student> students = db.findStudentsByAdvisorId(AdvId);
		
		// check if anything was returned and output the list
		if (students.isEmpty()) 
		{
			System.out.println("No students found with advisor: <" + AdvId + ">");
		}
		else 
		{
			for (Student s : students) 
			{
				System.out.println(s.getLastname() + ", " + s.getFirstname() + ", " + s.getMajor());
			}
		}
	}
}
