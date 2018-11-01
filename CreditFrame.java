package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class CreditFrame extends Frame implements ActionListener{
	
	private String username;
	private JLabel creditLabel;
	private Timer t;
	private MainFrame frame;
	private String course;
	private String id;
	private boolean student = false;
	private StudentFrame studentFrame;

	public CreditFrame(String username) {
		this.username = username;
		initGUI();
	}
	
	public CreditFrame(String username,String course,String id) {
		this.username = username;
		this.course = course;
		this.id = id;
		student  = true;
		initGUI();
	}
	
	public void showFrame() {
		setVisible(true);
		t = new Timer(33000,this);
		t.start();
	}

	private void initGUI() {
		creditLabel = new JLabel(new ImageIcon("Pic/NSZ.gif"));
		add(creditLabel);
		creditLabel.setBounds(0, 0, 640, 480);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==t) {
			if(student) {
				studentFrame = new StudentFrame(username,course,id);
		        studentFrame.showFrame();
			}
			else {
			    frame = new MainFrame(username);
			    frame.showFrame();
			}
			dispose();
			t.stop();
		}
		
	}

}
