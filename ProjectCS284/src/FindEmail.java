import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindEmail {
	String mail;
	public String getEmail(String id) {
		File file = new File("classlist60.txt");
		boolean boo = true;
		try {
			String[] maa=null;
			
			Scanner sn = new Scanner(file);
			
			while(sn.hasNextLine()) {
				maa =  sn.nextLine().split(" ");
				
				if(id.equals(maa[0])) {
					mail = maa[1];
					boo = false;
				
					break;
				}
			}		

		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		if(boo)return "Not Found Email";
		
		return mail;
	}
}
