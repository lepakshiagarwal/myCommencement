package edu.ycp.cs320.comm.controllerTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.comm.controller.AdvisorController;
import edu.ycp.cs320.comm.controller.StudentController;
import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;

public class StudentControllerTest {
	private Student model;
	private StudentController controller;
	
	@Before
	public void setUp() {
		model = new Student("Acanzano","TeslaTruck");
		controller=new StudentController(model);
	}
	
	@Test
	public void testValidateUsername() {
		assertFalse(controller.checkUserName("lepakshi"));
		assertTrue(controller.checkUserName("Acanzano"));
	}

	@Test
	public void testValidatePassword() 
	{
		//correct username and password
		assertTrue(controller.validateCredentials("Acanzano", "TeslaTruck"));
		//correct password, wrong username
		assertFalse(controller.validateCredentials("Lagarwal", "TeslaTruck"));
		//correct username, wrong password
		assertFalse(controller.validateCredentials("Acanzano", "Deer"));
		//both password  and username or invalid
		assertFalse(controller.validateCredentials("Lagarwal", "Deer"));
		
	}
	
}