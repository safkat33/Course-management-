package frames;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ResutlFrame extends Frame{

	private String username;
	private String coursename;
	private JLabel[] studentLabel;
	private int courseQuizMarks;
	private int courseFinalMarks;
	private int courseMidMarks;
	private int quizPercent;
	private int midPercent;
	private int finPercent;
	private JLabel idL;
	private JLabel quizL;
	private JLabel midL;
	private JLabel finL;
	private int total;
	private JLabel totalL;
	private JLabel grade;
	private JTextField[] studentQuizL;
	private JTextField[] studentmidL;
	private JTextField[] studentFinalL;
	private JTextField[] studentTotalL;
	private JTextField[] studentGradeL;
	private int studentQuiz;
	private int studentMid;
	private int studentFinal;
	private int studentTotal;
	private int score;

	public ResutlFrame(String username,String coursename) {
		this.username = username;
		this.coursename = coursename;
		initGUI();
		setSize(400,(studentLabel.length+1)*50);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void showFrame() {
		if(studentLabel.length==0) {
			setVisible(false);
			JOptionPane.showMessageDialog(null, "No student was added", "Warning",JOptionPane.WARNING_MESSAGE);
		}
		else {
			setVisible(true);
		}
	}

	private void initGUI() {
		courseQuizMarks = file.Create.getCourseQuizMarks(username, coursename);
		courseMidMarks = file.Create.getCourseMidMarks(username, coursename);
		courseFinalMarks = file.Create.getCourseFinalMarks(username, coursename);
		quizPercent = file.Create.getQuizPercent(username, coursename);
		midPercent = file.Create.getMidPercent(username, coursename);
		finPercent = file.Create.getFinalPercent(username, coursename);
		studentLabel = file.Create.getStudentLabel(username, coursename);
		setLayout(new GridLayout(studentLabel.length+1,6));
		idL = new JLabel("ID");
		quizL = new JLabel("Quiz(" + quizPercent + ")");
		midL = new JLabel("Mid(" + midPercent + ")");
		finL = new JLabel("Final(" + finPercent + ")");
		total = quizPercent+midPercent+finPercent;
		totalL = new JLabel("Total("+total+")");
		grade = new JLabel("Grade");
		add(idL);
		add(quizL);
		add(midL);
		add(finL);
		add(totalL);
		add(grade);
		studentQuizL = new JTextField[studentLabel.length];
		studentmidL = new JTextField[studentLabel.length];
		studentFinalL = new JTextField[studentLabel.length];
		studentTotalL = new JTextField[studentLabel.length];
		studentGradeL = new JTextField[studentLabel.length];
		if(studentLabel.length==0) {
		}
		for(int i=0;i<studentLabel.length;i++) {
			studentQuiz = file.Create.getStudentQuizMarks(username, coursename, studentLabel[i].getText())*quizPercent/courseQuizMarks;
			studentMid = file.Create.getStudentmidMarks(username, coursename, studentLabel[i].getText())*midPercent/courseMidMarks;
			studentFinal = file.Create.getStudentfinalMarks(username, coursename, studentLabel[i].getText())*finPercent/courseFinalMarks;
			studentTotal = studentQuiz+studentMid+studentFinal;
			studentQuizL[i] = new JTextField(studentQuiz + "");
			studentQuizL[i].setEditable(false);
			studentmidL[i] = new JTextField(studentMid + "");
			studentmidL[i].setEditable(false);
			studentFinalL[i] = new JTextField(studentFinal + "");
			studentFinalL[i].setEditable(false);
			studentTotalL[i] = new JTextField(studentTotal + "");
			studentTotalL[i].setEditable(false);
			score = studentTotal*100/total;
			if(score>=90) {
				studentGradeL[i] = new JTextField("A");
				studentGradeL[i].setEditable(false);
			}
			else if(score>=80) {
				studentGradeL[i] = new JTextField("B");
				studentGradeL[i].setEditable(false);
			}
			else if(score>=70) {
				studentGradeL[i] = new JTextField("C");
				studentGradeL[i].setEditable(false);
			}
			else if(score>=60) {
				studentGradeL[i] = new JTextField("D");
				studentGradeL[i].setEditable(false);
			}
			else {
				studentGradeL[i] = new JTextField("F");
				studentGradeL[i].setEditable(false);
			}
			add(studentLabel[i]);
			add(studentQuizL[i]);
			add(studentmidL[i]);
			add(studentFinalL[i]);
			add(studentTotalL[i]);
			add(studentGradeL[i]);
		}
	}
}
