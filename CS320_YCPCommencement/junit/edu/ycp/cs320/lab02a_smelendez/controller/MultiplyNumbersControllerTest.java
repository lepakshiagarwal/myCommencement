package edu.ycp.cs320.lab02a_smelendez.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab02a_smelendez.controller.GuessingGameController;
import edu.ycp.cs320.lab02a_smelendez.model.GuessingGame;
import edu.ycp.cs320.lab02a_smelendez.model.Numbers;

public class MultiplyNumbersControllerTest {
	private Numbers model;
	private NumbersController controller;
	
	@Before
	public void setUp() {
		model = new Numbers();
		controller = new NumbersController();
		
		model.setFirst(1.0);
		model.setSecond(100.0);
		
		controller.setModel(model);
	}
	
	@Test
	public void testNumber() {
		double currentGuess = 100.0;
		//controller.setNumberIsGreaterThanGuess();
		assertTrue(controller.multiply(model.getFirst(), model.getSecond()) == currentGuess);
	}
	
}
