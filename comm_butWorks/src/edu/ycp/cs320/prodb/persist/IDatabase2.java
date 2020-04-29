package edu.ycp.cs320.prodb.persist;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Content;
import edu.ycp.cs320.comm.model.Student;

public interface IDatabase2 {

	Student findStudentByLogin(String username, String password);

	String findContentURLByStudentUsername(String username);
	
	Content findContentByQR(int qr);

	boolean insertContentURLByStudentUsername(String username, String fileNameOfContent)
			throws SQLException, FileNotFoundException;

	boolean insertCommentByUsername(String username, String comment) throws SQLException;

	Content findContentByStudentUsername(String username);

	
}
