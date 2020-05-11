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
	
	String findContentByQR(int qr);
	
	String findUserbyQR(int qr);

	boolean insertContentURLByStudentUsername(String username, String fileNameOfContent)
			throws SQLException, FileNotFoundException;

	boolean insertCommentByUsername(String username, String comment) throws SQLException;


	String findCommentByUsername(String username);

	boolean insertStatusByUsername(String username, String status) throws SQLException;

	String findStatusByUsername(String username);

	Content findContentByStudentUsername(String username);

	boolean insertContentTypeByUsername(String username, String contentType) throws SQLException;

	String findContentTypeByUsername(String username);

	boolean insertNotificationByUsername(String username, int notification) throws SQLException;


	int findNotificationByUsername(String username);

	boolean insertNotificationByUsernameAdvisor(String username, int notification) throws SQLException;

	int findNotificationByUsernameAdvisor(String username);
}
