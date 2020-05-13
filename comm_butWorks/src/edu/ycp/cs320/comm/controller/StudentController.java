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
	private DerbyDatabase db;

	//Set the model.
	public StudentController() {
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = (DerbyDatabase) DatabaseProvider.getInstance();
	}
	
	public void setModel(Student s)
	{
		model=s;
	}


	public Student getLog(String username,String password) 
	{

		return db.findStudentByLogin(username, password);

	}



}