package edu.ycp.cs320.comm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.comm.controller.AdvisorController;
import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;


public class AdvisorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//for validate method
	private Advisor model;
	private AdvisorController controller;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Advisor Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/Advisorlogin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

		System.out.println("advisor Servlet: doPost");
		
		String errorMessage = null;
		String name         = null;
		String pw           = null;
		boolean validLogin  = false;

		// Decode form parameters and dispatch to controller
		name = req.getParameter("username");
		pw   = req.getParameter("password");

		System.out.println("   Name: <" + name + "> PW: <" + pw + ">");			

		if (name.equals(null) || pw.equals(null) || name.equals("") || pw.equals("")) 
		{
			errorMessage = "Please specify both user name and password";
		} else {
			
			model = new Advisor("Dhake", "tesla");
			//add students to model
			Student Shae = new Student("Smelendez", "helloworld");
			Student Austin = new Student("Acanzano","goodbyeworld");
			model.addAdvisee(Shae);
			model.addAdvisee(Austin);
			//add students to list
			controller = new AdvisorController(model);
			
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
			System.out.println("   Valid login - starting session, redirecting to /AdvisorMain");

			// store user object in session
			req.getSession().setAttribute("user", model);
			
			// redirect to /index page
			resp.sendRedirect(req.getContextPath() + "/AdvisorMain");

			return;
		}

		System.out.println("   Invalid login - returning to /Login");
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/Advisorlogin.jsp").forward(req, resp);
	}
}