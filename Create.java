package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Create {
	public static boolean createProfile(String username,String password) {
		File f = new File(username);
	    if(!f.exists()) {
	    	f.mkdir();
	    	f = new File(username+"/password.txt");
	    	try {
	    	    FileWriter fw = new FileWriter(f);
				fw.write(password);
	    	    fw.close();
	    	} catch (IOException e) {
				e.printStackTrace();
			}
	    	f = new File(username+"/class.txt");
	    	try {
				FileWriter fw = new FileWriter(f);
				fw.write("");
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return true;
	    }
	    return false;

	}
	
	public static boolean createCourse(String username, String coursename,String quiz,String mid,String fin) {
		File f = new File(username + "/" + coursename);
		if(!f.exists()) {
			f.mkdir();
			try {
				FileWriter fw = new FileWriter(username + "/" + coursename+"/dis.txt");
				fw.write(quiz + " " + mid + " " + fin);
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				FileWriter fw1 = new FileWriter(username + "/class.txt",true);
				fw1.write(coursename + " ");
				fw1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				FileWriter fw2 = new FileWriter(username + "/" + coursename+"/id.txt");
				fw2.write("");
				fw2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				FileWriter fw = new FileWriter(username+"/"+coursename+"/quiz.txt",true);
				fw.write("");
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				FileWriter fw = new FileWriter(username+"/"+coursename+"/mid.txt",true);
				fw.write("");
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				FileWriter fw = new FileWriter(username+"/"+coursename+"/final.txt");
				fw.write("");
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
	
	public static boolean createStudent(String username,String coursename,String id) {
		File f = new File(username+"/"+coursename+"/"+id);
		if(!f.exists()) {
			f.mkdir();
			try {
				FileWriter fw = new FileWriter(username + "/" + coursename+"/id.txt",true);
				fw.write(id + " ");
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				FileWriter fw = new FileWriter(username+"/"+coursename+"/"+id+"/quiz.txt",true);
				fw.write("");
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				FileWriter fw = new FileWriter(username+"/"+coursename+"/"+id+"/mid.txt",true);
				fw.write("");
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				FileWriter fw = new FileWriter(username+"/"+coursename+"/"+id+"/final.txt");
				fw.write("");
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				FileWriter fw = new FileWriter(username+"/"+coursename+"/"+id+"/student.txt");
				fw.write("");
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
	
	public static JMenuItem[] getCourseItem(String username) {
		int i = 0;
		File f = new File(username+"/class.txt");
		Scanner input;
		JMenuItem[] menuItem = null;
		try {
			input = new Scanner(f);
			while(input.hasNext()) {
				i++;
				input.next();
			}
			menuItem = new JMenuItem[i];
			input.close();
			Scanner input1 = new Scanner(f);
			for(int j=0;j<i;j++) {
				menuItem[j] = new JMenuItem(input1.next());
			}
			input1.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItem;
		
	}

	
	public JTextField[] getStudentT(String username,String coursename) {
		int i = 0;
		File file = new File(username + "/" + coursename+"/id.txt");
		try {
			Scanner input = new Scanner(file);
			while(input.hasNext()) {
				i++;
				input.next();
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JTextField[] studentT = new JTextField[i];
		try {
			Scanner input = new Scanner(file);
			for(int j=0;j<i;j++) {
				studentT[j] = new JTextField(input.next());
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentT;
	}
	
	public static JLabel[] getStudentLabel(String username,String coursename) {
		int i = 0;
		File file = new File(username + "/" + coursename+"/id.txt");
		try {
			Scanner input = new Scanner(file);
			while(input.hasNext()) {
				i++;
				input.next();
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel[] studentLabel = new JLabel[i];
		try {
			Scanner input = new Scanner(file);
			for(int j=0;j<i;j++) {
				studentLabel[j] = new JLabel(input.next());
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentLabel;
	}
	
	public static void saveFullMarks(String username,String coursename,String exam,String fullMarks) {
		File file = new File(username+"/"+coursename+"/"+exam+".txt");
		try {
			FileWriter fw = new FileWriter(file,true);
			fw.write(fullMarks + " ");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void saveStudentMarks(String username,String coursename,String id,String exam,String marks) {
		File file = new File(username+"/"+coursename+"/"+id+"/"+exam+".txt");
		try {
			FileWriter fw = new FileWriter(file,true);
			fw.write(marks + " ");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int getCourseQuizMarks(String username,String course) {
		File file = new File(username+"/"+course+"/quiz.txt");
		int total = 0;
		try {
			Scanner input = new Scanner(file);
			while(input.hasNextInt()) {
				total+=input.nextInt();
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return total;
		
	}
	
	public static int getCourseMidMarks(String username,String course) {
		File file = new File(username+"/"+course+"/mid.txt");
		int total = 0;
		try {
			Scanner input = new Scanner(file);
			while(input.hasNextInt()) {
				total+=input.nextInt();
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return total;
		
	}
	
	public static int getCourseFinalMarks(String username,String course) {
		File file = new File(username+"/"+course+"/final.txt");
		int total = 0;
		try {
			Scanner input = new Scanner(file);
			while(input.hasNextInt()) {
				total+=input.nextInt();
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return total;
		
	}
	
	public static int getQuizPercent(String username,String course) {
		int percent = 0;
		File file = new File(username+"/"+course+"/dis.txt");
		try {
			Scanner input = new Scanner(file);
			percent = input.nextInt();
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return percent;
	}
	
	public static int getMidPercent(String username,String course) {
		int percent = 0;
		File file = new File(username+"/"+course+"/dis.txt");
		try {
			Scanner input = new Scanner(file);
			input.nextInt();
			percent = input.nextInt();
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return percent;
	}
	
	public static int getFinalPercent(String username,String course) {
		int percent = 0;
		File file = new File(username+"/"+course+"/dis.txt");
		try {
			Scanner input = new Scanner(file);
			input.nextInt();
			input.nextInt();
			percent = input.nextInt();
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return percent;
	}
	
	public static int getStudentQuizMarks(String username,String course,String id) {
		File file = new File(username+"/"+course+"/"+id+"/quiz.txt");
		int total = 0;
		try {
			Scanner input = new Scanner(file);
			while(input.hasNextInt()) {
				total+=input.nextInt();
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return total;
		
	}
	
	public static int getStudentmidMarks(String username,String course,String id) {
		File file = new File(username+"/"+course+"/"+id+"/mid.txt");
		int total = 0;
		try {
			Scanner input = new Scanner(file);
			while(input.hasNextInt()) {
				total+=input.nextInt();
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return total;
		
	}
	public static int getStudentfinalMarks(String username,String course,String id) {
		File file = new File(username+"/"+course+"/"+id+"/final.txt");
		int total = 0;
		try {
			Scanner input = new Scanner(file);
			while(input.hasNextInt()) {
				total+=input.nextInt();
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return total;
		
	}

}
