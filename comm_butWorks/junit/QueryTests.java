

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.prodb.persist.*;
import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;
import edu.ycp.cs320.ycpdb.persist.DatabaseProvider;
import edu.ycp.cs320.ycpdb.persist.DerbyDatabase;
import edu.ycp.cs320.ycpdb.persist.IDatabase;

public class QueryTests 
{
	public DerbyDatabase db;
	public ProjectDatabse pdb;
	
	@Before
	public void setUp()
	{
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = (DerbyDatabase) DatabaseProvider.getInstance();
		DatabaseProvider2.setInstance((IDatabase2) new ProjectDatabse());
		pdb = (ProjectDatabse) DatabaseProvider2.getInstance();
	}
	
	
	
	
	
	//YCP Database Query Testing
	@Test
	public void testfindAdvisorByLogin()
	{
		Advisor newton = db.findAdvisorByLogin("inewton", "abc");
		Advisor scott = db.findAdvisorByLogin("ascott", "xyz");
		Advisor badPassword =db.findAdvisorByLogin("ascott", "123");
		Advisor badUsername = db.findAdvisorByLogin("notausername", "abc");
		
		assertTrue(newton.getLastname().equals("Newton"));
		assertTrue(scott.getLastname().equals("Scott"));
		
		assertTrue((badPassword==null));
		assertTrue((badUsername==null));
		
	}
	
	@Test
	public void testfindStudentByLogin()
	{
		Student agarwal = db.findStudentByLogin("lagarwal", "abc");
		Student melendez = db.findStudentByLogin("smelendez", "123");
		Student badPassword =db.findStudentByLogin("lagarwal", "123");
		Student badUsername = db.findStudentByLogin("notausername", "abc");
		
		assertTrue(agarwal.getLastname().equals("Agarwal"));
		assertTrue(melendez.getLastname().equals("Melendez"));
		assertTrue(badPassword==null);
		assertTrue(badUsername==null);
	}
	
	@Test
	public void testfindStudentsByAdvisorId()
	{
		List<Student> advisees = db.findStudentsByAdvisorId(1);
		assertTrue(advisees.get(0).getFirstname().equals("Lepakshi"));
		assertTrue(advisees.get(1).getFirstname().equals("Austin"));
		advisees= db.findStudentsByAdvisorId(2);
		assertTrue(advisees.get(0).getFirstname().equals("Shae"));
		assertTrue(advisees.get(1).getFirstname().equals("Shea"));
		assertFalse(advisees.get(2).getFirstname().equals("Shea"));
	}
	
	@Test
	public void testFindUsernameByAdvisorID()
	{
		assertEquals(db.findUsernameByAdvisorId(1),"inewton");
		assertEquals(db.findUsernameByAdvisorId(2),"ascott");
		assertEquals(db.findUsernameByAdvisorId(3),"bberkeley");

	}
	
	@Test
	public void testFindStudentByUsername()
	{
		assertEquals(db.findStudentByStudentUsername("sriordan3").getFirstname(),"Shea");
		assertEquals(db.findStudentByStudentUsername("acanzano").getLastname(),"Canzano");
		assertEquals(db.findStudentByStudentUsername("smelendez").getMajor(),"Computer Science");
		
	}
	
	
	
	
	
	
	
	
	//Project Database Query Testing
	@Test
	public void testInsertAndFindContentURLByUsername() throws FileNotFoundException, SQLException
	{
		String filename = "B~A~S~S";
		String username1 = "sriordan3";
		String username2 = "acanzano";
		//check that insert returns positive values he functional, no sql insertion error
		assertTrue(pdb.insertContentURLByStudentUsername(username1, filename));
		assertTrue(pdb.insertContentURLByStudentUsername(username2, filename));
		String URL = pdb.findContentURLByStudentUsername(username1);
		
		assertEquals(pdb.findContentURLByStudentUsername(username1),"B~A~S~S");
		assertEquals(pdb.findContentURLByStudentUsername(username2), "B~A~S~S");
		
		
	}
	
	@Test
	public void testFindAndInsertContentURLByQR() throws FileNotFoundException, SQLException
	{
		pdb.insertContentURLByStudentUsername("sriordan3", "GreatContent");
		assertEquals(pdb.findContentByQR(53142),"GreatContent");
		pdb.insertContentURLByStudentUsername("acanzano", "AwesomeContent");
		assertEquals(pdb.findContentByQR(54321),"AwesomeContent");
	}
	
	@Test
	public void testFindUserByQR() 
	{
		//these values have been hardcoded into the database
		assertEquals(pdb.findUserbyQR(53142),"sriordan3");
		assertEquals(pdb.findUserbyQR(54321),"acanzano");
	}
	
	//This test passes, as long as the comment isn't too long
	//Once the comment reaches a certain length, it will surpass
	//the varchar limit set in the database
	@Test
	public void testInsertAndFindCommentByUsername() throws SQLException
	{
		String comment1 = "Best Content Ever";
		String comment2 = "";
		String comment3 = "Not gonna fly";
		
		pdb.insertCommentByUsername("sriordan3", comment1);
		pdb.insertCommentByUsername("acanzano", comment2);
		pdb.insertCommentByUsername("lagarwal", comment3);
		
		assertEquals(pdb.findCommentByUsername("sriordan3"),comment1);
		assertEquals(pdb.findCommentByUsername("acanzano"),comment2);
		assertEquals(pdb.findCommentByUsername("lagarwal"),comment3);
	}
	
	@Test
	public void testInsertAndFindNotificationByUsername() throws SQLException
	{
		
		pdb.insertNotificationByUsername("sriordan3", 1);
		pdb.insertNotificationByUsername("acanzano", 2);
		pdb.insertNotificationByUsername("lagarwal", 3);
		
		assertEquals(pdb.findNotificationByUsername("sriordan3"),1);
		assertEquals(pdb.findNotificationByUsername("acanzano"),2);
		assertEquals(pdb.findNotificationByUsername("lagarwal"),3);
	}
	
	@Test
	public void testInsertAndFindNotificationByUsernameAdvisor() throws SQLException
	{
		
		pdb.insertNotificationByUsernameAdvisor("inewton", 1);
		pdb.insertNotificationByUsernameAdvisor("ascott", 2);
		pdb.insertNotificationByUsernameAdvisor("bberkeley", 3);
		
		assertEquals(pdb.findNotificationByUsernameAdvisor("inewton"),1);
		assertEquals(pdb.findNotificationByUsernameAdvisor("ascott"),2);
		assertEquals(pdb.findNotificationByUsernameAdvisor("bberkeley"),3);
	}
	
	@Test
	public void testInsertAndFindStatusByUsername() throws SQLException
	{
		String Status1 = "Approved";
		String Status2 = "";
		String Status3 = "Denied";
		
		pdb.insertCommentByUsername("sriordan3", Status1);
		pdb.insertCommentByUsername("acanzano", Status2);
		pdb.insertCommentByUsername("lagarwal", Status3);
		
		assertEquals(pdb.findCommentByUsername("sriordan3"),Status1);
		assertEquals(pdb.findCommentByUsername("acanzano"),Status2);
		assertEquals(pdb.findCommentByUsername("lagarwal"),Status3);
	}
	
	@Test
	public void testInsertAndFindContentTypeByUsername() throws SQLException
	{
		String ContentType1 = "Static";
		String ContentType2 = "Slideshow";
		String ContentType3 = "Video";
		
		pdb.insertCommentByUsername("sriordan3", ContentType1);
		pdb.insertCommentByUsername("acanzano", ContentType2);
		pdb.insertCommentByUsername("lagarwal", ContentType3);
		
		assertEquals(pdb.findCommentByUsername("sriordan3"),ContentType1);
		assertEquals(pdb.findCommentByUsername("acanzano"),ContentType2);
		assertEquals(pdb.findCommentByUsername("lagarwal"),ContentType3);
	}
}