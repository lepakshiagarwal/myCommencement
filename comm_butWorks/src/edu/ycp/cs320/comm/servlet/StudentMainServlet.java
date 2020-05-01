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
import edu.ycp.cs320.prodb.persist.DatabaseProvider;
import edu.ycp.cs320.prodb.persist.ProjectDatabse;



public class StudentMainServlet extends HttpServlet {
	DatabaseProvider dbp;
	ProjectDatabse db;
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
		
	
      Object stud = req.getSession().getAttribute("user");

		
		
	    
	    
		
		double GPA = ((Student) stud).getGpa();
		String Major = ((Student) stud).getMajor();
		int AdvisorID = ((Student) stud).getAdvisorId();
		//String user = ((Student) stud).getUsername();
		GPA = Math.round(GPA*100)/100.0;
		// Add parameters as request attributes
	  

		//req.getRequestDispatcher("/_view/Static.jsp").forward(req, resp);
		//req.getRequestDispatcher("/_view/SlideShow.jsp").forward(req, resp);
		//req.getRequestDispatcher("/_view/Video.jsp").forward(req, resp);	
			

	    String but = req.getParameter("button");
		System.out.println(but);	

		if(but .equals("Static")){
			dbp.setInstance(new ProjectDatabse());
			db = (ProjectDatabse) dbp.getInstance();
			Student user = (Student) req.getSession().getAttribute("user");
			System.out.print(user.getUsername());
			String fileName = db.findContentURLByStudentUsername(user.getUsername());
			String contentUrl = "uploaded-files/"+user.getUsername()+"/"+fileName;
			req.setAttribute("Url", contentUrl);
			req.getRequestDispatcher("/_view/Static.jsp").forward(req, resp);;
		}
		else if(but .equals("SlideShow"))
		{
			dbp.setInstance(new ProjectDatabse());
			db = (ProjectDatabse) dbp.getInstance();
			Student user = (Student) req.getSession().getAttribute("user");
			System.out.print(user.getUsername());
			String fileName = db.findContentURLByStudentUsername(user.getUsername());
			String contentUrl = "uploaded-files/"+user.getUsername()+"/"+fileName;
			req.setAttribute("Url", contentUrl);
			req.getRequestDispatcher("/_view/Video.jsp").forward(req, resp);;
		}
		else if(but .equals("Video"))
		{
			dbp.setInstance(new ProjectDatabse());
			db = (ProjectDatabse) dbp.getInstance();
			Student user = (Student) req.getSession().getAttribute("user");
			System.out.print(user.getUsername());
			String fileName = db.findContentURLByStudentUsername(user.getUsername());
			String contentUrl = "uploaded-files/"+user.getUsername()+"/"+fileName;
			req.setAttribute("Url", contentUrl);
			req.getRequestDispatcher("/_view/Video.jsp").forward(req, resp);;
		}else if(but .equals("Update Content")) {
			 req.setAttribute("GPA", GPA);
			 req.setAttribute("Major", Major);
			 req.setAttribute("AdvisorID", AdvisorID);

				// Add result objects as request attributes
			   // req.setAttribute("AdvisorID", AdvisorID);
				req.getRequestDispatcher("/_view/StudentMain.jsp").forward(req, resp);
		}	   
	}//end dopost
	
}//end all