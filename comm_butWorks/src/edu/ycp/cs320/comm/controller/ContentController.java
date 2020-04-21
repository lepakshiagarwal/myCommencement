package edu.ycp.cs320.comm.controller;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.comm.model.Content;
import edu.ycp.cs320.ycpdb.persist.DatabaseProvider;
import edu.ycp.cs320.ycpdb.persist.DerbyDatabase;
import edu.ycp.cs320.ycpdb.persist.IDatabase;

public class ContentController {

	private IDatabase db    = null;

	public ContentController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
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
		
		// return list of book,author pairs
	}
}
