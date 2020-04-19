package edu.ycp.cs320.ycpdb.persist;

import java.util.List;

import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Pair;
import edu.ycp.cs320.comm.model.Student;

public interface IDatabase {
	List<Student> findStudentsByAdvisorUsername(final int aUsername);
	
}
