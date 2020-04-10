package edu.ycp.cs320.ycpdb.persist;

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
import edu.ycp.cs320.comm.model.Student;
import edu.ycp.cs320.comm.model.Pair;
import edu.ycp.cs320.sqldemo.DBUtil;

public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}

	private interface Transaction<ResultType> {
		public ResultType execute(Connection connycp) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;

	@Override
	public List<Pair<Advisor, Student>> findStudentUsernameByAdvisorUsername(final String aUsername) {
		return executeTransaction(new Transaction<List<Pair<Advisor, Student>>>() {
			@Override
			public List<Pair<Advisor, Student>> execute(Connection connycp) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables
					stmt = connycp.prepareStatement("select students.username " + "  from advisors, students "
							+ " where advisors.advisorId = students.advisorId " + "   and advisors.username = ?");
					stmt.setString(1, aUsername);

					List<Pair<Advisor, Student>> result = new ArrayList<Pair<Advisor, Student>>();

					resultSet = stmt.executeQuery();

					// for testing that a result was returned
					Boolean found = false;

					while (resultSet.next()) {
						found = true;

						// create new Author object
						// retrieve attributes from resultSet starting with index 1
						Advisor advisor = new Advisor();
						loadAdvisor(advisor, resultSet, 1);

						// create new Book object
						// retrieve attributes from resultSet starting at index 4
						Student student = new Student();
						loadStudent(student, resultSet, 4);

						result.add(new Pair<Advisor, Student>(advisor, student));
					}

					// check if the title was found
					if (!found) {
						System.out.println("<" + aUsername + "> was not found in the advisors table");
					}

					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	/*
	 * @Override public List<Pair<Author, Book>> findBooksByAuthorLastName(final
	 * String lastName) { return executeTransaction(new
	 * Transaction<List<Pair<Author,Book>>>() {
	 * 
	 * @Override public List<Pair<Author, Book>> execute(Connection conn) throws
	 * SQLException { PreparedStatement stmt = null; ResultSet resultSet = null;
	 * 
	 * try { // retreive all attributes from both Books and Authors tables stmt =
	 * conn.prepareStatement( "select authors.*, books.* " +
	 * "  from authors, books " + " where authors.author_id = books.author_id " +
	 * "   and authors.lastname = ?" + "  order by title ASC" ); stmt.setString(1,
	 * lastName);
	 * 
	 * List<Pair<Author, Book>> result = new ArrayList<Pair<Author,Book>>();
	 * 
	 * resultSet = stmt.executeQuery();
	 * 
	 * // for testing that a result was returned Boolean found = false;
	 * 
	 * while (resultSet.next()) { found = true;
	 * 
	 * // create new Author object // retrieve attributes from resultSet starting
	 * with index 1 Author author = new Author(); loadAuthor(author, resultSet, 1);
	 * 
	 * // create new Book object // retrieve attributes from resultSet starting at
	 * index 4 Book book = new Book(); loadBook(book, resultSet, 4);
	 * 
	 * result.add(new Pair<Author, Book>(author, book)); }
	 * 
	 * // check if the title was found if (!found) { System.out.println("<" +
	 * lastName + "> was not found in the books table"); }
	 * 
	 * return result; } finally { DBUtil.closeQuietly(resultSet);
	 * DBUtil.closeQuietly(stmt); } } }); }
	 * 
	 * @Override public List<Pair<Author, Book>> insertNewBookWithAuthor(String
	 * firstName, String lastName, String title, String isbn, int published) {
	 * return executeTransaction(new Transaction<List<Pair<Author,Book>>>() {
	 * 
	 * @Override public List<Pair<Author, Book>> execute(Connection conn) throws
	 * SQLException { // PreparedStatement references - one for each of the queries
	 * / inserts PreparedStatement stmtAuthorID1 = null; PreparedStatement
	 * stmtAuthorID2 = null; PreparedStatement stmtInsertAuthor = null;
	 * PreparedStatement stmtInsertBook = null; PreparedStatement stmtgetResults =
	 * null;
	 * 
	 * // ResultSet references - one for each query ResultSet resultSetAuthorID1 =
	 * null; ResultSet resultSetAuthorID2 = null; ResultSet resultSetgetResults =
	 * null;
	 * 
	 * try { stmtAuthorID1 = conn.prepareStatement( "select authors.author_id " +
	 * "  from authors " + "  where authors.firstname = ? and authors.lastname = ? "
	 * );
	 * 
	 * 
	 * stmtAuthorID1.setString(1, firstName); stmtAuthorID1.setString(2, lastName);
	 * resultSetAuthorID1 = stmtAuthorID1.executeQuery(); ResultSetMetaData
	 * resultSchema = stmtAuthorID1.getMetaData();
	 * 
	 * 
	 * int authorID = -1;
	 * 
	 * if (resultSetAuthorID1.next()) { authorID = resultSetAuthorID1.getInt(1);
	 * System.out.println("Existing author found in AUTHORS table\n"); } else {
	 * System.out.println("Inserting new author into AUTHORS table\n");
	 * stmtInsertAuthor = conn.prepareStatement(
	 * "insert into authors (lastname, firstname) " + "values (?, ?)" );
	 * stmtInsertAuthor.setString(1, lastName); stmtInsertAuthor.setString(2,
	 * firstName); stmtInsertAuthor.executeUpdate();
	 * 
	 * stmtAuthorID2 = conn.prepareStatement( "select authors.author_id " +
	 * "  from authors " + "  where authors.firstname = ? and authors.lastname = ? "
	 * ); stmtAuthorID2.setString(1, firstName); stmtAuthorID2.setString(2,
	 * lastName); resultSetAuthorID2 = stmtAuthorID2.executeQuery(); resultSchema =
	 * stmtAuthorID2.getMetaData();
	 * 
	 * if (resultSetAuthorID2.next()) { authorID = resultSetAuthorID2.getInt(1);
	 * 
	 * System.out.println("New author inserted into AUTHORS table with author_ID: "
	 * + authorID + "\n"); } else { System.out.
	 * println("Something very bad has happened - the new author was not found in the AUTHORS table"
	 * ); } }
	 * 
	 * stmtInsertBook = conn.prepareStatement(
	 * "insert into books (author_id, title, ISBN, published) " +
	 * "  values (?, ?, ?, ?)" );
	 * 
	 * stmtInsertBook.setInt(1, authorID); stmtInsertBook.setString(2, title);
	 * stmtInsertBook.setString(3, isbn); stmtInsertBook.setInt(4, published);
	 * 
	 * stmtInsertBook.executeUpdate();
	 * 
	 * System.out.println("New book inserted into BOOKS table with title <" + title
	 * + "> for author " + firstName + " " + lastName + "\n");
	 * 
	 * 
	 * stmtgetResults = conn.prepareStatement( "select * " +
	 * "  from authors, books " + "  where authors.author_id = books.author_id" );
	 * 
	 * 
	 * List<Pair<Author, Book>> result = new ArrayList<Pair<Author,Book>>();
	 * 
	 * resultSetgetResults = stmtgetResults.executeQuery();
	 * 
	 * // for testing that a result was returned Boolean found = false;
	 * 
	 * while (resultSetgetResults.next()) { found = true;
	 * 
	 * // create new Author object // retrieve attributes from resultSet starting
	 * with index 1 Author author = new Author(); loadAuthor(author,
	 * resultSetgetResults, 1);
	 * 
	 * // create new Book object // retrieve attributes from resultSet starting at
	 * index 4 Book book = new Book(); loadBook(book, resultSetgetResults, 4);
	 * 
	 * result.add(new Pair<Author, Book>(author, book)); }
	 * 
	 * return result;
	 * 
	 * } finally {
	 * 
	 * // close ResultSets DBUtil.closeQuietly(resultSetAuthorID1);
	 * DBUtil.closeQuietly(resultSetAuthorID2); DBUtil.closeQuietly(stmtgetResults);
	 * 
	 * // close PreparedStatements DBUtil.closeQuietly(stmtAuthorID1);
	 * DBUtil.closeQuietly(stmtAuthorID2); DBUtil.closeQuietly(stmtInsertAuthor);
	 * DBUtil.closeQuietly(stmtInsertBook); DBUtil.closeQuietly(stmtgetResults); } }
	 * }); }
	 * 
	 */

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
		Connection connycp = DriverManager.getConnection("jdbc:derby:test.db;create=true");

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
	}

	private void loadStudent(Student student, ResultSet resultSet, int index) throws SQLException {
		student.setStudentId(resultSet.getInt(index++));
		student.setAdvisorId(resultSet.getInt(index++));
		student.setFirstname(resultSet.getString(index++));
		student.setLastname(resultSet.getString(index++));
		student.setUsername(resultSet.getString(index++));
		student.setMajor(resultSet.getString(index++));
		student.setGpa(resultSet.getDouble(index++));
		student.setMinor(resultSet.getString(index++));
	}

	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection connycp) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;

				try {
					stmt1 = connycp.prepareStatement("create table advisors (" + "	advisorId integer primary key "
							+ "		generated always as identity (start with 1, increment by 1), "
							+ "	firstname varchar(40)," + "	lastname varchar(40)" + "	username varchar(40)" + ")");
					stmt1.executeUpdate();

					stmt2 = connycp.prepareStatement("create table students (" + "	studentId integer primary key "
							+ "		generated always as identity (start with 1, increment by 1), "
							+ "	advisorId integer constraint advisorId references advisors, "
							+ "	firstname varchar(40)," + "	lastname varchar(40)" + "	username varchar(40)"
							+ "	major varchar(70)," + "   gpa double " + "	minor varchar(15)," + ")");
					stmt2.executeUpdate();

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
							.prepareStatement("insert into advisors (firstname, lastname, username) values (?, ?, ?)");
					for (Advisor advisor : advisorList) {
//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
						insertAdvisor.setString(1, advisor.getFirstname());
						insertAdvisor.setString(2, advisor.getLastname());
						insertAdvisor.setString(3, advisor.getUsername());
						insertAdvisor.addBatch();
					}
					insertAdvisor.executeBatch();

					// populate books table (do this after authors table,
					// since author_id must exist in authors table before inserting book)
					insertStudent = connycp.prepareStatement(
							"insert into students (authorId, firstname, lastname, major, gpa, minor) values (?, ?, ?, ?, ?, ?)");
					for (Student student : studentList) {
//						insertBook.setInt(1, book.getBookId());		// auto-generated primary key, don't insert this
						insertStudent.setInt(1, student.getAdvisorId());
						insertStudent.setString(2, student.getFirstname());
						insertStudent.setString(3, student.getLastname());
						insertStudent.setString(4, student.getMajor());
						insertStudent.setDouble(5, student.getGpa());
						insertStudent.setString(4, student.getMinor());
						insertStudent.addBatch();
					}
					insertStudent.executeBatch();

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
