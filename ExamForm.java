package frames;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ExamForm extends Frame implements ActionListener {
	
	private String username;
	private String coursename;
	private JLabel[] studentLabel;
	private String[] S = {"Quiz","Mid","Final"};
	private String[] s = {"quiz","mid","final"};
	private JLabel examL;
	@SuppressWarnings("rawtypes")
	private JComboBox examCombo;
	private JLabel fullMarksL;
	private JTextField fullMarksT;
	private JTextField[] marksT;
	private JButton done;

	public ExamForm(String username,String coursename) {
		this.username = username;
		this.coursename = coursename;
		initGUI();
		setSize(350,(studentLabel.length+3)*50);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void showFrame() {
		setVisible(true);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initGUI() {
		studentLabel = file.Create.getStudentLabel(username, coursename);
		marksT = new JTextField[studentLabel.length];
		setLayout(new GridLayout(studentLabel.length+3,2));
		examL = new JLabel("Exam type");
		examCombo = new JComboBox(S);
		fullMarksL = new JLabel("Full marks");
		fullMarksT = new JTextField();
		done = new JButton("Done");
		done.addActionListener(this);
		add(examL);
		add(examCombo);
		add(fullMarksL);
		add(fullMarksT);
		for(int i=0;i<studentLabel.length;i++) {
			add(studentLabel[i]);
			marksT[i] = new JTextField();
			add(marksT[i]);
		}
		add(new JLabel());
		add(done);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==done) {
			file.Create.saveFullMarks(username, coursename, s[examCombo.getSelectedIndex()], fullMarksT.getText());
			for(int i=0;i<studentLabel.length;i++) {
			    file.Create.saveStudentMarks(username, coursename, studentLabel[i].getText(), s[examCombo.getSelectedIndex()], marksT[i].getText());
			    dispose();
			}
		}
	}

}
