package edu.ycp.cs320.lab02a_smelendez.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab02a_smelendez.controller.AdvisorController;
import edu.ycp.cs320.lab02a_smelendez.model.Advisors;

public class AdvisorControllerTest {
	private Advisors model;
	private AdvisorController controller;
	
	@Before
	public void setUp() {
		model = new Advisors();
		controller = new AdvisorController();
		
		model.setMin(1);
		model.setMax(100);
		
		controller.setModel(model);
	}
	
	@Test
	public void testNumberIsGreater() {
		int currentGuess = model.getGuess();
		controller.setNumberIsGreaterThanGuess();
		assertTrue(model.getGuess() > currentGuess);
	}
	@Test
	public void testNumberIsLess() {
		int currentGuess = model.getGuess();
		controller.setNumberIsLessThanGuess();
		assertTrue(model.getGuess() < currentGuess);
	}
}
