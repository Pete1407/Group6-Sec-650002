import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
		//���������Null
		assertNotNull("Password or username wrong", login);

	}
	
	@Test
	public void admintestNotNull(){
		assertNotNull(all.getIndex("CS211"));

	}
	
	@Test
	public void Indextest(){
		assertTrue(all.getIndex("CS211") ==0);
		assertTrue(all.getIndex("CS101") ==1);

	}
	
	///////////////////////////// Email ///////////////////////////// 
	
	@Test
	public void chackEmailNotNull() {
		FindEmail fe = new FindEmail();
		assertTrue(fe.getEmail("5909650664").equals("pete.pittawas@gmail.com"));
	}
	
	
	@Test
	public void checkEmailNull(){
		FindEmail e = new FindEmail();
	    String a;
		a = e.getEmail("5909650644");
		assertEquals("Not Found Email", a);
	    
	}
	
	///////////////////////////// curveScore ///////////////////////////// 
	@Test
	public void checkcurveScoreNotNull(){
		Course c = new Course("CS213");
		//c.curveScore();
		Scanner sn;
		String[][] da = new String[100][100];
		try {
			sn = new Scanner(new File("student5.txt"));
			int i=0;
			//sn.nextLine();
			//sn.nextLine();
			//while(sn.hasNextLine()) {
				//try {
				String[] a = sn.nextLine().split(" ");
				
				//}catch (Exception e) {
				//	break;
				//}
			//}
				String[] gc = {"91.42" ,"86.95" ,"82.49" ,"78.02", "73.56" ,"69.09" ,"64.63"};
				
				
				assertTrue(a[0].equals(gc[0]));
				assertTrue(a[1].equals(gc[1]));
				assertTrue(a[2].equals(gc[2]));
				assertTrue(a[3].equals(gc[3]));
				assertTrue(a[4].equals(gc[4]));
				assertTrue(a[5].equals(gc[5]));
				assertTrue(a[6].equals(gc[6]));
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//double[] g = c.curveScore(da);
		
		
	    
	}
	
	
	
	
	
}
