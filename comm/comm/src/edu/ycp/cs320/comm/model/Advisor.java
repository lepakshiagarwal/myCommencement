package edu.ycp.cs320.comm.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Advisor {
	private ArrayList<String> usernames;
	private ArrayList<String> passwords;
	private Map<String, String> credentials;
	private ArrayList<String> adviceList1;
	private ArrayList<String> adviceList2;
	private Map<String, ArrayList<String>> Advices;
 
	public Advisor() {
		usernames = new ArrayList<String>();
		passwords = new ArrayList<String>();
		credentials = new TreeMap<String, String>();

		usernames.add("Mshae");
		passwords.add("xyz");
		usernames.add("Rshae");
		passwords.add("abc");
		
		adviceList1.add("lepakshi");
		adviceList1.add("John");
		adviceList2.add("austin");
		adviceList2.add("jake");
		
		Advices.put("Mshae", adviceList1);
		Advices.put("Mshae", adviceList2);
		
		
		for (int i = 0; i < usernames.size(); i++) {
			credentials.put(usernames.get(i), passwords.get(i));
		}
	}

	public boolean validateUserName(String name) {
		return credentials.containsKey(name);
	}

	public boolean validatePassword(String name, String password) {
		if (credentials.containsKey(name)) {
			if  (credentials.get(name).equals(password)) {
				return true;
			}
		}			
		return false;
	}
		
	public ArrayList<String> adviceList(String name){
		return Advices.get(name);
	}
}
