import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class GradeFrame extends JFrame{
	
	private JLabel title;
	private JLabel alabel;
	private JLabel bpluslabel;
	private JLabel blabel;
	private JLabel cpluslabel;
	private JLabel clabel;
	private JLabel dpluslabel;
	private JLabel dlabel;
	
	private JTextField aa;
	private JTextField bbplus;
	private JTextField bb;
	private JTextField ccplus;
	private JTextField cc;
	private JTextField ddplus;
	private JTextField dd;
	private JButton ok;
	private JButton cancel;
         public GradeFrame(){
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
        	 
        	 blue.setLayout(new GridLayout(4,2));
        	 title = new JLabel("Grade Criterion");
        	 title.setFont(new Font("TimesRoman",Font.BOLD,15));
             
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
        	 cancel = new JButton("Cancel");
        	 p9.add(ok);
        	 p9.add(cancel);
        	 
        	 p1.add(title);
        	 
        	 p2.add(alabel);
        	 p2.add(aa);
        	 p3.add(bpluslabel);
        	 p3.add(bbplus);
        	 p4.add(blabel);
        	 p4.add(bb);
        	 p5.add(cpluslabel);
        	 p5.add(ccplus);
        	 p6.add(clabel);
        	 p6.add(cc);
        	 p7.add(dpluslabel);
        	 p7.add(ddplus);
        	 p8.add(dlabel);
        	 p8.add(dd);
        	 
        	 blue.add(p2);
        	 blue.add(p3);
        	 blue.add(p4);
        	 blue.add(p5);
        	 blue.add(p6);
        	 blue.add(p7);
        	 blue.add(p8);
        	 
        	 
        	 
        	 
        	 this.add(p1,BorderLayout.NORTH);
        	 this.add(blue,BorderLayout.CENTER);
        	 this.add(p9,BorderLayout.SOUTH);
        	 
        	 this.setTitle("Grade");
        	 this.setSize(300, 300);
        	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	 this.setVisible(true);
         }
         
         public static void main(String[] args) {
			GradeFrame f = new GradeFrame();
		}
}
