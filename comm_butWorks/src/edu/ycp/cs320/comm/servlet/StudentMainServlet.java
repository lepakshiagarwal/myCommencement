package edu.ycp.cs320.comm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ycp.cs320.comm.controller.ContentController;
import edu.ycp.cs320.comm.controller.StudentController;
import edu.ycp.cs320.comm.model.Content;
import edu.ycp.cs320.comm.model.Student;
import edu.ycp.cs320.ycpdb.persist.DatabaseProvider;
import edu.ycp.cs320.ycpdb.persist.DerbyDatabase;


public class StudentMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//for validate method
	private Student model;
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
		
		

		
		
	    
	    
		
		double GPA = model.getGpa();
		String Major = model.getMajor();
		int AdvisorID = model.getAdvisorId();
		// Decode form parameters and dispatch to controller
		

	

		// Add parameters as request attributes
	  

		//req.getRequestDispatcher("/_view/Static.jsp").forward(req, resp);
		//req.getRequestDispatcher("/_view/SlideShow.jsp").forward(req, resp);
		//req.getRequestDispatcher("/_view/Video.jsp").forward(req, resp);	
		ContentController concontroller = new ContentController();
		Content cont = concontroller.getCont(model.getUsername());
	    String but = req.getParameter("button");
		if(but .equals("Static")){
		    req.setAttribute("img", cont);
			req.getRequestDispatcher("/_view/Static.jsp").forward(req, resp);
		}
		else if(but .equals("SlideShow"))
		{
		    req.setAttribute("slideshow", cont);
			req.getRequestDispatcher("/_view/SlideShow.jsp").forward(req, resp);
		}
		else if(but .equals("Video"))
		{
		    req.setAttribute("video", cont);
			req.getRequestDispatcher("/_view/Video.jsp").forward(req, resp);	
		}else if(but .equals("Update Content")) {
			  req.setAttribute("GPA", GPA);
			    req.setAttribute("Major", Major);
			    req.setAttribute("AdvisorID", AdvisorID);

				// Add result objects as request attributes
			    req.setAttribute("AdvisorID", AdvisorID);
				req.getRequestDispatcher("/_view/StudentMain.jsp").forward(req, resp);

		}
		
		
		
		
		
		
		
	   
	}//end dopost
	
}//end all