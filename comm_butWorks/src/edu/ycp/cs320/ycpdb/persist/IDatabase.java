package edu.ycp.cs320.ycpdb.persist;

import java.util.List;

import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;

public interface IDatabase {
	List<Student> findStudentsByAdvisorId(int advId);

	Student findStudentByLogin(String username, String password);


	String findnmaeByAdvisorId(int id);
	
}
