import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Testcase {

	LogInFrame lf;
	@Before
    public void setUp(){
    	lf=new LogInFrame();
    }
	@After
	public void tearDown() {
		lf=null;
	
	}
	@Test
	public void testString(){
		assertNull( "Password or username wrong",lf.data);
		
		
	}
}
