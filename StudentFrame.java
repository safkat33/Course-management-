package frames;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class StudentFrame extends Frame implements ActionListener{
	
	private String username;
	private String coursename;
	private String id;
	private JLabel quizL;
	private JLabel midL;
	private JLabel finL;
	private JLabel resultL;
	private int courseQuizMarks;
	private int courseMidMarks;
	private int courseFinalMarks;
	private int quizPercent;
	private int midPercent;
	private int finPercent;
	private int studentQuizMarks;
	private int studentMidMarks;
	private int studentFinalMarks;
	private JTextField quiz1T;
	private int quiz;
	private int mid;
	private int fin;
	private int total;
	private JTextField quizT;
	private JTextField mid1T;
	private JTextField midT;
	private JTextField fin1T;
	private JTextField finT;
	private JTextField totalT;
	private JTextField gradeT;
	private JMenuBar menuBar;
	private JMenu help;
	private JMenuItem logOut;
	private JMenuItem credit;
	private JLabel idT;
	private CreditFrame c;

	public StudentFrame(String username,String coursename,String id) {
		this.username = username;
		this.coursename = coursename;
		this.id = id;
		initGUI();
		setSize(600,300);
	}
	
	public void showFrame() {
		setVisible(true);
	}

	private void initGUI() {
		menuBar = new JMenuBar();
		help = new JMenu("Help");
		logOut = new JMenuItem("LogOut");
		logOut.addActionListener(this);
		credit = new JMenuItem("Credit");
		credit.addActionListener(this);
		
		help.add(logOut);
		
		help.add(credit);
		
		idT = new JLabel("Signed in as " + id);
		
		menuBar.add(help);
		menuBar.add(new JLabel("                                                                                                                                                 "));
		menuBar.add(idT);
		setJMenuBar(menuBar);
		menuBar.setBackground(Color.cyan);
		setLayout(new GridLayout(5,3));
		courseQuizMarks = file.Create.getCourseQuizMarks(username, coursename);
		courseMidMarks = file.Create.getCourseMidMarks(username, coursename);
		courseFinalMarks = file.Create.getCourseFinalMarks(username, coursename);
		quizPercent = file.Create.getQuizPercent(username, coursename);
		midPercent = file.Create.getMidPercent(username, coursename);
		finPercent = file.Create.getFinalPercent(username, coursename);
		studentQuizMarks = file.Create.getStudentQuizMarks(username, coursename, id);
		studentMidMarks = file.Create.getStudentmidMarks(username, coursename, id);
		studentFinalMarks = file.Create.getStudentfinalMarks(username, coursename, id);
		quiz = studentQuizMarks*quizPercent/courseQuizMarks;
		mid = studentMidMarks*midPercent/courseMidMarks;
		fin = studentFinalMarks*finPercent/courseFinalMarks;
		total = quiz+mid+fin;
		add(new JLabel());
		add(new JLabel("Marks"));
		add(new JLabel("After percentage"));
		quizL = new JLabel("Quiz");
		add(quizL);
		quiz1T = new JTextField(studentQuizMarks + "");
		quiz1T.setEditable(false);
		add(quiz1T);
		quizT = new JTextField(quiz + "");
		quizT.setEditable(false);
		add(quizT);
		midL = new JLabel("Mid");
		add(midL);
		mid1T = new JTextField(studentMidMarks + "");
		mid1T.setEditable(false);
		add(mid1T);
		midT = new JTextField(mid + "");
		midT.setEditable(false);
		add(midT);
		finL = new JLabel("Final");
		add(finL);
		fin1T = new JTextField(studentFinalMarks + "");
		fin1T.setEditable(false);
		add(fin1T);
		finT = new JTextField(fin+ "");
		finT.setEditable(false);
		add(finT);
		resultL = new JLabel("Result");
		add(resultL);
		totalT = new JTextField(total + "");
		totalT.setEditable(false);
		add(totalT);
		gradeT = new JTextField();
		gradeT.setEditable(false);
		add(gradeT);
		if(total>=90) {
			gradeT.setText("A");
		}
		else if(total>=80) {
			gradeT.setText("B");
		}
		else if(total>=70) {
			gradeT.setText("c");
		}
		else if(total>=60) {
			gradeT.setText("D");
		}
		else{
			gradeT.setText("F");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==logOut) {
			NSZFrame frame = new NSZFrame();
			frame.showFrame();
			dispose();
		}
		
		if(e.getSource()==credit) {
			c = new CreditFrame(username,coursename,id);
			c.showFrame();
			dispose();
		}
	}

}
