package edu.ycp.cs320.lab02a_smelendez.controller;


import edu.ycp.cs320.lab02a_smelendez.model.Numbers;

public class NumbersController {
	
	private Numbers model;
	
	public void setModel(Numbers model) {
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
