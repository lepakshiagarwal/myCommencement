package edu.ycp.cs320.prodb.persist;

import edu.ycp.cs320.ycpdb.persist.IDatabase;

public class DatabaseProvider {
	private static IDatabase2 theInstance;
	
	public static void setInstance(IDatabase2 db) {
		theInstance = db;
	}
	
	public static IDatabase2 getInstance() {
		if (theInstance == null) {
			throw new IllegalStateException("IDatabase2 instance has not been set!");
		}
		return theInstance;
	}
private static IDatabase heInstance;
	
	public static void setInstance2(IDatabase db) {
		heInstance = db;
	}
	
	public static IDatabase getInstance2() {
		if (heInstance == null) {
			throw new IllegalStateException("IDatabase instance has not been set!");
		}
		return heInstance;
	}
}
