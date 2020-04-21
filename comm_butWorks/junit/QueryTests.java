

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.comm.model.Advisor;
import edu.ycp.cs320.comm.model.Student;
import edu.ycp.cs320.ycpdb.persist.DatabaseProvider;
import edu.ycp.cs320.ycpdb.persist.DerbyDatabase;

public class QueryTests 
{
	public DerbyDatabase db;
	
	
	@Before
	public void setUp()
	{
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = (DerbyDatabase) DatabaseProvider.getInstance();
	}
	
	@Test
	public void testfindAdvisorByLogin()
	{
		Advisor newton = db.findAdvisorByLogin("inewton", "abc");
		Advisor scott = db.findAdvisorByLogin("ascott", "xyz");
		Advisor badPassword =db.findAdvisorByLogin("ascott", "123");
		Advisor badUsername = db.findAdvisorByLogin("notausername", "abc");
		
		assertTrue(newton.getLastname().equals("Newton"));
		assertTrue(scott.getLastname().equals("Scott"));
		assertTrue(badPassword==null);
		assertTrue(badUsername==null);
		
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
	public void testfindContentByStudentUsername()
	{
		
	}
	
}