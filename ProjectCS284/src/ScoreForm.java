import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ScoreForm extends AllSubject {

	private JTextField[] field;
	private JTextField[] nametest;
	private JTextField[] totalscore;
	private JLabel name2;
	private JLabel score;
	private JLabel totalscores;
	private JButton ok;
	private JButton cancel;
	JLabel le ;
	public static String[][] data;
	public static String [] nameForm;
	public static int[] fullScore ;
	public ScoreForm(String name) {
		JPanel oop1 = new JPanel();
		JPanel oop2 = new JPanel();
		JPanel oop3 = new JPanel();

		JPanel button = new JPanel();
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		JPanel p2 = new JPanel();

		JPanel areainputname = new JPanel(); // name
		
		JPanel areainputtotalscore = new JPanel(); // totalscore
		JPanel mainarea = new JPanel();
		mainarea.setLayout(new BorderLayout());

		ok = new JButton("OK");
		ok.setFont(new Font("TimesRoman", Font.BOLD, 14));
		ok.setPreferredSize(new Dimension(80, 30));
		ok.setActionCommand("ok");
		
		cancel = new JButton("back");
		cancel.setFont(new Font("TimesRoman", Font.BOLD, 14));
		cancel.setPreferredSize(new Dimension(90, 30));
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Setting(name);
				dispose();
				
				
			}
		});
		button.add(ok);
		button.add(cancel);

		String s = JOptionPane.showInputDialog(null, "Input number of score:");
		int a = Integer.parseInt(s);

		areainputname.setLayout(new GridLayout(0, 1));
		
		areainputtotalscore.setLayout(new GridLayout(0, 1));

		JPanel namee = new JPanel();
		namee.setLayout(new BorderLayout());
		name2 = new JLabel("Test Name:");
		name2.setFont(new Font("TimesRoman", Font.BOLD, 14));
		namee.add(name2);

		areainputname.add(namee);

		JPanel tscore = new JPanel();
		tscore.setLayout(new BorderLayout());
		totalscores = new JLabel(" Full Score:");
		totalscores.setFont(new Font("TimesRoman", Font.BOLD, 14));
		tscore.add(totalscores);
		areainputtotalscore.add(tscore);

		nametest = new JTextField[a];
		totalscore = new JTextField[a];
		for (int count = 0; count < a; count++) {
			nametest[count] = new JTextField(7);
			totalscore[count] = new JTextField(7);
			areainputname.add(nametest[count]);
			areainputtotalscore.add(totalscore[count]);
		}
		nameForm = new String[a+1];
		nameForm[0] = "IDStudent";
		fullScore = new int[a];
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println(getSubject(name).getData()[0][0].split(" ")[0]+"AAAAAAA" );
				if(getSubject(name).getData()[0][0].split(" ")[0].equals("IDStudent")) {
					System.out.println("Uploaded");
					le.setText("Uploaded!!!!!");
					le.setForeground(Color.RED);
				}
				else {
				try {
					for (int i = 1; i < a+1; i++) {
						nameForm[i] = nametest[i-1].getText();
						fullScore[i-1] = Integer.parseInt(totalscore[i-1].getText());
						//System.out.println(nameForm[i]+" "+fullScore[i]);
					}
					
					getSubject(name).setNameForm(nameForm);
					getSubject(name).setPointForm(fullScore);
					for (int j = 0; j < getSubject(name).getNameForm().length; j++) {
						System.out.println(getSubject(name).getNameForm()[j]);
					}
					data = new String[getSubject(name).getData().length][getSubject(name).getData()[0].length+a-1];
					for (int i = 1; i < data.length; i++) {
						for (int j = 0; j < data[0].length; j++) {
							if(j==0)
								data[i-1][0] = getSubject(name).getData()[i][0].split(" ")[0];
							else {
								data[i-1][j] = "-";
							}
							
						}
					}
					
					getSubject(name).setData(data);
					System.out.println(getSubject(name).getData()[0].length+" "+name);
					
					new Course(name);
					dispose();
				}catch (NumberFormatException e2) {
					le.setText("Input Wrong!!!");
					le.setForeground(Color.RED);
					for (int i = 0; i < a; i++) {
						nametest[i].setText("");
						totalscore[i].setText("");
						
					}
				}
			}
			}
		});

		p2.add(areainputname);
		
		p2.add(areainputtotalscore);
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());

		main.add(p2,BorderLayout.NORTH);
		main.add(button,BorderLayout.SOUTH);
		 le  = new JLabel(" ",SwingConstants.CENTER);
		
		main.add(le);

		this.add(main,BorderLayout.NORTH);
		this.setTitle("ScoreForm");
		this.pack();
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public String[][] getData() {
		return data;
	}
	
	public static void main(String[] args) {
		ScoreForm c = new ScoreForm("CS211");
	}
}
