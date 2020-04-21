package edu.ycp.cs320.prodb.persist;

import java.util.List;

import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Content;
import edu.ycp.cs320.comm.model.Student;

public interface IDatabase2 {

	Student findStudentByLogin(String username, String password);

	Content findContentByStudentUsername(String username);
	
}
