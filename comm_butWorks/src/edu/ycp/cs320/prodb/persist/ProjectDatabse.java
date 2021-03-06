package edu.ycp.cs320.prodb.persist;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;
import edu.ycp.cs320.sqldemo.DBUtil;

public class ProjectDatabse implements IDatabase2 {
	static {
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			System.out.print(e.getMessage());
			throw new IllegalStateException("Could not load Derby driver");
		}
	}

	public interface Transaction<ResultType> {
		public ResultType execute(Connection connpro) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;

	

	@Override
	public String findContentURLByStudentUsername(String username) 
	{
		return executeTransaction(new Transaction<String>() {

			public String execute(Connection connpro) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables

					stmt = connpro.prepareStatement("select studentspro.content" 
							+ " from studentspro "
							+ " where studentspro.username = ?");
					stmt.setString(1, username);

					String contentURL = new String();


					resultSet = stmt.executeQuery();
					if(resultSet.next())
					{
						contentURL = resultSet.getString(1);
					}
					return contentURL;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}

			
		});
	}
	
	public String findContentByQR(int qr) 
	{
		return executeTransaction(new Transaction<String>() {
			public String execute(Connection connpro) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables

					stmt = connpro.prepareStatement("select studentspro.content" 
							+ " from studentspro "
							+ " where studentspro.QR = ?");
					stmt.setInt(1, qr);

					String contentURL = new String();


					resultSet = stmt.executeQuery();
					if(resultSet.next())
					{
						contentURL = resultSet.getString(1);
					}
					return contentURL;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}

			
		});
	}

	
	public String findUserbyQR(int QR) {
		return executeTransaction(new Transaction<String>() {

			public String execute(Connection connpro) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables
					connpro.setAutoCommit(true);
					stmt = connpro.prepareStatement("select Username" 
							+ " from studentspro "
							+ " where studentspro.QR = ?");
					stmt.setInt(1, QR);

					String result = null;


					resultSet = stmt.executeQuery();

					// for testing that a result was returned
					Boolean found = false;
					if(resultSet.next())
					{
						found=true;
						result=resultSet.getString(1);
					}

					// check if the title was found
					if (!found) {
						System.out.println("<" + QR + "> is not found.");
					}
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
			
		});
	}	
	
	@Override
	public String findCommentByUsername(String username) 
	{
		return executeTransaction(new Transaction<String>() {

			public String execute(Connection connpro) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables
					connpro.setAutoCommit(true);
					stmt = connpro.prepareStatement("select comment" 
							+ " from studentspro "
							+ " where studentspro.username = ?");
					stmt.setString(1, username);

					String result = null;


					resultSet = stmt.executeQuery();

					// for testing that a result was returned
					Boolean found = false;
					if(resultSet.next())
					{
						found=true;
						result=resultSet.getString(1);
					}

					// check if the title was found
					if (!found) {
						System.out.println("<" + username + "> is not found.");
					}
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
			
		});
		
	}
	@Override
	public int findNotificationByUsername(String username) 
	{
		return executeTransaction(new Transaction<Integer>() {

			public Integer execute(Connection connpro) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables
					connpro.setAutoCommit(true);
					stmt = connpro.prepareStatement("select notification" 
							+ " from studentspro "
							+ " where studentspro.username = ?");
					stmt.setString(1, username);

					int result =0;


					resultSet = stmt.executeQuery();

					// for testing that a result was returned
					Boolean found = false;
					if(resultSet.next())
					{
						found=true;
						result=resultSet.getInt(1);
					}

					// check if the title was found
					if (!found) {
						System.out.println("<" + username + "> is not found.");
					}
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
			
		});
		
	}
	
	
	@Override
	public boolean insertNotificationByUsername(String username, int notification ) throws SQLException {
		return executeTransaction(new Transaction<Boolean>() {

			public Boolean execute(Connection connpro) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables
					connpro.setAutoCommit(true);
					stmt = connpro.prepareStatement("update studentspro" 
							+ " set notification= ? "
							+ " where studentspro.username = ?");
					
					stmt.setInt(1, notification);
					stmt.setString(2, username);
					
					stmt.executeUpdate();
					
					return true;
					
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	@Override
	public int findNotificationByUsernameAdvisor(String username) 
	{
		return executeTransaction(new Transaction<Integer>() {

			public Integer execute(Connection connpro) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables
					connpro.setAutoCommit(true);
					stmt = connpro.prepareStatement("select notification" 
							+ " from advisorspro "
							+ " where advisorspro.username = ?");
					stmt.setString(1, username);

					int result =0;


					resultSet = stmt.executeQuery();

					// for testing that a result was returned
					Boolean found = false;
					if(resultSet.next())
					{
						found=true;
						result=resultSet.getInt(1);
					}

					// check if the title was found
					if (!found) {
						System.out.println("<" + username + "> is not found.");
					}
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
			
		});
		
	}
	
	@Override
	public boolean insertNotificationByUsernameAdvisor(String username, int notification ) throws SQLException {
		return executeTransaction(new Transaction<Boolean>() {

			public Boolean execute(Connection connpro) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables
					connpro.setAutoCommit(true);
					stmt = connpro.prepareStatement("update advisorspro" 
							+ " set notification= ? "
							+ " where advisorspro.username = ?");
					
					stmt.setInt(1, notification);
					stmt.setString(2, username);
					
					stmt.executeUpdate();
					
					return true;
					
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	@Override
	public boolean insertCommentByUsername(String username, String comment ) throws SQLException {
		return executeTransaction(new Transaction<Boolean>() {

			public Boolean execute(Connection connpro) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables
					connpro.setAutoCommit(true);
					stmt = connpro.prepareStatement("update studentspro" 
							+ " set comment= ? "
							+ " where studentspro.username = ?");
					
					stmt.setString(1, comment);
					stmt.setString(2, username);
					
					stmt.executeUpdate();
					
					return true;
					
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	public String findStatusByUsername(String username) 
	{
		return executeTransaction(new Transaction<String>() {

			public String execute(Connection connpro) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables
					connpro.setAutoCommit(true);
					stmt = connpro.prepareStatement("select status" 
							+ " from studentspro "
							+ " where studentspro.username = ?");
					stmt.setString(1, username);

					String result = null;


					resultSet = stmt.executeQuery();

					// for testing that a result was returned
					Boolean found = false;
					if(resultSet.next())
					{
						found=true;
						result=resultSet.getString(1);
					}

					// check if the title was found
					if (!found) {
						System.out.println("<" + username + "> is not found.");
					}
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
					
				}
			}
			
		});
		
	}
	
	public boolean insertStatusByUsername(String username, String status ) throws SQLException {
		return executeTransaction(new Transaction<Boolean>() {

			public Boolean execute(Connection connpro) throws SQLException {
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables
					connpro.setAutoCommit(true);
					stmt = connpro.prepareStatement("update studentspro" 
							+ " set studentspro.status= ? "
							+ " where studentspro.username = ?");
					
					stmt.setString(1, status);
					stmt.setString(2, username);
					
					stmt.executeUpdate();
					System.out.println("updated");
					return true;
					
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	@Override
	public boolean insertContentTypeByUsername(String username, String contentType ) throws SQLException {
		return executeTransaction(new Transaction<Boolean>() {

			public Boolean execute(Connection connpro) throws SQLException {
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables
					connpro.setAutoCommit(true);
					stmt = connpro.prepareStatement("update studentspro" 
							+ " set studentspro.contentType= ? "
							+ " where studentspro.username = ?");
					
					stmt.setString(1, contentType);
					stmt.setString(2, username);
					
					stmt.executeUpdate();
					System.out.println("updated");
					return true;
					
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	public String findContentTypeByUsername(String username) 
	{
		return executeTransaction(new Transaction<String>() {

			public String execute(Connection connpro) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables
					connpro.setAutoCommit(true);
					stmt = connpro.prepareStatement("select contentType" 
							+ " from studentspro "
							+ " where studentspro.username = ?");
					stmt.setString(1, username);

					String result = null;


					resultSet = stmt.executeQuery();

					// for testing that a result was returned
					Boolean found = false;
					if(resultSet.next())
					{
						found=true;
						result=resultSet.getString(1);
					}

					// check if the title was found
					if (!found) {
						System.out.println("<" + username + "> is not found.");
					}
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
					
				}
			}
			
		});
		
	}
	
	
	@Override
	public boolean insertContentURLByStudentUsername(String username, String fileNameOfContent) throws SQLException, FileNotFoundException
	{
		//set up
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		// connect to the database
		conn = DriverManager.getConnection("jdbc:derby:C:/CS320-myComm-datbase/pro.db;create=true");
		
		try
		{
			//query to see if student exists in database first
			conn.setAutoCommit(true);
			PreparedStatement insertContent = null;
			insertContent = conn.prepareStatement("update studentspro "
					+"set studentspro.content = ? "
					+"where studentspro.username = ?");
			insertContent.setString(1, fileNameOfContent);
			insertContent.setString(2, username);
			insertContent.execute();
			return true;
		}
		catch(Exception e)
		{
			System.out.print(e.getStackTrace());
			System.out.print("Insertion error");
			return false;
		}
		finally
		{
			DBUtil.closeQuietly(conn);
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
		}
			
		
	}

	public <ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}

	public <ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection connpro = connect();

		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;

			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(connpro);
					connpro.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}

			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}

			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(connpro);
		}
	}

	private Connection connect() throws SQLException {
		Connection connpro = DriverManager.getConnection("jdbc:derby:C:/CS320-myComm-datbase/pro.db;create=true");

		// Set autocommit to false to allow execution of
		// multiple queries/statements as part of the same transaction.
		connpro.setAutoCommit(false);

		return connpro;
	}

	private void loadAdvisorPro(Advisor advisor, ResultSet resultSet, int index) throws SQLException {
		advisor.setUsername(resultSet.getString(index++));
		advisor.setPassword(resultSet.getString(index++));
	}

	private void loadStudentPro(Student student, ResultSet resultSet, int index) throws SQLException {
		student.setUsername(resultSet.getString(index++));
		student.setPassword(resultSet.getString(index++));
		student.setComment(resultSet.getString(index++));
		student.setStatus(resultSet.getString(index++));
		student.setContent(resultSet.getBlob(index++));
		student.setQR(resultSet.getInt(index++));
		student.setContentType(resultSet.getString(index++));
	}
	
//	private void loadContent(Content content, ResultSet resultSet, int index) throws SQLException
//	{
//		
//		content.setVideoFile((File) resultSet.getObject(index++));
//		content.setSlideShowImgs((List<Image>) resultSet.getArray(index++));
//		content.setStaticImage((Image) resultSet.getObject(index++));
//	}

	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection connycp) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;

				try {
					stmt1 = connycp.prepareStatement("create table advisorspro ("
							+ " username varchar(40),"
							+ " password varchar(40),"
							+ " notification Integer"
							+ " ) ");
					stmt1.executeUpdate();
					
					System.out.println("stmt1 executed");
					System.out.println("please");
					stmt2 = connycp.prepareStatement("create table studentspro (" 
							+ "	username varchar(40),"
							+ "	password varchar(40)," 
							+ " comment varchar(40),"
							+ " status varchar(40),"
							+ " content varchar(80),"
							+ " QR INTEGER,"
							+ " contentType varchar(40),"
							+ " notification INTEGER"
							+ " ) ");
					stmt2.executeUpdate();
					System.out.println("stmt2 executed");
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}

	public void loadInitialData2() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection connpro) throws SQLException {
				List<Advisor> advisorList;
				List<Student> studentList;

				try {
					advisorList = InitialData2.getAdvisors();
					studentList = InitialData2.getStudents();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertAdvisor = null;
				PreparedStatement insertStudent = null;

				try {
					// populate authors table (do authors first, since author_id is foreign key in
					// books table)
					insertAdvisor = connpro
							.prepareStatement("insert into advisorspro (username, password, notification) values (?,?, ?)");
					for (Advisor advisor : advisorList) {
//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
						insertAdvisor.setString(1, advisor.getUsername());
						insertAdvisor.setString(2, advisor.getPassword());
						insertAdvisor.setInt(3,  advisor.getNotification());
						insertAdvisor.addBatch();
					}
					insertAdvisor.executeBatch();
					System.out.println("Advisor data loaded");
					// populate books table (do this after authors table,
					// since author_id must exist in authors table before inserting book)
					insertStudent = connpro.prepareStatement(
							"insert into studentspro (Username, password, comment, status, content, QR, contentType, notification) values (?, ?,?, ?, ?, ?, ?, ?)");
					for (Student student : studentList) {
//						insertBook.setInt(1, book.getBookId());		// auto-generated primary key, don't insert this
						insertStudent.setString(1, student.getUsername());
						insertStudent.setString(2, student.getPassword());
						insertStudent.setString(3, student.getComment());
						insertStudent.setString(4, student.getStatus());
						insertStudent.setString(5, student.getContentURL());
						insertStudent.setInt(6, student.getQR());
						insertStudent.setString(7, student.getContentType());
						insertStudent.setInt(8, student.getNotification());
						insertStudent.addBatch();
					}
					insertStudent.executeBatch();
					System.out.println("student data loaded");
					return true;
				} finally {
					DBUtil.closeQuietly(insertStudent);
					DBUtil.closeQuietly(insertAdvisor);
				}
			}
		});
	}

	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		ProjectDatabse db = new ProjectDatabse();
		db.createTables();

		System.out.println("Loading initial data...");
		db.loadInitialData2();

		System.out.println("Success!");
	}

	
}
