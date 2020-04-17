package edu.ycp.cs320.comm.controller;

import edu.ycp.cs320.ycpdb.persist.DatabaseProvider;
import edu.ycp.cs320.ycpdb.persist.DerbyDatabase;

public class StaticController {
	private edu.ycp.cs320.ycpdb.persist.IDatabase db = null;

	public StaticController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}
	
}
