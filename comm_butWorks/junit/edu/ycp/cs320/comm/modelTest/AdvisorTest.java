package edu.ycp.cs320.comm.modelTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;

public class AdvisorTest {
	public Advisor model;
	
	@Before
	public void setUp() {
		model = new Advisor("Dhake", "tesla");
		model.addAdvisee(new Student("Acanzano","goodbyeworld"));
		model.addAdvisee(new Student("Smelendez","badPassword"));
	}
	
	@Test
	public void testGetAdvisee() 
	{
		assertFalse(model.getAdvisee("Smelendez").getPassword().equals("hellogoodbyeworld"));
		assertTrue(model.getAdvisee("Acanzano").getPassword().equals("goodbyeworld"));
	}

	
	@Test
	public void testGetAdviceList() {
		assertTrue(model.adviseeList().size()==2);
	}
	
}