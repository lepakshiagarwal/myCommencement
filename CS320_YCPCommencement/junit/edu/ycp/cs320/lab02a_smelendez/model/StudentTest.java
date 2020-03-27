package edu.ycp.cs320.lab02a_smelendez.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab02a_smelendez.model.Students;

public class StudentTest {
	private Students model;
	private int qrCode;
	
	@Before
	public void setUp() {
		model = new Students();
		qrCode=4560;
	}
	
	@Test
	public void testSetUsername() {
		model.setUsername("Test Stu");
		assertEquals("Test Stu", model.getUsername());
	}
	
	@Test
	public void testSetPassword() {
		model.setPassword("Tesla");
		assertEquals("Tesla", model.getPassword());
	}
}
