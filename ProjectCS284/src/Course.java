import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
	String[] header ;
	String[][] data2;
	int[] fullSc;
	public Course(String name) {
		for (int i = 0; i < getSizeArray(); i++) {
			System.out.println(i);
		}
		data = null ;
		header =null;
		JTable table;
		try {
		 data2 = ScoreForm.data;
		header = ScoreForm.nameForm;
		fullSc = ScoreForm.fullScore;
		String[] a = new String[fullSc.length];
		System.out.println(header.length+" "+fullSc.length);
		for (int i = 0; i < fullSc.length; i++) {
			header[i+1] = fullSc[i]+"@"+header[i+1];
		}
	
		table = new JTable(data2, header);
		}catch (NullPointerException e) {
			data = getSubject(name).getData();
			//System.out.println("AA");
			int a=0;
			System.out.println(data[0][0]);
			StringTokenizer st = new StringTokenizer(data[0][0], " ");
			while(st.hasMoreTokens()) {
				st.nextToken();
				a++;
			}
			
			System.out.println(a);
			data2 = new String[data.length][a];
		
			header = new String[a];
			if(data[0][0].split(" ")[0].equals("IDStudent")) {
				//int b =0;
				String[] da = data[0][0].split(" ");
				System.out.println(da.length);
				for (int j = 0; j < da.length; j++) {
					header[j] = da[j];
				}
		
		
			}
			int b = 0;
			for (int i = 1; i < data2.length; i++) {
				String[] da1 = data[i][0].split(" ");
				for (int j = 0; j < a; j++) {
					data2[i-1][j] = da1[j];
				}
			}
			
			header[0] = "IDStudent";
			table = new JTable(data2, header);
			
		}
	

		JScrollPane scrollPane = new JScrollPane(table);
		JPanel pa = new JPanel();
		scrollPane.setPreferredSize(new Dimension(600, 400));
		pa.setLayout(new FlowLayout());
		pa.add(scrollPane);
		add(pa);
		// getContentPane().setBounds(300, 300, 100, 100);
		JPanel p1= new JPanel();
		JButton ok = new JButton("Save");
		JButton cancel = new JButton("Back");
		p1.add(ok);
		p1.add(cancel);
		add(p1,BorderLayout.SOUTH);
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ans="";
				System.out.println(data2[0][0]);
				for (int i = 0; i < data2.length-1; i++) {
					for (int j = 0; j < data2[0].length; j++) {
						//System.out.println(data[i][j]);
						ans += data2[i][j]+" ";
					}
					ans += "\n";
				}
				//System.out.println(ans);
				String head ="";
				
				for (int i = 0; i < header.length; i++) {
					head+= header[i]+" ";
				}
				head+="\n";
				FileWriter fileW;
				try {
					File f =getSubject(name).getFile();
					fileW = new FileWriter(f);
					fileW.write(head);
					fileW.write(ans);
					fileW.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
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
		
		this.setTitle("Log In");
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Course("CS211");
	}
}
