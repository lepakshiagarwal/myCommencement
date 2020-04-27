package edu.ycp.cs320.prodb.persist;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Content;
import edu.ycp.cs320.comm.model.Student;

public interface IDatabase2 {

	Student findStudentByLogin(String username, String password);

	Content findContentByStudentUsername(String username);
	
	Content findContentByQR(int qr);

	void insertContentURLByStudentUsername(String username, String fileNameOfContent)
			throws SQLException, FileNotFoundException;

	void insertCommentByUsername(String username, String comment) throws SQLException;

	
}
