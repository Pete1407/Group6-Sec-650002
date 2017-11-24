import java.io.File;
import java.util.ArrayList;

public class Subject {
	private String name;
	String[][] data;
	String[] nameForm;
	int[] pointForm, grade;
	ArrayList<String> user , password;
	File file;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Subject(String name, String[][] data,String user,String password,File file) {
		this.name = name;
		this.data = data;
		this.user = new ArrayList<>();	
		this.user.add(user);
		this.password = new ArrayList<>();
		this.password.add(password);
		this.file =file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[][] getData() {
		//System.out.println(data[0].length+name+"A");
		return data;
	}

	public void setData(String[][] data) {
		//System.out.println(data[0].length+name+"B");
		this.data = data;
	}

	public String[] getNameForm() {
		return nameForm;
	}

	public int[] getPointForm() {
		return pointForm;
	}

	public int[] getGrade() {
		return grade;
	}

	public void setNameForm(String[] nameForm) {
		this.nameForm = nameForm;
	}

	public void setPointForm(int[] pointForm) {
		this.pointForm = pointForm;
	}

	public void setGrade(int[] grade) {
		this.grade = grade;
	}

	public String getUser(int index) {
		return user.get(index);
	}

	public String getPassword(int index) {
		return password.get(index);
	}

	public void setUser(String user) {
		this.user.add(user);
	}

	public void setPassword(String password) {
		this.password.add(password);
	}
	

}
