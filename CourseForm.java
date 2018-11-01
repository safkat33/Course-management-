package frames;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import file.Create;

@SuppressWarnings("serial")
public class CourseForm extends Frame implements ActionListener {
	
	private JLabel courseNameL;
	private JTextField courseNameT;
	private JLabel quizL;
	private JTextField quizT;
	private JLabel midL;
	private JTextField midT;
	private JButton done;
	private JLabel finL;
	private JTextField finT;
	private String username;
	private MainFrame frame;
	private JButton cancel;
	public CourseForm(String username) {
		this.username = username;
		initGUI();
	}
	
	public void showFrame() {
		setVisible(true);
	}

	private void initGUI() {
		courseNameL = new JLabel("Course Name");
		courseNameT = new JTextField();
		quizL = new JLabel("Quiz%");
		quizT = new JTextField();
		midL = new JLabel("Mid%");
		midT = new JTextField();
		finL = new JLabel("Final%");
		finT = new JTextField();
		done = new JButton("done");
		done.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		setLayout(new GridLayout(5,2));
		add(courseNameL);
		add(courseNameT);
		add(quizL);
		add(quizT);
		add(midL);
		add(midT);
		add(finL);
		add(finT);
		add(done);
		add(cancel);
		setSize(400,250);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==done) {
			if(Integer.parseInt(quizT.getText())+Integer.parseInt(midT.getText())+Integer.parseInt(finT.getText())==100)
			    if(Create.createCourse(username,courseNameT.getText(),quizT.getText(), midT.getText(),finT.getText())) {
				    frame = new MainFrame(username);
				    frame.showFrame();
				    dispose();
			    }
			    else {
					JOptionPane.showMessageDialog(null, "Course already exists", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			else {
				JOptionPane.showMessageDialog(null, "Quiz%+Mid%+Final% must be 100", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		    
		}
		if(e.getSource()==cancel) {
			frame = new MainFrame(username);
			frame.showFrame();
			dispose();
		}
		
	}

}
