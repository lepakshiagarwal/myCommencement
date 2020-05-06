package edu.ycp.cs320.prodb.persist;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;

public class InitialData2 {
	public static List<Advisor> getAdvisors() throws IOException {
		List<Advisor> advisorList = new ArrayList<Advisor>();
		ReadCSV readAdvisors = new ReadCSV("advisorspro.csv");
		try {
			while (true) {
				List<String> tuple = readAdvisors.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Advisor Advisor = new Advisor();
				Advisor.setUsername(i.next());
				Advisor.setPassword(i.next());
				advisorList.add(Advisor);
			}
			return advisorList;
		} finally {
			readAdvisors.close();
		}
	}
	
	public static List<Student> getStudents() throws IOException {
		List<Student> studentList = new ArrayList<Student>();
		ReadCSV readstudents = new ReadCSV("studentspro.csv");
		try {
			while (true) {
				List<String> tuple = readstudents.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Student student = new Student();
				student.setUsername(i.next());
				student.setPassword(i.next());
				student.setComment(i.next());
				student.setStatus(i.next());
				//getting blob from string
				String value=i.next();
				byte[] bytes=value.getBytes();
				Blob blob=null;
				try {
					blob = new SerialBlob(bytes);
				} catch (SerialException e) {
					System.out.println("Error loading Blob");
					e.printStackTrace();
				} catch (SQLException e) {
					System.out.println("Error loading Blob");
					e.printStackTrace();
				}
				student.setContent(blob);
				student.setQR(Integer.parseInt(i.next()));
				studentList.add(student);
				student.setContentType(i.next());
			}
			return studentList;
		} finally {
			readstudents.close();
		}
	}
}
