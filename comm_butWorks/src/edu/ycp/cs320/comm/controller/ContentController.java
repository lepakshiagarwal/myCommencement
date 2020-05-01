package edu.ycp.cs320.comm.controller;

import edu.ycp.cs320.comm.model.Content;
import edu.ycp.cs320.prodb.persist.DatabaseProvider;
import edu.ycp.cs320.prodb.persist.IDatabase2;
import edu.ycp.cs320.prodb.persist.ProjectDatabse;

public class ContentController {

	private IDatabase2 db    = null;

	public ContentController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new ProjectDatabse());
		db = DatabaseProvider.getInstance();		
	}

	public Content getCont(String username) {
		
		Content cont = db.findContentByStudentUsername(username);
		
		if (cont == null) {
			System.out.println("No content in database");
			return null;
		}
		else {
			return cont;
		}
	}
		public String ContentbyQR(int QR) {
			
			String cont = db.findContentByQR(QR);
			
			if (cont == null) {
				System.out.println("No content in database");
				return null;
			}
			else {
				return cont;
			}
		
		// return list of book,author pairs
	}
}
