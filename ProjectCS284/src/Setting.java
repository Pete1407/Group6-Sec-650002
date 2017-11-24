import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Setting extends AllSubject{
	public Setting(String name) {
		//String[][] data = getSubject(name).getData();
	 	//System.out.println(getSubject(name).getData()[0].length);
	 	
		JComboBox<String> box = new JComboBox<>();
		box.addItem("Grade Criterion");
		box.addItem("Score from");
		add(box,BorderLayout.NORTH);
		
		JPanel pa = new JPanel();
		pa.setPreferredSize(new Dimension(200, 200));
		JButton btn1 = new JButton("OK");
		pa.add(btn1);
		JButton btn2 = new JButton("Back");
		pa.add(btn2);
		add(pa);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(box.getSelectedItem().equals("Grade Criterion")) {
					new GradeFrame(name,"","","","","","","",true);
				}else {
					new ScoreForm(name);
				}
				dispose();
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LogInFrame();
				dispose();
				
			}
		});
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Setting("CS211");
	}
	
}
