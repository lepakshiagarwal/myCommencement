package edu.ycp.cs320.ycpdb.persist;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Content;
import edu.ycp.cs320.comm.model.Student;
import edu.ycp.cs320.sqldemo.DBUtil;

public class DerbyDatabase implements IDatabase {
	static {
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			System.out.print(e.getMessage());
			throw new IllegalStateException("Could not load Derby driver");
			
		}
	}

	public interface Transaction<ResultType> {
		public ResultType execute(Connection connycp) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;

	@Override

	public ArrayList<Student> findStudentsByAdvisorId(final int advId) {
		return executeTransaction(new Transaction<ArrayList<Student>>() {

			public ArrayList<Student> execute(Connection connycp) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables

					stmt = connycp.prepareStatement("select students.* " 
							+ " from advisors, students "
							+ " where advisors.advisorId = students.advisorId " 
							+ " and advisors.advisorId = ?");
					stmt.setInt(1, advId);

					ArrayList<Student> result = new ArrayList<Student>();


					resultSet = stmt.executeQuery();

					// for testing that a result was returned
					Boolean found = false;

					while (resultSet.next()) {
						found = true;

						// create new Author object
						// retrieve attributes from resultSet starting with index 1
					
						// create new Book object
						// retrieve attributes from resultSet starting at index 4
						//why 4? -Shea
						Student student = new Student();
						loadStudent(student, resultSet, 1);


						result.add(student);

					}

					// check if the title was found
					if (!found) {
						System.out.println("<" + advId + "> was not found in the advisors table");
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
	public Student findStudentByLogin(final String username, final String password) {
		return executeTransaction(new Transaction<Student>() {

			public Student execute(Connection connycp) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables
					
					
					
					stmt = connycp.prepareStatement("select * " 
							+ " from students "
							+ " where students.username= ? " 
							+ " and students.password = ?"
							);
					stmt.setString(1, username);
					stmt.setString(2, password);

					Student result = null;


					resultSet = stmt.executeQuery();

					// for testing that a result was returned
					Boolean found = false;

					while (resultSet.next()) {
						found = true;

						result = new Student();
						
						loadStudent(result, resultSet, 1);

					}

					// check if the title was found
					if (!found) {
						System.out.println("<User> was not found in the student table");
					}

					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	public Advisor findAdvisorByLogin(final String username, final String password) {
		return executeTransaction(new Transaction<Advisor>() {

			public Advisor execute(Connection connycp) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					stmt = connycp.prepareStatement("select * " 
							+ "from advisors "
							+ "where advisors.username = ? " 
							+ "and advisors.password = ?"
							);
					stmt.setString(1, username);
					stmt.setString(2, password);

					Advisor result = null;


					resultSet = stmt.executeQuery();

					// for testing that a result was returned
					Boolean found = false;

					while (resultSet.next()) 
					{
						found = true;
						result=new Advisor();
						loadAdvisor(result, resultSet, 1);

					}
					if (!found) {
						System.out.println("<User> was not found in the advisors table");
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
	public Content findContentByStudentUsername(String username) 
	{
		return executeTransaction(new Transaction<Content>() {

			public Content execute(Connection connycp) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables

					stmt = connycp.prepareStatement("select *" 
							+ " from students "
							+ " where students.username = ?");
					stmt.setString(1, username);

					Content result = new Content();


					resultSet = stmt.executeQuery();

					// for testing that a result was returned
					Boolean found = false;
					resultSet.next();
					if(resultSet.next())
					{
						found=true;
						loadContent(result, resultSet, 1);
						
						
					}

					// check if the title was found
					if (!found) {
						System.out.println("<" + username + "> was not found in the advisors table");
					}

					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}

			
		});
	}


	public <ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}

	public <ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection connycp = connect();

		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;

			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(connycp);
					connycp.commit();
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
			DBUtil.closeQuietly(connycp);
		}
	}

	private Connection connect() throws SQLException {
		Connection connycp = DriverManager.getConnection("jdbc:derby:C:/CS320-myComm-datbase/ycp.db;create=true");

		// Set autocommit to false to allow execution of
		// multiple queries/statements as part of the same transaction.
		connycp.setAutoCommit(false);

		return connycp;
	}

	private void loadAdvisor(Advisor advisor, ResultSet resultSet, int index) throws SQLException {
		advisor.setAdvisorId(resultSet.getInt(index++));
		advisor.setFirstname(resultSet.getString(index++));
		advisor.setLastname(resultSet.getString(index++));
		advisor.setUsername(resultSet.getString(index++));
		advisor.setPassword(resultSet.getString(index++));
	}

	private void loadStudent(Student student, ResultSet resultSet, int index) throws SQLException {
		student.setStudentId(resultSet.getInt(index++));
		student.setAdvisorId(resultSet.getInt(index++));
		student.setFirstname(resultSet.getString(index++));
		student.setLastname(resultSet.getString(index++));
		student.setUsername(resultSet.getString(index++));
		student.setMajor(resultSet.getString(index++));
		student.setGpa(resultSet.getFloat(index++));
		student.setMinor(resultSet.getString(index++));
		student.setPassword(resultSet.getString(index++));
	}
	
	private void loadContent(Content content, ResultSet resultSet, int index) throws SQLException
	{
		
		content.setVideoFile((File) resultSet.getObject(index++));
		content.setSlideShowImgs((List<Image>) resultSet.getArray(index++));
		content.setStaticImage((Image) resultSet.getObject(index++));
	}
	{
		// TODO Auto-generated method stub
		
	}

	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection connycp) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;

				try {
					stmt1 = connycp.prepareStatement("create table advisors (" 
							+ "	advisorId integer primary key "
							+ "	generated always as identity (start with 1, increment by 1), "
							+ "	firstname varchar(40)," 
							+ "	lastname varchar(40)," 
							+ " username varchar(40),"
							+ " password varchar(40)"
							+ " ) ");
					stmt1.executeUpdate();
					
					System.out.println("stmt1 executed");
					stmt2 = connycp.prepareStatement("create table students (" 
							+ "	studentId integer primary key "
							+ "	generated always as identity (start with 1, increment by 1), "
							+ "	advisorId integer constraint advisorId references advisors, "
							+ "	firstname varchar(40)," 
							+ "	lastname varchar(40)," 
							+ "	username varchar(40),"
							+ "	major varchar(70)," 
							+ " gpa  float(40), " 
							+ "	minor varchar(15),"
							+ " password varchar(40)"
							+ ")");
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

	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection connycp) throws SQLException {
				List<Advisor> advisorList;
				List<Student> studentList;

				try {
					advisorList = InitialData.getAdvisors();
					studentList = InitialData.getStudents();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertAdvisor = null;
				PreparedStatement insertStudent = null;

				try {
					// populate authors table (do authors first, since author_id is foreign key in
					// books table)
					insertAdvisor = connycp
							.prepareStatement("insert into advisors (firstname, lastname, username, password) values (?, ?, ?, ?)");
					for (Advisor advisor : advisorList) {
//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
						insertAdvisor.setString(1, advisor.getFirstname());
						insertAdvisor.setString(2, advisor.getLastname());
						insertAdvisor.setString(3, advisor.getUsername());
						insertAdvisor.setString(4, advisor.getPassword());
						insertAdvisor.addBatch();
					}
					insertAdvisor.executeBatch();
					System.out.println("Advisor data loaded");
					// populate books table (do this after authors table,
					// since author_id must exist in authors table before inserting book)
					insertStudent = connycp.prepareStatement(
							"insert into students (advisorId, firstname, lastname, Username, major, gpa, minor, password) values (?, ?, ?, ?, ?, ?, ?, ?)");
					for (Student student : studentList) {
//						insertBook.setInt(1, book.getBookId());		// auto-generated primary key, don't insert this
						insertStudent.setInt(1, student.getAdvisorId());
						insertStudent.setString(2, student.getFirstname());
						insertStudent.setString(3, student.getLastname());
						insertStudent.setString(4, student.getUsername());
						insertStudent.setString(5, student.getMajor());
						insertStudent.setFloat(	6, student.getGpa());
						insertStudent.setString(7, student.getMinor());
						insertStudent.setString(8, student.getPassword());
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
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();

		System.out.println("Loading initial data...");
		db.loadInitialData();

		System.out.println("Success!");
	}

	


	
}
