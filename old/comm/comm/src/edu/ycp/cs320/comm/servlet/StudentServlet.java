package edu.ycp.cs320.comm.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.comm.controller.StudentController;
import edu.ycp.cs320.comm.model.Student;

public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TreeMap<String, String> students= new TreeMap<String,String>();
   
    
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("students Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/Studentlogin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("students Servlet: doPost");
		
		students.put("austin","xyz");
		students.put("lepakshi","abc");
		
		Student model = new Student(null,null);
		
		StudentController controller = new StudentController();
		
		controller.setModel(model);
		

		// holds the error message text, if there is any
		String errorMessage = null;

		// result of calculation goes here
		boolean result = false;
		
		// decode POSTed form parameters and dispatch to controller
		try {
			String username = getStringFromParameter(req.getParameter("first"));
			String password = getStringFromParameter(req.getParameter("second"));
			model.setUsername(username);
			model.setPassword(password);
			
			// check for errors in the form data before using is in a calculation
			if (model.getUsername() == null || model.getPassword() == null) {
				errorMessage = "Please enter data";
				}
			else if(!students.containsKey(model.getUsername())){
				errorMessage="user doesnot exist";
			}
			else if(!students.get(model.getUsername()).equals(model.getPassword())) {
				errorMessage= "password does not match";
			}
			// otherwise, data is good, do the calculation
			// must create the controller each time, since it doesn't persist between POSTs
			// the view does not alter data, only controller methods should be used for that
			// thus, always call a controller method to operate on the data
			else {
				
				errorMessage = "Logged in!";
				
			}
		} catch (NumberFormatException e) {
			errorMessage = "Invalid double";
		}
		
		// Add parameters as request attributes
		// this creates attributes named "first" and "second for the response, and grabs the
		// values that were originally assigned to the request attributes, also named "first" and "second"
		// they don't have to be named the same, but in this case, since we are passing them back
		// and forth, it's a good idea
		req.setAttribute("first", req.getParameter("first"));
		req.setAttribute("second", req.getParameter("second"));
		
		// add result objects as attributes
		// this adds the errorMessage text and the result to the response
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("result", result);
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/Studentlogin.jsp").forward(req, resp);
	}

	// gets double from the request with attribute named s
	private String getStringFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return s;
		}
	}
}
