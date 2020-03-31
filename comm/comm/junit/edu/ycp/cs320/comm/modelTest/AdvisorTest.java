package edu.ycp.cs320.comm.modelTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.comm.model.Advisor;

public class AdvisorTest {
	public Advisor model;
	@Before
	public void setUp() {
		model = new Advisor();
	}
	
	@Test
	public void testValidateUsername() {
		assertFalse(model.validateUserName("lepakshi"));
	}
	@Test
	public void testValidateUsernamee() {
		assertTrue(model.validateUserName("Mshae"));
	}
	
	@Test
	public void testValidatePassword() {
		assertTrue(model.validatePassword("Mshae","xyz"));
	}
	
	@Test 
	public void testValidatePasswordd() {
		assertFalse(model.validatePassword("Rshae","xyz"));
	}
	
	@Test
	public void testGetAdviceList() {
		List<String> test=new ArrayList<String>();
		test.add("lepakshi");
		test.add("jake");
		String Advisor="Mshae";
		assertTrue(model.adviceList(Advisor)== test);
	}
	
}
