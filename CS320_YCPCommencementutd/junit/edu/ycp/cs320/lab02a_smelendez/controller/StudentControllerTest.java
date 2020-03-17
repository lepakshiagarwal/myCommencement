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
	
		String name = "User";
		String password = "pass";
		
		
		model.setUsername(name);
		model.setPassword(password);
		
		controller.setModel(model);
	}
	
	@Test
	public void testUsernameCorrect() {
		String username = model.getUsername();
		assertTrue(username.equals("User"));
	}
	@Test
	public void testUsernameIncorrect() {
		String username = model.getUsername();
		assertFalse(username.equals("wewedw"));
	}
	
	@Test
	public void testPasswordCorrect() {
		String pass = model.getPassword();
		assertTrue(pass.equals("pass"));
	}
	@Test
	public void testPasswordIncorrect() {
		String pass = model.getPassword();
		assertFalse(pass.equals("wewew"));
	}
}