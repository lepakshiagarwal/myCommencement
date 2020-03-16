package edu.ycp.cs320.lab02a_smelendez.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab02a_smelendez.model.Students;


public class StudentTest {
	private Students model;
	
	@Before
	public void setUp() {
		model = new Students();
	}
	
	@Test
	public void testSetUsername() {
		model.setUsername("Stu Dent");
		assertEquals("Stu Dent", model.getUsername());
	}
	
	@Test
	public void testSetPassword() {
		model.setPassword("wordpass");
		assertEquals("wordpass", model.getPassword());
	}
}
