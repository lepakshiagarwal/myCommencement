package edu.ycp.cs320.comm.controllerTest;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.comm.controller.StudentController;
import edu.ycp.cs320.comm.model.Student;

public class StudentControllerTest {
	
	private Student model;
	private StudentController controller;
	private String username="team";
	private String password="xyz";
	
	@Before
	public void setUp() {
		model = new Student(username,password);
		controller = new StudentController();	
	}
}