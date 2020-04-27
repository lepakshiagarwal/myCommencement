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


public class QRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//for validate method
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("QR Servlet: doGet");	

		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/QRCode.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {


		System.out.println("QR Servlet: doPost");

	







		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/QRCode.jsp").forward(req, resp);
	}
}