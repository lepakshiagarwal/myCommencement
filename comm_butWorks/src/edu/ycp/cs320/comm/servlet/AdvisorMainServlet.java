package edu.ycp.cs320.comm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.comm.controller.AdvisorController;
import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;
import edu.ycp.cs320.prodb.persist.ProjectDatabse;

@WebServlet("/AdvisorMainServlet")
public class AdvisorMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectDatabse prodb;

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
		String name = req.getParameter("name");
		System.out.print(name);
	    boolean viewContent = req.getParameter("content") != null;
	    String status = req.getParameter("Status") ;
	    System.out.print(status);
	    String comment = req.getParameter("comment");
	    System.out.print(comment);
	    boolean submitButtonPressed = req.getParameter("submit") != null;
	    try {
	    	boolean inserted=	prodb.insertCommentByUsername(name, comment);
	    	System.out.print(inserted);
			prodb.insertStatusByUsername(name, status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    if(submitButtonPressed) {
	    	// get response writer
	        PrintWriter writer = resp.getWriter();
	         
	        // build HTML code
	        String htmlRespone = "<html>";
	        htmlRespone += "<h1>Thank you for submitting Your response to submit another response click back! </h1>";      
	        htmlRespone += "<br><br><button  style=\"height:60px;width:120px\" ><a href=\" http://localhost:8081/lab02/AdvisorMain\"><h2>Back!</h2></a></button></h2>";    
	        htmlRespone += "</html>";
	         
	        // return response
	        writer.println(htmlRespone);
	         
	    }
		
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