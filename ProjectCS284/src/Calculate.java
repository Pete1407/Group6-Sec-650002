import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Calculate {
	private ArrayList<String> list;
	private String cr = "";
	private String title = "";

	private String b;
	private ArrayList<String> katy;
	private ArrayList<String> score;
	private int count = 1;
	
	
	public Calculate(File f) {
		try {
			Scanner sn = new Scanner(f);
			ArrayList<String> line = new ArrayList<>();
			while(sn.hasNextLine()) {
				line.add(sn.nextLine());
			}
			
			System.out.println(line.get(0));
			String[] gradeStr = line.get(0).split(" ");
			int[] grade = new int[gradeStr.length];
			
			for (int i = 0; i < gradeStr.length; i++) {
				grade[i] = Integer.valueOf(gradeStr[i]);
				System.out.println(gradeStr[i]);
			}
			
			String[] head = line.get(1).split(" ");
			ArrayList<String> head2 = new ArrayList<>();
			
			//System.out.println(head[3]);
			head2.add(head[1].split("@")[0]);
			
			int sumFull = 0;
			for (int i = 1; i < head.length; i++) {
				head2.add(head[i].split("@")[0]);
				System.out.println(head2.get(i));
				sumFull += Integer.valueOf(head2.get(i));
			}
			System.out.println(sumFull);
			
			File file = new File("Student4_point.txt");
			String sumStr = "\n\nNet score & Grade\n";
			int sum = 0;
			for (int i = 2; i < line.size(); i++) {
				//System.out.println(line.get(i));
				String[] sp = line.get(i).split(" ");
				for (int j = 0; j < sp.length; j++) {
					if(j==0) {
						sumStr += sp[0]+" ";
					}else {
						sum += Integer.valueOf(sp[j]);
					}
				}
				
				
				
				sum = (int) (((double)sum/sumFull)*100);
				String g="";
				if(sum >= grade[0]) {
					g = "A";
				}
				else if(sum >= grade[1]) {
					g = "B+";
				}
				else if(sum >= grade[2]) {
					g = "B";
				}
				else if(sum >= grade[3]) {
					g = "C+";
				}
				else if(sum >= grade[4]) {
					g = "C";
				}
				else if(sum >= grade[5]) {
					g = "D+";
				}
				else if(sum >= grade[6]) {
					g = "D";
				}
				else {
					g = "F";
				}
				
				
				
				
				
				
				sumStr += sum+" "+g+"\n";
				
				sum = 0;
			}
			System.out.println(sumStr);
			try {
				FileWriter fw = new FileWriter(f,true);
				fw.write(sumStr);
				fw.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

	public void ReadFile(String name, int input) {
		list = new ArrayList<>();
		katy = new ArrayList<>();
		score = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(name));) {
			String sentence = reader.readLine();
			while (sentence != null) {
				list.add(sentence);

				if (sentence.startsWith("5909650")) {
					count++;
					String a = sentence.split(" ")[0].trim(); // ���Ţ����¹�ѡ�֡��
					b = sentence.split(" ")[1].trim(); // �Դ�ç�����纤�ṹẺ dynamic
					katy.add(a);
					score.add(b);

				}

				sentence = reader.readLine();
			}
			for (int count = 0; count < katy.size() - 1; count++) {
				System.out.println(katy.get(count));
				System.out.println(b);
			}

			cr = list.get(0).trim();
			title = list.get(1).trim();
			System.out.println(cr); // Grade criterion
			System.out.println(title); // name of type testing

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}

	}

	public void WriteFile() {
		try (PrintWriter writer = new PrintWriter(new FileWriter("ReportScore.txt"));) {

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		new Calculate(new File("student4.txt"));
		

	}
}
