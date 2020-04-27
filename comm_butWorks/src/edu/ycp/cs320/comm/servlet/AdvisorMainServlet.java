package edu.ycp.cs320.comm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.comm.controller.AdvisorController;
import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;

public class AdvisorMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

		Advisor model =  (Advisor) req.getSession().getAttribute("user");
		System.out.println("AdvisorMain Servlet: doGet");
		
		//set list of students as attribute'
		req.setAttribute("studentList", model.adviseeList());
		req.setAttribute("user", model);
		// add result objects as attributes
		
		// call JSP to generate empty form
		
		req.getRequestDispatcher("/_view/AdvisorMain.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

		System.out.println("advisor Servlet: doPost");	
		
		
		
		// holds the error message text, if there is any
		String errorMessage = null;

		// result of calculation goes here
		boolean result = false;
		
		// decode POSTed form parameters and dispatch to controller
		
		
		
	
	
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/Advisorlogin.jsp").forward(req, resp);
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