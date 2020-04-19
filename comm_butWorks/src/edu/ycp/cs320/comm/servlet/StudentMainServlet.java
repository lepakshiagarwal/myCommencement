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


public class StudentMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//for validate method
	private Student model;
	private StudentController controller;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Student Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/StudentMain.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

		System.out.println("student Servlet: doPost");
		model = new Student("Smelendez", "42");
		
	    controller = new StudentController(model);
		
		double GPA = model.getGpa();
		String Major = model.getMajor();
		int AdvisorID = model.getAdvisorId();
		// Decode form parameters and dispatch to controller
		

	

		// Add parameters as request attributes
	    req.setAttribute("GPA", GPA);
	    req.setAttribute("Major", Major);
	    req.setAttribute("AdvisorID", AdvisorID);

		// Add result objects as request attributes

			req.getRequestDispatcher("/_view/Static.jsp").forward(req, resp);
			req.getRequestDispatcher("/_view/SlideShow.jsp").forward(req, resp);
			req.getRequestDispatcher("/_view/Video.jsp").forward(req, resp);
		

		
		req.getRequestDispatcher("/_view/StudentMain.jsp").forward(req, resp);
	}
}