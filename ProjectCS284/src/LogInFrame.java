import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LogInFrame extends AllSubject {
	private JTextField userinput;
	private JLabel user1, password, subjectbox;
	private JPasswordField passwordinput;
	private JComboBox box;
	private JButton ok, cancel;
	private ArrayList<String> user, pass, sub;
	private JRadioButton set;
	private Scanner sn;

	public LogInFrame() {
		System.out.println("HelloWorld");
		System.out.println("EiEI");

		user = new ArrayList<>();
		pass = new ArrayList<>();
		sub = new ArrayList<>();
		try {
			sn = new Scanner(new File("UserPass.txt"));

			while (sn.hasNextLine()) {

				StringTokenizer st = new StringTokenizer(sn.nextLine(), " ");
				user.add(st.nextToken());
				pass.add(st.nextToken());
				sub.add(st.nextToken());

			}

		} catch (FileNotFoundException e) {

		}

		this.setLayout(new BorderLayout());
		JPanel a = new JPanel();
		JPanel b = new JPanel();
		JPanel c = new JPanel();
		JPanel p1 = new JPanel();

		JPanel button = new JPanel();

		user1 = new JLabel("Username:");
		userinput = new JTextField(20);
		password = new JLabel("Password:");
		passwordinput = new JPasswordField(20);
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		subjectbox = new JLabel("Subject:");
		String[] all = getAllName();
		for (int j = 0; j < all.length; j++) {
			
			//System.out.println(all[j]);
		}

		//String su[] = { "CS101", "CS102", "CS211", "CS223", "CS213", "CS284" };

		box = new JComboBox<>(all);

		set = new JRadioButton("Settings");

		JLabel massage = new JLabel("", SwingConstants.CENTER);

		a.add(user1);
		a.add(userinput);
		b.add(password);
		b.add(passwordinput);
		c.add(subjectbox);
		c.add(box);
		c.add(set);
		button.add(ok);
		button.add(cancel);
		p1.setLayout(new GridLayout(5, 1));
		p1.add(a);
		p1.add(b);
		p1.add(c);
		p1.add(button);
		p1.add(massage);
		this.add(p1, BorderLayout.NORTH);

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < user.size(); i++) {
					if (userinput.getText().equals(user.get(i)) && passwordinput.getText().equals(pass.get(i))
							&& (box.getSelectedItem().equals(sub.get(i)) || sub.get(i).equals("ALL"))) {
						if (set.isSelected()) {
							System.out.println("Settings");
							new Setting((String)box.getSelectedItem());
							dispose();
						} else {
							System.out.println("Course");
							new Course((String)box.getSelectedItem());
							dispose();
						}

					}else if(userinput.getText().equals("admin") && passwordinput.getText().equals("admin")){
						new Admin();
						dispose();
						break;
					}
				}

				massage.setText("Wrong Username or password. Try again.");
				massage.setForeground(Color.RED);
				passwordinput.setText("");

			}

		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);

			}
		});

		this.setTitle("Log In");
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new LogInFrame();
	}
}
