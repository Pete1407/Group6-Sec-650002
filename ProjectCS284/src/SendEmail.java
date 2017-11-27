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
	String mail;
	public SendEmail(String id , String ma , String name){
		FindEmail fe = new FindEmail();
			mail= fe.getEmail(id);
			
	
		
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
				//message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(mail)); 
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("pete.pittawas@gmail.com"));
				message.setSubject(id+" : Scores & Grade of course "+name);
				message.setText(ma);

				Transport.send(message);

				System.out.println("Done");
				
	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
	}
	
	
	


}
