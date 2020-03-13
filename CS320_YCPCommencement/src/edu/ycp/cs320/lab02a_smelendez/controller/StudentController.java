package edu.ycp.cs320.lab02a_smelendez.controller;


import edu.ycp.cs320.lab02a_smelendez.model.Students;

public class StudentController {
	
	private Students model;
	
	public void setModel(Students model) {
		this.model = model;
	}
	
	
	public Double add(Double first, Double second) {
		return first + second;
	}
	
	public Double add(Double first, Double second, Double third) {
		return (first + second + third);
	}
	
	public Double multiply(Double first, Double second) {
		return first * second;
	}
	
}
