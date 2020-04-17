package edu.ycp.cs320.ycpdb.persist;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;

public class InitialData {
	public static List<Advisor> getAdvisors() throws IOException {
		List<Advisor> advisorList = new ArrayList<Advisor>();
		ReadCSV readAdvisors = new ReadCSV("advisors.csv");
		try {
			// auto-generated primary key for advisors table
			Integer advisorId = 1;
			while (true) {
				List<String> tuple = readAdvisors.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Advisor Advisor = new Advisor();
				Advisor.setAdvisorId(advisorId++);	
				Advisor.setFirstname(i.next());
				Advisor.setLastname(i.next());
				Advisor.setUsername(i.next());
				advisorList.add(Advisor);
			}
			return advisorList;
		} finally {
			readAdvisors.close();
		}
	}
	
	public static List<Student> getStudents() throws IOException {
		List<Student> studentList = new ArrayList<Student>();
		ReadCSV readstudents = new ReadCSV("students.csv");
		try {
			// auto-generated primary key for students table
			Integer studentId = 1;
			while (true) {
				List<String> tuple = readstudents.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Student student = new Student();
				student.setStudentId(studentId++);
				student.setAdvisorId(Integer.parseInt(i.next()));
				student.setFirstname(i.next());
				student.setLastname(i.next());
				student.setUsername(i.next());
				student.setMajor(i.next());
				student.setGpa(Double.parseDouble(i.next()));
				student.setMinor(i.next());
				//student.getContent(File.parseFile(i.next()));
				studentList.add(student);
			}
			return studentList;
		} finally {
			readstudents.close();
		}
	}
}
