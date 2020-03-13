package edu.ycp.cs320.lab02a_smelendez.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab02a_smelendez.controller.AdvisorController;
import edu.ycp.cs320.lab02a_smelendez.model.Advisors;
import edu.ycp.cs320.lab02a_smelendez.model.Students;

public class StudentControllerTest {
	private Students model;
	private StudentController controller;
	
	@Before
	public void setUp() {
		model = new Students();
		controller = new StudentController();
		
		model.setFirst(1.0);
		model.setSecond(100.0);
		
		controller.setModel(model);
	}
	
	@Test
	public void testNumber() {
		double currentGuess = 100.0;
		//controller.setNumberIsGreaterThanGuess();
		assertTrue(controller.multiply(model.getFirst(), model.getSecond()) == currentGuess);
	}
	
}
