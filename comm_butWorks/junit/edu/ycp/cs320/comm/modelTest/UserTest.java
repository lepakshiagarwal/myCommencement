package edu.ycp.cs320.comm.modelTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.comm.model.User;


public class UserTest 
{
	private User model;
	
	@Before
	public void setUp() 
	{
		model = new User("Acanzano","TeslaTruck");
	}
	
	@Test
	public void testSetAndGetPassword()
	{
		assertTrue(model.getPassword().equals("TeslaTruck"));
		assertFalse(model.getPassword().equals("helloworld"));
		model.setPassword("helloworld");
		assertTrue(model.getPassword().equals("helloworld"));
		assertFalse(model.getPassword().equals("TeslaTruck"));
	}
	
	@Test
	public void testSetAndGetUsername()
	{
		assertTrue(model.getUsername().equals("Acanzano"));
		assertFalse(model.getUsername().equals("Lagarwal"));
		model.setUsername("Lagarwal");
		assertTrue(model.getUsername().equals("Lagarwal"));
		assertFalse(model.getUsername().equals("Acanzano"));
	}
}