import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Course extends AllSubject {
	String[] header;
	static String[][] data2;
	int[] fullSc;
	String grade;
	JButton ok,cancel,submit;
	JTable table;
	public Course(String name) {
		ok = new JButton("Save");
		cancel = new JButton("Back");
		submit = new JButton("Submit");
		for (int i = 0; i < getSizeArray(); i++) {
			System.out.println(i);
		}
		data = null;
		header = null;
		
		try {
			data2 = ScoreForm.data;
			header = ScoreForm.nameForm;
			fullSc = ScoreForm.fullScore;
			String[] a = new String[fullSc.length];
			System.out.println(header.length + " " + fullSc.length);
			for (int i = 0; i < fullSc.length; i++) {
				header[i + 1] = fullSc[i] + "@" + header[i + 1];
			}

			table = new JTable(data2, header);
		} catch (NullPointerException e) {
			data = getSubject(name).getData();
			// System.out.println("AA");
			int a = 0;
			System.out.println(data[0][0]);
			StringTokenizer st = new StringTokenizer(data[1][0], " ");
			while (st.hasMoreTokens()) {
				st.nextToken();
				a++;
			}

			data2 = new String[data.length][a];
			int b = 1;
			header = new String[a];
			boolean check = false;
			if (data[0][0].split(" ")[0].equals("IDStudent") || a == 1) {
				grade = "aaa";
				b = 1;
				String[] da = data[0][0].split(" ");
				// System.out.println(da.length);
				for (int j = 0; j < da.length; j++) {
					header[j] = da[j];
				}
				//System.out.println(data2.length + "BBBB");
				for (int i = 1; i < data2.length; i++) {

					String[] da1 = data[i][0].split(" ");

					for (int j = 0; j < a; j++) {
						// System.out.println(da1[j]);
						data2[i - 1][j] = da1[j];
					}
				}

			} else if (data[1][0].split(" ")[0].equals("IDStudent")) {
				
				//System.out.println("AAAAAAA");
				grade = data[0][0] + "\n";
				// System.out.println(data[0][0]);

				b = 1;
				String[] da = data[1][0].split(" ");
				System.out.println(da.length);
				for (int j = 0; j < da.length; j++) {
					header[j] = da[j];
				}
				System.out.println(data2.length + " " + a);
				
				try {
				for (int i = 2; i < data2.length; i++) {
					String[] da1 = data[i][0].split(" ");
					for (int j = 0; j < a; j++) {
						data2[i - 2][j] = da1[j];

					}
				}
				
				}catch (ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(null, "sent grade.");
					check = true;
					ok.setEnabled(false);
					submit.setText("Email");
					//cancel.setEnabled(false);
					
					
					int i=0;
					//System.out.println(data.length+"ADECBY");
					while(true){
						if(data[i][0].equals("Net score & Grade")){	
							break;
						}
						i++;
					}
					
					data2 = new String[data.length-i+1][3];
					for (int j = i+1; j < data.length; j++) {
						for (int j2 = 0; j2 < 3; j2++) {
						
							data2[j-(i+1)][j2] = data[j][0].split(" ")[j2];
						}
					}

					header = new String[3];
					header[1] = "Net Score";
					header[2] = "Grade";
				}
			}
			
			// System.out.println(b);

			header[0] = "IDStudent";
			table = new JTable(data2, header);
			
			if(check) {
				table.setEnabled(false);
			}
			
			

		}

		JScrollPane scrollPane = new JScrollPane(table);
		JPanel pa = new JPanel();
		scrollPane.setPreferredSize(new Dimension(600, 400));
		pa.setLayout(new FlowLayout());
		pa.add(scrollPane);
		add(pa);
		// getContentPane().setBounds(300, 300, 100, 100);
		JPanel p1 = new JPanel();
		
		
		p1.add(ok);
		p1.add(cancel);
		p1.add(submit);
		add(p1, BorderLayout.SOUTH);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Save")){
				String ans = "";
				System.out.println(data2[0][0]);
				for (int i = 0; i < data2.length - 1; i++) {
					for (int j = 0; j < data2[0].length; j++) {
						// System.out.println(data[i][j]);
						if(data2[i][j]==null) {
							
						}else
							ans += data2[i][j] + " ";
					}
					
					ans += "\n";
				}
				// System.out.println(ans);
				String head = "";

				for (int i = 0; i < header.length; i++) {
					head += header[i] + " ";
				}
				head += "\n";
				FileWriter fileW;
				try {
					File f = getSubject(name).getFile();
					fileW = new FileWriter(f);

					if (grade.equals("aaa")) {
						fileW.write(head);
						fileW.write(ans);
					} else {
						fileW.write(grade);
						fileW.write(head);
						fileW.write(ans);
					}
					fileW.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
				}
				}else{
					
				}
			}
		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
					new LogInFrame();
					dispose();
			
			}
		});

		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Submit")){
				File file = getSubject(name).getFile();
				try {
					Scanner sn = new Scanner(file);
					int i = 0;
					boolean check = true;
					while (sn.hasNextLine()) {
						// System.out.println(i);
						String line = sn.nextLine();
						if (i > 1) {
							// System.out.println(line);
							String[] sp = line.split(" ");

							for (int j = 1; j < sp.length; j++) {
								//System.out.println(sp[j]);
								if (sp[j].equals("-")) {
									//JOptionPane.showMessageDialog(null, "Input All Score");
								//	System.out.println("AAASSS");
									check = false;
									break;
									
								}
							}
							if(check == false) {
								JOptionPane.showMessageDialog(null, "Input All Score");
								break;
								
							}
							

						}
						i++;
					}
					
					if (check) {
						new Calculate(file);
						dispose();
					}
				

				} catch (FileNotFoundException | NumberFormatException e1) {
				
					
				}
				}else{
					new EmailForm(name);
					dispose();
					//System.exit(0);
				}
			}
		});
		
		

		this.setTitle("Course");
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Course("CS211");
	}
}
