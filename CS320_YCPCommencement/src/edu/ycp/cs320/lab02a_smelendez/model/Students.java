package edu.ycp.cs320.lab02a_smelendez.model;

// model class for GuessingGame
// only the controller should be allowed to call the set methods
// the JSP will call the "get" and "is" methods implicitly
// when the JSP specifies game.min, that gets converted to
//    a call to model.getMin()
// when the JSP specifies if(game.done), that gets converted to
//    a call to model.isDone()
public class Students {
	private Double first, second, third;
	
	public Students() {
	}
	
	public void setFirst(Double f) {
		this.first = f;
	}
	
	public Double getFirst() {
		return first;
	}
	
	public void setSecond(Double s) {
		this.second = s;
	}
	
	public Double getSecond() {
		return second;
	}
	
	public void setThird(Double t) {
		this.third = t;
	}
	
	public Double getThird() {
		return third;
	}
	

}
