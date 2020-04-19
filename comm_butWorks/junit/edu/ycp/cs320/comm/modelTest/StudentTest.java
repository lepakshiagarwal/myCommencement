package edu.ycp.cs320.comm.modelTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;

public class StudentTest {
	public Student model;
	
	@Before
	public void setUp() {
		model = new Student("Lagarwal", "gitIsAwesome");
	}
	
	@Test 
	public void testGetAndSetPassword()
	{
		assertTrue("gitIsAwesome".equals(model.getPassword()));
		assertFalse("GitSucks".equals(model.getPassword()));
		model.setPassword("GitSucks");
		assertTrue("GitSucks".equals(model.getPassword()));
		assertFalse("gitIsAwesome".equals(model.getPassword()));
	}
	
	@Test 
	public void testGetAndSetMajor()
	{
		assertTrue("Computer Science".equals(model.getMajor()));
		assertFalse("Business".equals(model.getMajor()));
		model.setMajor("Business");
		assertTrue("Business".equals(model.getMajor()));
		assertFalse("Computer Science".equals(model.getMajor()));
	}
	
	@Test 
	public void testGetAndSetGPA()
	{
		assertTrue(4.0==(model.getGpa()));
		assertFalse(3.5==(model.getGpa()));
		model.setGpa((float) 3.5);
		assertTrue(3.5==(model.getGpa()));
		assertFalse(4.0==(model.getGpa()));
	}
	
	@Test 
	public void testGetAndSetAdvisor()
	{
		/*
		 * assertTrue("Hake".equals(model.getAdvisor()));
		 * assertFalse("Babcock".equals(model.getAdvisor()));
		 * model.setAdvisorName("Babcock");
		 * assertTrue("Babcock".equals(model.getAdvisor()));
		 * assertFalse("Hake".equals(model.getAdvisor()));
		 */
	}
	
}