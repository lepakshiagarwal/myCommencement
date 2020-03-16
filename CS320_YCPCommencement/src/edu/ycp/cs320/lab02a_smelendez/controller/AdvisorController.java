package edu.ycp.cs320.lab02a_smelendez.controller;

import edu.ycp.cs320.lab02a_smelendez.model.Advisors;


public class AdvisorController {
	private Advisors model;



	public void setModel(Advisors model) {
		this.model = model;
	}
	
	public boolean Validate() {
		return model.isValid();
		
	}
}
