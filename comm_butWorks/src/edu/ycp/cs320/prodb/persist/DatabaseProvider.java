package edu.ycp.cs320.prodb.persist;

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
}
