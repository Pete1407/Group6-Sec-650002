import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test; 

public class Testcase {

	LogInFrame login;
	Admin admin;
	AllSubject all;

	@Before
	public void setUp() {
		login = new LogInFrame();
		admin = new Admin();
		all = new AllSubject();
	}

	@After
	public void tearDown() {
		login = null;

	}

	@Test
	public void notNullLogin() {
		//§≈“ ‰¡Ë‡ªÁπNull
		assertNotNull("Password or username wrong", login);

	}
	
	@Test
	public void admintest(){
		assertNotNull(all.getIndex("CS211"));

	}
	
	@Test
	public void Indextest(){
		assertTrue(all.getIndex("CS211") ==0);
		assertTrue(all.getIndex("CS101") ==1);

	}
	
}
