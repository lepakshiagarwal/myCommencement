package edu.ycp.cs320.comm.modelTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.comm.model.Student;

public class StudentTest {
	private Student model;
	private String username="team";
	private String password="xyz";
	private int qrCode=4560;
	
	@Before
	public void setUp() {
		model = new Student(username,password);
		model.setQrCode(qrCode);
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
		model.setUsername("team mycomm");
		assertTrue(model.getUsername()=="team mycomm");
	}
	
	@Test 
	public void testGetQrCode() {
		assertTrue(model.getQrCode()==qrCode);
	}
	
	@Test
	public void testSetQrCode() {
		model.setQrCode(4520);
		assertTrue(model.getQrCode()==4520);
	}
}

