package edu.ycp.cs320.comm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.comm.controller.AdvisorController;
import edu.ycp.cs320.comm.controller.StudentController;
import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;


public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//for validate method
	private Student model;
	private StudentController controller;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Student Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/Studentlogin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

		System.out.println("student Servlet: doPost");
		
		String errorMessage = null;
		String name         = null;
		String pw           = null;
		boolean validLogin  = false;

		// Decode form parameters and dispatch to controller
		name = req.getParameter("username");
		pw   = req.getParameter("password");

		System.out.println("   Name: <" + name + "> PW: <" + pw + ">");			

		if (name.equals(null) || pw.equals(null) || name.equals("") || pw.equals("")) {
			errorMessage = "Please specify both user name and password";
		} else {
			model      = new Student("Smelendez", "42");
			controller = new StudentController(model);
			validLogin = controller.validateCredentials(name, pw);

			if (!validLogin) {
				errorMessage = "Username and/or password invalid";
			}
		}

		// Add parameters as request attributes
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));

		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("login",        validLogin);

		// if login is valid, start a session
		if (validLogin) {
			System.out.println("   Valid login - starting session, redirecting to /index");

			// store user object in session
			req.getSession().setAttribute("user", model);

			// redirect to /index page
			resp.sendRedirect(req.getContextPath() + "/StudentMain");

			return;
		}

		System.out.println("   Invalid login - returning to /Login");
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/Studentlogin.jsp").forward(req, resp);
	}
}