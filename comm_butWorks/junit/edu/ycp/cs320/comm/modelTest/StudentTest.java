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
	public String major;
	
	@Before
	public void setUp() {
		model = new Student("Lagarwal", "gitIsAwesome");
		major="Bussiness";
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
	public void testGetAndSetAdvisorId()
	{
		model.setAdvisorId(2);
		assertTrue(2==(model.getAdvisorId()));
		assertFalse(1==(model.getAdvisorId()));
		}
	
	@Test
	public void testGetAndSetGpa()
	{
		model.setGpa((float)3.32);
		assertTrue(3.32==(model.getGpa()));
		assertFalse(3.28==(model.getGpa()));
		}
	
	@Test
	public void testGetAndSetMajor()
	{
		model.setMajor(major);
		assertTrue(major.equals(model.getMajor()));
		assertFalse("economics".equals(model.getMajor()));
		}
	
	@Test
	public void testGetAndFirstName()
	{
		model.setFirstname("lepakshi");
		assertTrue("lepakshi".equals(model.getFirstname()));
		assertFalse("shae".equals(model.getFirstname()));
		}
	
	@Test
	public void testGetAndFLastName()
	{
		model.setLastname("lepakshi");
		assertTrue("lepakshi".equals(model.getLastname()));
		assertFalse("shae".equals(model.getLastname()));
		}
	
	@Test
	public void testGetAndMinor()
	{
		model.setMinor(major);
		assertTrue(major.equals(model.getMinor()));
		assertFalse("shae".equals(model.getMinor()));
		}
	
	@Test
	public void testGetAndComment()
	{
		model.setComment("content is acceptable");
		assertTrue("content is acceptable".equals(model.getComment()));
		assertFalse("Content needs to be improved".equals(model.getComment()));
		}
	
	@Test
	public void testGetAndStatus()
	{
		model.setStatus("approved");
		assertTrue("approved".equals(model.getStatus()));
		assertFalse("rejected".equals(model.getStatus()));
		}
	
	@Test
	public void testGetAndSetContent()
	{
		model.setContent(null);
		assertTrue(null==model.getContent());
	}
	@Test
	public void testGetAndStudentId() {
		model.setStudentId(3);
		assertTrue(3==model.getStudentId());
		assertFalse(4==model.getStudentId());
	}
}