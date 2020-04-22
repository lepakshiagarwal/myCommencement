package edu.ycp.cs320.comm.controller;

import edu.ycp.cs320.comm.model.Student;
import edu.ycp.cs320.ycpdb.persist.DatabaseProvider;
import edu.ycp.cs320.ycpdb.persist.DerbyDatabase;
import edu.ycp.cs320.ycpdb.persist.IDatabase;

/**
 * Controller for the Advisor
 */
public class StudentController {
	private Student model;
	private IDatabase db    = null;

	//Set the model.
	public StudentController() {
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}


	public Student getLog(String username,String password) {

		 Student log = db.findStudentByLogin(username, password);
			System.out.println("makes it here");
			System.out.println(log.getFirstname());

			return log;


		// return list of book,author pairs
	}
	//method to check username


}