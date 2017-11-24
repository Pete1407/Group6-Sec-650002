import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FindEmail {
	private ArrayList<String> liststudent = new ArrayList<>();
	private ArrayList<String> idlist = new ArrayList<>(); 
	private ArrayList<String> emaillist = new ArrayList<>();
	
          public String findemail(String n)throws FileNotFoundException{
        	 
        	  try (BufferedReader read = new BufferedReader(new FileReader("emailstudent.txt"));)
        	  {
			       String a = read.readLine();
			       while(a!=null)
			       {
			    	   
			    	  liststudent.add(a);
			    	  String l = a.split(" ")[1];
			    	  String j = a.split(" ")[0];
			    	  idlist.add(j);
			    	  emaillist.add(l);
			    	  a = read.readLine();
			    	   
			       }
			       
			        for(int count=0;count<emaillist.size();count++)
			        {
			    	   if(idlist.get(count).equals(n))
			    	   {
			    		  System.out.println(emaillist.get(count));
			    		  return emaillist.get(count);
			    	   }
			    	   
			        }
			       
			  } 
        	  catch (FileNotFoundException e) 
        	  {
				System.out.println(e.getMessage());
			  } 
        	  catch (IOException e1) 
        	  {
				System.out.println(e1.getMessage());
			  }
        	 
			return null;
			
			
          }
          
          public static void main(String[] args) {
			FindEmail e = new FindEmail();
			Scanner scan = new Scanner(System.in);
			System.out.printf("Please input id to find email:");
			String n = scan.nextLine();
			try {
				e.findemail(n);
			} catch (FileNotFoundException e1) {
				System.out.println(e1.getMessage());
			}
		}
}
