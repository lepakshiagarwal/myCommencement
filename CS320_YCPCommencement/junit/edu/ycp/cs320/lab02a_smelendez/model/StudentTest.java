package edu.ycp.cs320.lab02a_smelendez.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab02a_smelendez.model.Advisors;

public class StudentTest {
	private Students model;
	private int qrCode;
	
	@Before
	public void setUp() {
		model = new Students(lepakshi,hi);
		qrCode=4560;
	}
	
	@Test
	public void testGetUsername() {
		assertEqual(lepakshi,getuername());
	}
	
}
