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
		DatabaseProvider.setInstance(new DerbyDatabase());
		
		System.out.print("Enter the Advisor Id of the author: ");
		String AdvisorId = keyboard.nextLine();
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		List<Student> Students = db.findStudentsByAdvisorId(AdvisorId);
		
		// check if anything was returned and output the list
		if (Students.isEmpty()) {
			System.out.println("No students found with with advisorId <" + AdvisorId + ">");
		}
		else {
			for (Student s : Students) {
				System.out.println(s.getFirstname()+", "+s.getLastname()+": "+s.getMajor()+" Major");
			}
		}
	}
}
