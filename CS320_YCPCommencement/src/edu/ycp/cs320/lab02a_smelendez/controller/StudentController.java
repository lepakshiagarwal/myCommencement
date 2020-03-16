package edu.ycp.cs320.lab02a_smelendez.controller;


import edu.ycp.cs320.lab02a_smelendez.model.Students;

public class StudentController {
	
	private Students model;
	
	public void setModel(Students model) {
		this.model = model;
	}
	
	public boolean Validate() {
		return model.isValid();
		
	}


	
}

