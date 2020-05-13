package edu.ycp.cs320.comm.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.comm.controller.AdvisorController;
import edu.ycp.cs320.comm.controller.StudentController;
import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;

public class StudentControllerTest {
	public Student Correctmodel;
	public Student IncorrectModel;
	public StudentController controller;
	
	@Before
	public void setUp() {
		Correctmodel = new Student("acanzano","xyz");
		IncorrectModel = new Student("sriordan3", "abc");
		controller=new StudentController();
	}
	
	@Test
	public void testGetLog()
	{
		
		Student found = controller.getLog(Correctmodel.getUsername(), Correctmodel.getPassword());
		assertEquals(found.getFirstname(), "Austin");
		Student notFound =controller.getLog(IncorrectModel.getUsername(), IncorrectModel.getPassword());
		assertTrue(notFound==null);
	}
	
	
}