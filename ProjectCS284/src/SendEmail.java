import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public SendEmail(String id , String ma , String name){
		
		
		
		String mail="";
		File file = new File("classlist60.txt");
		try {
			String[] maa=null;
			boolean boo = true;
			Scanner sn = new Scanner(file);
			
			while(sn.hasNextLine()) {
				maa =  sn.nextLine().split(" ");
				
				if(id.equals(maa[0])) {
					mail = maa[1];
					boo = false;
				
					break;
				}
			}		
			
			
			
			if(boo) {
				//label.setText("Not Found Email!");
			}else {
				
				
			}
			
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		
		
		//mail = "pete.pittawas@gmail.com";
		
			final String username = "ilovecs284@gmail.com";
	        final String password = "send1234";

	        Properties props = new Properties();
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");

	        Session session = Session.getInstance(props,
	          new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	          });

	        try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("supanatbond@gmail.com"));
				message.setSubject(id+" : Scores & Grade of course "+name);
				message.setText(ma);

				Transport.send(message);

				System.out.println("Done");
				
	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
	}

}
