import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogInPanel extends JPanel{
	private JTextField userinput;
	private JLabel user,password,subjectbox;
	private JPasswordField passwordinput;
	private JComboBox box;
	private JButton ok,cancel;
	private ArrayList<String> userpass;
	private Scanner sn;
       public LogInPanel(){
    	   userpass = new ArrayList<>();
    	   try {
			sn = new Scanner(new File("UserPass"));
			System.out.println("AA");
			while(sn.hasNextLine()){
				System.out.println(sn.nextLine()+"AA");
			}
			
			
			
		} catch (FileNotFoundException e) {
			
		}
    	   
    	   
    	   this.setLayout(new BorderLayout());
    	   JPanel a = new JPanel();
    	   JPanel b = new JPanel();
    	   JPanel c = new JPanel();
    	   JPanel p1 = new JPanel();
    	  
    	   JPanel button = new JPanel();
    	   
    	   user = new JLabel("Username:");
    	   userinput = new JTextField(20);
    	   password = new JLabel("Password:");
    	   passwordinput = new JPasswordField(20);
    	   ok = new JButton("OK");
    	   cancel = new JButton("Cancel");
    	   subjectbox = new JLabel("Subject:");
    	   
    	   String sub[] = {"CS101","CS102","CS211","CS223","CS213","CS284"};
    	   
    	   box = new JComboBox<>(sub);
 
    	   a.add(user);
    	   a.add(userinput);
    	   b.add(password);
    	   b.add(passwordinput);
    	   c.add(subjectbox);
    	   c.add(box);
    	   button.add(ok);
    	   button.add(cancel);
    	   p1.setLayout(new GridLayout(4, 1));
    	   p1.add(a);
    	   p1.add(b);
    	   p1.add(c);
    	   p1.add(button);
    	   this.add(p1,BorderLayout.NORTH);
    	  // this.add(button,BorderLayout.SOUTH);
       }
}
