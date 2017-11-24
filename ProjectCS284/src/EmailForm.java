import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class EmailForm extends JFrame{
	JLabel label;
	JTextArea a;
	JTextField text2;
	public EmailForm(String name){
		label = new JLabel("   ",SwingConstants.CENTER);
		JPanel p=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		JPanel p5=new JPanel();
		JPanel p6=new JPanel();
		JPanel p7=new JPanel();
		JLabel number=new JLabel("Student's ID Number");
		JLabel sub=new JLabel("Subject");
		JTextField text=new JTextField(10);
		text2=new JTextField(17);
		text2.setEditable(false);
		p5.add(p6);
		p5.add(p7);
		p6.add(number);
		p6.add(text);
		p7.add(sub);
		p7.add(text2);
		p5.add(label);
		
		text.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					File file = new File("classlist60.txt");
					try {
						String[] ma=null;
						boolean boo = true;
						Scanner sn = new Scanner(file);
						
						while(sn.hasNextLine()) {
							ma =  sn.nextLine().split(" ");
							
							if(text.getText().equals(ma[0])) {
								label.setText(ma[1]);
								boo = false;
								text2.setEditable(true);
								a.setEditable(true);
								break;
							}
						}		
						
						
						
						if(boo) {
							label.setText("Not Found Email!");
						}else {
							String[][] data = Course.data2;
							for (int i = 0; i < data.length; i++) {
								//System.out.println(ma[0]);
								if(data[i][0].equals(ma[0])) {
									a.setText("ID Student : "+data[i][0]+"\nNet Score : "+data[i][1]+"\nGrade : "+data[i][2]);
									break;
								}
							}
						}
						
					} catch (FileNotFoundException e1) {
						
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		
		
		a =new JTextArea(10,40);
		JScrollPane sp = new JScrollPane(a);
		p2.setBorder(new TitledBorder("Massage"));
		p2.add(sp);
		a.setEditable(false);
		JButton send=new JButton("Send");
		JButton cancel=new JButton("Back");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Course(name);
				dispose();
			}
		});
		p3.add(send);
		p3.add(cancel);
		p5.setLayout(new GridLayout(0,1));
		this.setBounds(128, 72, 99, 23);
		this.add(p3,BorderLayout.SOUTH);
		this.add(p5,BorderLayout.NORTH);
		this.add(p2,BorderLayout.CENTER);
		
		send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
							 message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(label.getText()));
							 message.setSubject(text2.getText());
							 message.setText(a.getText());

							 Transport.send(message);

							 System.out.println("Done");
					
		        } catch (MessagingException e2) {
		            throw new RuntimeException(e2);
		        }
				
			}
		});
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
	}
	public static void main(String[] args) {
		new Course("CS211");
	}
}