package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Check {
	
	@SuppressWarnings("resource")
	public static String checkProfile(String username,String password) {
		File f = new File(username);
		if(f.exists()) {
			f = new File(username+"/password.txt");
			try {
				Scanner input = new Scanner(f);
				if(input.nextLine().equals(password)) {
					return null;
				}
				input.close();
				return "Password";
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return "Username";
	}
	
	public static String checkStudentProfile(String username,String coursename,String id) {
		File f = new File(username);
		if(f.exists()) {
			f = new File(username+"/"+coursename+"/dis.txt");
			if(f.exists()) {
				f = new File(username+"/"+coursename+"/"+id+"/student.txt");
				if(f.exists()) {
					return null;
				}
				return "ID";
			}
			return "Course";
		}
		return "Username";

	}

}
