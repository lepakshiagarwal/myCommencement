package edu.ycp.cs320.comm.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ycp.cs320.comm.controller.StudentController;
import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;
import edu.ycp.cs320.prodb.persist.DatabaseProvider2;
import edu.ycp.cs320.prodb.persist.IDatabase2;
import edu.ycp.cs320.prodb.persist.ProjectDatabse;
import edu.ycp.cs320.ycpdb.persist.DerbyDatabase;
import edu.ycp.cs320.ycpdb.persist.IDatabase;



public class StudentMainServlet extends HttpServlet {
	DatabaseProvider2 dbp;
	ProjectDatabse db;
	private static final long serialVersionUID = 1L;
	//for validate method
	private Student model;
	private StudentController controller;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

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
		GPA = Math.round(GPA*100)/100.0;
		
	    
		// Add parameters as request attributes
	  

		//req.getRequestDispatcher("/_view/Static.jsp").forward(req, resp);
		//req.getRequestDispatcher("/_view/SlideShow.jsp").forward(req, resp);
		//req.getRequestDispatcher("/_view/Video.jsp").forward(req, resp);	
			

	    String but = req.getParameter("button");
		System.out.println(but);	

		if(but .equals("Static")){
			System.out.println("gets static");	

			dbp.setInstance(new ProjectDatabse());
			db = (ProjectDatabse) dbp.getInstance();
			Student user = (Student) req.getSession().getAttribute("user");
			System.out.print(user.getUsername());
			String fileName = db.findContentURLByStudentUsername(user.getUsername());
			String username = user.getUsername();
			try {
				db.insertContentTypeByUsername(username, but);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String contentUrl = "uploaded-files/"+user.getUsername()+"/"+fileName;
			req.setAttribute("Url", contentUrl);
			req.getRequestDispatcher("/_view/Static.jsp").forward(req, resp);;
		}
		else if(but .equals("SlideShow"))
		{
			System.out.println("gets slide");	

			dbp.setInstance(new ProjectDatabse());
			db = (ProjectDatabse) dbp.getInstance();
			Student user = (Student) req.getSession().getAttribute("user");
			System.out.print(user.getUsername());
			String fileName = db.findContentURLByStudentUsername(user.getUsername());
			String username = user.getUsername();
			try {
				db.insertContentTypeByUsername(username, but);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String contentUrl = "uploaded-files/"+user.getUsername()+"/"+fileName;
			
			
			System.out.print(contentUrl);
			File root = new File("./war/uploaded-files/"+user.getUsername());
			String[] urls = root.list();
			for(int i=1;i<4;i++)
			{
				try
				{
				req.setAttribute("Url"+i, "uploaded-files/"+user.getUsername()+"/"+urls[i-1]);
				System.out.print(urls[i-1]);
				}
				catch(NullPointerException e)
				{
					e.printStackTrace();
					System.out.print("root directory is returning no files");
				}
			}
			
			req.getRequestDispatcher("/_view/SlideShow.jsp").forward(req, resp);;
		}
		else if(but .equals("Video"))
		{
			System.out.println("gets video");	
			dbp.setInstance(new ProjectDatabse());
			db = (ProjectDatabse) dbp.getInstance();
			Student user = (Student) req.getSession().getAttribute("user");
			System.out.print(user.getUsername());
			String fileName = db.findContentURLByStudentUsername(user.getUsername());
			String username = user.getUsername();
			try {
				db.insertContentTypeByUsername(username, but);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String contentUrl = "uploaded-files/"+user.getUsername()+"/"+fileName;
			req.setAttribute("Url", contentUrl);
			req.getRequestDispatcher("/_view/Video.jsp").forward(req, resp);;
		}else if(but .equals("Update Content")) {
			dbp.setInstance(new ProjectDatabse());
			db = (ProjectDatabse) dbp.getInstance();
			Student user = (Student) req.getSession().getAttribute("user");
			System.out.print(user.getUsername());
			String Comment = db.findCommentByUsername(user.getUsername());
			String Status = db.findStatusByUsername(user.getUsername());
			ArrayList<String> notification = new ArrayList<String>();
			int notify= db.findNotificationByUsername(user.getUsername());
			for(int j= 1; j<= notify; j++) {
			notification.add("Advisor has submitted feedback");
			}
			req.setAttribute("notification", notification);
			System.out.println(notification);
			 req.setAttribute("GPA", GPA);
			 req.setAttribute("Major", Major);
			 req.setAttribute("AdvisorID", AdvisorID);
			 req.setAttribute("Comment", Comment);
			 req.setAttribute("Status", Status);
			 
			 DatabaseProvider2.setInstance2((IDatabase) new DerbyDatabase());
				DerbyDatabase ycpdb = (DerbyDatabase) DatabaseProvider2.getInstance2();
			String name=ycpdb.findUsernameByAdvisorId(user.getAdvisorId());
				try {
				db.insertNotificationByUsernameAdvisor(name, notify++);
			} catch (SQLException e) {
				e.printStackTrace();
			}
				// Add result objects as request attributes
			   // req.setAttribute("AdvisorID", AdvisorID);
				req.getRequestDispatcher("/_view/StudentMain.jsp").forward(req, resp);
		}	   
	}//end dopost
	
}//end all