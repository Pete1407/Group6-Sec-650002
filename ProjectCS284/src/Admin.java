import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Admin extends AllSubject{
	JLabel l1,l2,l3 ;
	JButton btn,save,login;
	JTextField textSub , textUser , textPass;
	String[][] data = null;
	File s;
	public Admin() {
		l1 = new JLabel("Subject");
		l2 = new JLabel("User");
		l3 = new JLabel("password");
		btn = new JButton("Upload File Student");
		save = new JButton("Save");
		login = new JButton("Back");
		
		textSub = new JTextField(10);
		textUser = new JTextField(10);
		textPass = new JTextField(10);
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel panel = new JPanel(new GridLayout(5, 1));
		
		p1.add(l1);
		p1.add(textSub);
		p2.add(l2);
		p2.add(textUser);
		p3.add(l3);
		p3.add(textPass);
		p4.add(btn);
		p5.add(save);
		p5.add(login);
		panel.add(p1);
		panel.add(p2);
		panel.add(p3);
		panel.add(p4);
		panel.add(p5);
		add(panel,BorderLayout.NORTH);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser("./");
				file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int m = file.showOpenDialog(null);
				
				if(m==JFileChooser.APPROVE_OPTION){
					s = file.getSelectedFile();
					try {
						
						Scanner sn = new Scanner(s);
						int i=0;
						while (sn.hasNextLine()) {
							i++;
							sn.nextLine();
						}
						data = new String[i][2];
						Scanner sn2 = new Scanner(s);
						for (int j = 0; j < i; j++) {
							
							data[j][0] = sn2.nextLine();
							
							//System.out.println(data[j][0]);
						}
		
					} catch (IOException e1) {
						data = null;
					}
				}
				
			}
		});
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				if(!textSub.getText().equals("") || !textUser.getText().equals("") || !textPass.getText().equals("") ) {
					for (int i = 0; i < getSizeArray(); i++) {
						if(textSub.getText().equals(getSubject(i).getName())) {
							getSubject(i).setUser(textUser.getText());
							getSubject(i).setPassword(textPass.getText());
							//System.out.println("AAA");
						}
					}
					
					try {
						addSubject(textSub.getText(), data, textUser.getText(), textPass.getText(),s.getName() );
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LogInFrame();
				dispose();
				
			}
		});
		
		setTitle("Admin");
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Admin();
	}
}
