package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CoursePanel extends javax.swing.JPanel implements ActionListener {
	
	public class ResultFrame extends Frame {

		public ResultFrame(String username, String coursename) {
			// TODO Auto-generated constructor stub
		}

	}

	private JButton addStudent;
	private JButton viewResult;
	private JPanel p1;
	private String coursename;
	private JLabel coursenameL;
	private StudentForm studentForm;
	private String username;
	private JPanel p2;
	private JTextField[] studentT;
	private JButton addExam;
	private ExamForm examForm;
	private ResutlFrame resultFrame;
	public CoursePanel(String username,String coursename){
		this.username = username;
		this.coursename = coursename;
		initGUI();
	}

	private void initGUI() {
		setLayout(new BorderLayout());
		addStudent = new JButton("Add student");
		addStudent.addActionListener(this);
		viewResult = new JButton("View result");
		viewResult.addActionListener(this);
		addExam = new JButton("Add exam");
		addExam.addActionListener(this);
		p1 = new JPanel();
		p1.setLayout(new GridLayout(10,1,5,5));
		p1.add(addStudent);
		p1.add(addExam);
		p1.add(viewResult);
		add(p1,BorderLayout.WEST);
		coursenameL = new JLabel(coursename);
		coursenameL.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		coursenameL.setForeground(Color.DARK_GRAY);
		add(coursenameL,BorderLayout.NORTH);
		studentT = new file.Create().getStudentT(username, coursename);
		p2 = new JPanel();
		p2.setLayout(new GridLayout(10,1,5,5));
		for(int i=0;i<studentT.length;i++) {
			p2.add(studentT[i]);
			studentT[i].setEditable(false);
		}
		add(p2,BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addStudent) {
			studentForm = new StudentForm(username,coursename);
			studentForm.showFrame();
		}
		
		if(e.getSource()==addExam) {
			examForm = new ExamForm(username,coursename);
			examForm.showFrame();
		}
		if(e.getSource()==viewResult) {
			try{
			    resultFrame = new ResutlFrame(username,coursename);
			    resultFrame.showFrame();
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(null, "Grade is not given yet", "Warning!", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

}
