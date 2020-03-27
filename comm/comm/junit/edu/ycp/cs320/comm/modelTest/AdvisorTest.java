package edu.ycp.cs320.comm.modelTest;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.comm.model.Advisor;

public class AdvisorTest {
	private Advisor model;
	private String username="advisor";
	private String password="xyz";
	
	@Before
	public void setUp() {
		model = new Advisor(username,password);
	}
	
	@Test
	public void testGetUsername() {
		assertTrue(model.getUsername()==username);
	}
	@Test
	public void testGetPassword() {
		assertTrue(model.getPassword()==password);
	}
	
	@Test
	public void testSetPassword() {
		model.setPassword("hello");
		assertTrue(model.getPassword()=="hello");
	}
	
	@Test 
	public void testSetUsername() {
		model.setUsername("adv");
		assertTrue(model.getUsername()=="adv");
	}
	
}
