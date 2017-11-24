import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FindEmailTest {

	@Test
	public void test() {
		FindEmail e = new FindEmail();
		try {
			assertNotNull("pete.pittawas@gmail.com", e.findemail("5909650664"));
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	@Test
	public void checkEmailNull(){
		FindEmail e = new FindEmail();
	    String a;
		try {
			a = e.findemail("5909650999");
			assertNotEquals("Not Found Email", a);
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
	    
	}
	
	@Test
	public void checkFile(){
		FindEmail e = new FindEmail();
		try {
			e.findemail("5909650664");
		} catch (FileNotFoundException e1) {
			try {
				assertNull("File Not Found",e.findemail("5909650664"));
			} catch (FileNotFoundException e2) {
				System.out.println(e2.getMessage());
			};
		}
	}
	
	
	
	

}
