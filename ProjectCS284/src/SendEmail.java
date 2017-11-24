import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public static void main(String[] args) {
		//for (int i = 0; i < 10; i++) {
			
		
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
						 message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("korpongparunyakul@gmail.com"));
						 message.setSubject("สัส");
						 message.setText("ออม แอน จอย");

						 Transport.send(message);

						 System.out.println("Done");
				
	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
	}

}
