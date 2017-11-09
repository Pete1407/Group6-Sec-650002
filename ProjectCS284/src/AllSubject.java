import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JFrame;

public class AllSubject extends JFrame{
	ArrayList<Subject> arrSub ;
	String[][] data ;
	public AllSubject() {
		arrSub = new ArrayList<>();
		//arrSub.add(new Subject("CS211", data));
		File file = new File("UserPass.txt");
		Scanner sn;
		try {
			sn = new  Scanner(file);
			while(sn.hasNextLine()) {
				String[] line = sn.nextLine().split(" ");
				System.out.println(line[3]);
				String[][] data;
					Scanner sn1 = new Scanner(new File(line[3]));
					int i=0;
					while (sn1.hasNextLine()) {
						i++;
						sn1.nextLine();
						
					}
					data = new String[i][2];
					Scanner sn2 = new Scanner(new File(line[3]));
					
					for (int j = 0; j < i; j++) {
						
								data[j][0] = sn2.nextLine();
						
					//	System.out.println(data[j][0]);
					}
					arrSub.add(new Subject(line[2], data, line[0], line[1],new File(line[3])));
			}
		} catch (FileNotFoundException e) {
			
			
		}
			
	
	}

	public void addSubject(String name,String[][] data,String user,String password,String file) throws IOException{
		String up="";
		File userp = new File("UserPass.txt");
		Scanner sn = new Scanner(userp);
		while(sn.hasNextLine()) {
			up += sn.nextLine()+"\n";
		}
		
		arrSub.add(new Subject(name, data,user,password,new File(file)));
		up += user+" "+password+" "+name+" "+file+"\n";
		
		FileWriter fileW = new FileWriter(userp);
		fileW.write("");
		fileW.close();
		
		FileWriter fileWa = new FileWriter(userp);
		fileWa.write(up);
		fileWa.close();
	}
	
	public Subject getSubject(int index) {
		return arrSub.get(index);
	}
	
	public Subject getSubject(String name) {
		System.out.println(getIndex(name));
		return arrSub.get(getIndex(name));
	}
	
	
	
	public String[] getAllName(){
		ArrayList<String> n = new ArrayList<>();
		
		for (int i = 0; i < arrSub.size(); i++) {
			n.add(arrSub.get(i).getName());
		}
		Collections.sort(n);
		for (int i = 0; i < n.size(); i++) {
			for (int j = 0; j < n.size(); j++) {
				if(i==j) {
					
				}else if(n.get(i).equals(n.get(j)) || n.get(i).equals("ALL")) {
					System.out.println(n.get(i));
					n.remove(i);
				}
			}
		}
		String[] allName = new String[n.size()];
		for (int i = 0; i < n.size(); i++) {
			allName[i] = n.get(i);
		}
		return allName;
	}
	
	public void setNameData(String[][] data) {
		this.data = data;
		
	}
	
	public String[][] getCourseData() {
		return data;
	}
	
	public String[][] getIndexData(String name){
		for (int i = 0; i < arrSub.size(); i++) {
			if(arrSub.get(i).getName().equals(name)){
				return arrSub.get(i).getData();
			}
		}
		return null;
	}

	public int getIndex(String name){
		for (int i = 0; i < arrSub.size(); i++) {
			if(name.equals(arrSub.get(i).getName())){
				return i;
			}
		}
		return -1;
	}
	public int getSizeArray() {
		return arrSub.size();
	}
	
	
	public void setForm(String[] nameForm,int[] pointForm,int index){
		arrSub.get(index).setNameForm(nameForm);
		arrSub.get(index).setPointForm(pointForm);
	}
	
	public void setGrade(int[] grade,int index){
		arrSub.get(index).setGrade(grade);
	}

}
