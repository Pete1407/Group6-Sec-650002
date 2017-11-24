import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class GradeFrame extends AllSubject {

	private JLabel title, alabel, bpluslabel, blabel, cpluslabel, clabel, dpluslabel, dlabel;

	private JTextField aa, bbplus, bb, ccplus, cc, ddplus, dd;
	private JButton ok, cancel;

	public GradeFrame(String name) {
		this.setLayout(new BorderLayout());
		JPanel havana = new JPanel();
		havana.setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		JPanel p8 = new JPanel();
		JPanel p9 = new JPanel();
		JPanel a = new JPanel();
		JPanel blue = new JPanel();

		blue.setLayout(new GridLayout(4, 2));
		title = new JLabel("Grade Criterion");
		title.setFont(new Font("TimesRoman", Font.BOLD, 15));

		alabel = new JLabel(" A  :");
		bpluslabel = new JLabel("B+ :");
		blabel = new JLabel(" B  :");
		cpluslabel = new JLabel("C+ :");
		clabel = new JLabel(" C  :");
		dpluslabel = new JLabel("D+ :");
		dlabel = new JLabel(" D  :");

		aa = new JTextField(7);
		bbplus = new JTextField(7);
		bb = new JTextField(7);
		ccplus = new JTextField(7);
		cc = new JTextField(7);
		ddplus = new JTextField(7);
		dd = new JTextField(7);

		ok = new JButton("OK");
		cancel = new JButton("Back");
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Setting(name);
				dispose();
			}
		});

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int a = Integer.valueOf(aa.getText());
					int bplus = Integer.valueOf(bbplus.getText());
					int b = Integer.valueOf(bb.getText());
					int cplus = Integer.valueOf(ccplus.getText());
					int c = Integer.valueOf(cc.getText());
					int dplus = Integer.valueOf(ddplus.getText());
					int d = Integer.valueOf(dd.getText());

					if (a < bplus || bplus < b || b < cplus || cplus < c || c < dplus || dplus < d) {
						JOptionPane.showMessageDialog(null, "Input Error!!");

					} else {
						String message = "Grade Criterion\n";
						message += "A : 100 - " + a + "\n";
						message += "B+: " + (a - 1) + " - " + bplus + "\n";
						message += "B : " + (bplus - 1) + " - " + b + "\n";
						message += "C+: " + (b - 1) + " - " + cplus + "\n";
						message += "C : " + (cplus - 1) + " - " + c + "\n";
						message += "D+: " + (c - 1) + " - " + dplus + "\n";
						message += "D : " + (dplus - 1) + " - " + d + "\n";
						message += "F : " + (d - 1) + " - 0\n";

						JOptionPane.showMessageDialog(null, message);

						Scanner sn = new Scanner(getSubject(name).getFile());
						
						String pa = aa.getText() + " " + bbplus.getText() + " " + bb.getText() + " " + ccplus.getText()
								+ " " + cc.getText() + " " + ddplus.getText() + " " + dd.getText() + "\n";
					
						
						String as = sn.nextLine();
						String as2;
						if(as.split(" ")[0].equals("IDStudent")) {
							pa += as+ "\n";
							while (sn.hasNextLine()) {
								as = sn.nextLine();
								pa += as+ "\n";	
								}
						} 
						
						else if((as2 = sn.nextLine()).split(" ")[0].equals("IDStudent")) {
							pa += as2+ "\n";
							while (sn.hasNextLine()) {
								as = sn.nextLine();
									pa += as+ "\n";	
								}
						}
						
						else {
							JOptionPane.showMessageDialog(null, "Input ScoreFrom,please");
							new ScoreForm(name);
							dispose();
						}
						
							
						System.out.println(pa);
						try {
							FileWriter fw = new FileWriter(getSubject(name).getFile(),false);
							fw.write(pa);
							fw.close();
							
							dispose();
							System.exit(0);
						
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						}
						

					
			
				} catch (FileNotFoundException | NumberFormatException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
				}

			}
		});

	p9.add(ok);p9.add(cancel);

	p1.add(title);

	p2.add(alabel);p2.add(aa);p3.add(bpluslabel);p3.add(bbplus);p4.add(blabel);p4.add(bb);p5.add(cpluslabel);p5.add(ccplus);p6.add(clabel);p6.add(cc);p7.add(dpluslabel);p7.add(ddplus);p8.add(dlabel);p8.add(dd);

	blue.add(p2);blue.add(p3);blue.add(p4);blue.add(p5);blue.add(p6);blue.add(p7);blue.add(p8);

	this.add(p1,BorderLayout.NORTH);this.add(blue,BorderLayout.CENTER);this.add(p9,BorderLayout.SOUTH);

	this.setTitle("Grade");this.setSize(300,300);this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);this.setVisible(true);

	}

	public static void main(String[] args) {
		new GradeFrame("CS211");
	}
}
