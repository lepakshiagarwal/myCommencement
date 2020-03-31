package edu.ycp.cs320.comm.controller;

import edu.ycp.cs320.comm.model.Advisor;

/**
 * Controller for the Advisor
 */
public class AdvisorController {
	private Advisor model;

	 //Set the model.
	public AdvisorController(Advisor model) {
		this.model = model;
	}
	
	//method to check username
	public boolean checkUserName(String name) {
		return model.validateUserName(name);
	}
	
	//method to validate password
	public boolean validateCredentials(String name, String password) {
		return model.validatePassword(name, password);
	}
}