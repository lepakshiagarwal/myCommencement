package edu.ycp.cs320.comm.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.comm.controller.AdvisorController;
import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;
import edu.ycp.cs320.ycpdb.persist.DatabaseProvider;
import edu.ycp.cs320.ycpdb.persist.DerbyDatabase;


public class AdvisorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//for validate method
	private Advisor model;
	private AdvisorController controller;
	private DerbyDatabase db;
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
		//Declare database to pull advisor data from
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = (DerbyDatabase) DatabaseProvider.getInstance();

		System.out.println("advisor Servlet: doPost");
		
		String errorMessage = null;
		String name         = null;
		String pw           = null;
		boolean validLogin  = false;
		Advisor model = null;
		// Decode form parameters and dispatch to controller
		name = req.getParameter("username");
		pw   = req.getParameter("password");

		System.out.println("   Name: <" + name + "> PW: <" + pw + ">");			

		if (name.equals(null) || pw.equals(null) || name.equals("") || pw.equals("")) 
		{
			errorMessage = "Please specify both user name and password";
		} else {
			
			model = db.findAdvisorByLogin(name, pw);
			controller = new AdvisorController(model);
			if(!(model==null))
			{
				validLogin=true;
			}

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
			ArrayList<Student> students = db.findStudentsByAdvisorId(model.getAdvisorId());
			model.setAdviseeList(students);
			// store user object in session
			req.getSession().setAttribute("user", model);
			System.out.print(model.adviseeList().get(0).getFirstname());
			// redirect to /index page
			resp.sendRedirect(req.getContextPath() + "/AdvisorMain");

			return;
		}

		System.out.println("   Invalid login - returning to /Login");
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/Advisorlogin.jsp").forward(req, resp);
	}
}