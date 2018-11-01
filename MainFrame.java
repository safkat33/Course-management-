package frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;




import file.Create;

@SuppressWarnings("serial")
public class MainFrame extends Frame implements ActionListener {
	
	private JMenuBar menuBar;
	private JMenu course;
	private JMenuItem addCourse;
	private JMenuItem logOut;
	private JMenuItem credit;
	private JMenu help;
	private CourseForm courseFrom;
	private String username;
	private JLabel usernameT;
	private JMenuItem courseItem[];
	private CoursePanel coursePanel;
	private boolean refresh = false;
	private CreditFrame c;
	public MainFrame(String username) {
		this.username = username;
		initGUI();
	}

	private void initGUI() {
		menuBar = new JMenuBar();
		course = new JMenu("Course");
		addCourse = new JMenuItem("Add Course");
		courseItem = Create.getCourseItem(username);
		addCourse.addActionListener(this);
		for(int i=0;i<courseItem.length;i++) {
			courseItem[i].addActionListener(this);
			course.add(courseItem[i]);
		}
		course.add(addCourse);
		help = new JMenu("Help");
		logOut = new JMenuItem("LogOut");
		logOut.addActionListener(this);
		credit = new JMenuItem("Credit");
		credit.addActionListener(this);
		help.add(logOut);
		help.add(credit);
		usernameT = new JLabel("Signed in as " + username);
		menuBar.add(course);
		menuBar.add(help);
		menuBar.add(new JLabel("                                                                                                                                                    "));
		menuBar.add(usernameT);
		setJMenuBar(menuBar);
		menuBar.setBackground(Color.cyan);
	}

	public void showFrame() {
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==logOut) {
			NSZFrame frame = new NSZFrame();
			frame.showFrame();
			dispose();
		}
		else if(e.getSource()==credit) {
			c = new CreditFrame(username);
			c.showFrame();
			dispose();
		}
		else if(e.getSource()==addCourse) {
			courseFrom = new CourseForm(username);
			courseFrom.showFrame();
			dispose();
		}
		for(int i=0;i<courseItem.length;i++) {
			if(e.getSource()==courseItem[i]) {
				if(refresh) {
					remove(coursePanel);
				}
				refresh = true;
				coursePanel = new CoursePanel(username,courseItem[i].getText());
				add(coursePanel);
				coursePanel.setBounds(0, 0, 640, 480);
				setVisible(true);
			}
		}
		
		
	}

}
