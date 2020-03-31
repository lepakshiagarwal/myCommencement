package edu.ycp.cs320.lab02a_smelendez.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab02a_smelendez.controller.StudentController;
import edu.ycp.cs320.lab02a_smelendez.model.Students;

public class StudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("students Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/studentLogin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("students Servlet: doPost");
		
		
		Students model = new Students();
		
		StudentController controller = new StudentController();
		
		controller.setModel(model);
		

		// holds the error message text, if there is any
		String errorMessage = null;

		// result of calculation goes here
		
		// decode POSTed form parameters and dispatch to controller
	
			String username = getStringFromParameter(req.getParameter("first"));
			String password = getStringFromParameter(req.getParameter("second"));
			model.setUsername(username);
			model.setPassword(password);
			boolean result = controller.Val(username, password);

			// check for errors in the form data before using is in a calculation
			if (model.getUsername() == null || model.getPassword() == null) {
				errorMessage = "Please enter stuff";
			}else {
			
				
			}
			
			
			
			
			// otherwise, data is good, do the calculation
			// must create the controller each time, since it doesn't persist between POSTs
			// the view does not alter data, only controller methods should be used for that
			// thus, always call a controller method to operate on the data
			
	
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
		
		if(result== true) {
			resp.sendRedirect(req.getContextPath() + "/index.jsp");

		}else {
			errorMessage = "Username and/or password invalid";

		}
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/studentLogin.jsp").forward(req, resp);
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
