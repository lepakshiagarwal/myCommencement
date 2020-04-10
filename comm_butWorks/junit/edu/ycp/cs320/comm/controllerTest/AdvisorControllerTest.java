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
import edu.ycp.cs320.comm.model.Advisor;

public class AdvisorControllerTest {
	private Advisor model;
	private AdvisorController controller;
	
	@Before
	public void setUp() {
		model = new Advisor("Dhake", "tesla");
		controller=new AdvisorController(model);
	}
	
	@Test
	public void testGetAdvisee() {
		assertFalse(controller.getAdvisee("Smelendez").getPassword().equals("hellogoodbyeworld"));
		assertTrue(controller.getAdvisee("Acanzano").getPassword().equals("goodbyeworld"));
	}
	
	@Test
	public void testValidatePassword() {
		assertTrue(controller.validateCredentials("Mshae","xyz"));
	}
	
	@Test 
	public void testValidatePasswordd() {
		assertFalse(controller.validateCredentials("Rshae","xyz"));
	}
	
	@Test
	public void testGetAdviceList() {
		assertTrue(model.adviseeList().size()==2);
	}
}