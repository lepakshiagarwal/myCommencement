package edu.ycp.cs320.lab02a_smelendez.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab02a_smelendez.model.Students;

public class StudentControllerTest {
	private Students model;
	private StudentController controller;
	
	@Before
	public void setUp() {
		model = new Students();
		controller = new StudentController();
	
		model.setUsername("Stu Dent");
		model.setPassword("wordpass");
		
		controller.setModel(model);
	}
	
	@Test
	public void testValidate() {
		boolean te = true;
		assertTrue(controller.Validate() == te);
	}
	@Test
	public void testfailValidate() {
		boolean te = false;
		assertFalse(controller.Validate() == te);
	}

	
}
