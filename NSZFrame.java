package frames;

import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class NSZFrame extends Frame implements ActionListener {
	private Timer t1;
	private int height = 15;
	private int width = 20;
	private JLabel backgroundImage;
	private JLabel image;
	private JTextField usernameT;
	private JPasswordField passwordT;
	private JButton login;
	private JButton signup;
	private JButton creat;
	private JButton back;
	private Animation animation;
	public MainFrame frame;
	private JLabel usernameL;
	private JLabel passwordL;
	private JLabel courseL;
	private JTextField courseT;
	private JLabel idL;
	private JTextField idT;
	private JButton sLogin;
	private JButton studentLogin;
	private StudentFrame studentFrame;
	
	public void showFrame() {
		setVisible(true);
		addFirstPanel();
		addBackground();
	}
	
	private void addFirstPanel() {
		image = new JLabel(new ImageIcon("Pic/0.jpg"));
		add(image);
	    t1 = new Timer(20, this);
	    t1.start();
	}

	private void addBackground() {
		backgroundImage = new JLabel(new ImageIcon("Pic/background.jpg"));
		add(backgroundImage);
		backgroundImage.setBounds(0, 0, 640, 480);
	}
	
	private void addAnimation() {
		animation = new Animation();
		add(animation);
		animation.setBounds(0, 0, 640, 480);
		addActoinListen();
	}

	private void addActoinListen() {
		usernameT = animation.usernameT;
		usernameL = animation.usernameL;
		passwordT = animation.passwordT;
		passwordL = animation.passwordL;
		courseL = animation.courseL;
		courseT = animation.courseT;
		idL = animation.idL;
		idT = animation.idT;
		login = animation.login;
		login.addActionListener(this);
		signup = animation.signup;
		signup.addActionListener(this);
		creat = animation.creat;
		creat.addActionListener(this);
		back = animation.back;
		back.addActionListener(this);
		sLogin = animation.sLogin;
		sLogin.addActionListener(this);
		studentLogin = animation.studentLogin;
		studentLogin.addActionListener(this);
	}

	private void showMainFrame() {
		frame = new MainFrame(usernameT.getText());
		frame.showFrame();
		dispose();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==t1) {
			height+=15;
			width+=20;
			image.setBounds(width-640, height-480, 640, 480);
			if(height==480||width==640) {
				t1.stop();
				remove(image);
				backgroundImage.setBounds(0, 0, 0, 0);
				addAnimation();
			}
		}
		else if(e.getSource()==signup) {
			usernameL.setBounds(400, 20, 150, 20);
			usernameT.setBounds(500, 20, 120, 20);
			passwordL.setBounds(400, 50, 150, 20);
			passwordT.setBounds(500, 50, 120, 20);
			courseL.setBounds(0, 0, 0, 0);
			courseT.setBounds(0, 0, 0, 0);
			idL.setBounds(0, 0, 0, 0);
			idT.setBounds(0, 0, 0, 0);
			login.setBounds(0, 0, 0, 0);
			signup.setBounds(0, 0, 0, 0);
			creat.setBounds(415, 80, 85, 25);
			back.setBounds(515, 80, 85, 25);
			sLogin.setBounds(0, 0, 0, 0);
			studentLogin.setBounds(0, 0, 0, 0);
		}
		else if(e.getSource()==creat) {
			if(file.Create.createProfile(usernameT.getText(), passwordT.getText())) {
				showMainFrame();
			}
			else {
				usernameT.setText("");
				passwordT.setText("");
				JOptionPane.showMessageDialog(null, "Profile already exists", "Warning!", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(e.getSource()==login) {
			String s = file.Check.checkProfile(usernameT.getText(), passwordT.getText());
			if(s==null) {
				showMainFrame();
			}
			else {
				JOptionPane.showMessageDialog(null, s + " is wrong", "Warning!", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(e.getSource()==back) {
			usernameL.setBounds(400, 20, 150, 20);
			usernameT.setBounds(500, 20, 120, 20);
			passwordL.setBounds(400, 50, 150, 20);
			passwordT.setBounds(500, 50, 120, 20);
			courseL.setBounds(0, 0, 0, 0);
			courseT.setBounds(0, 0, 0, 0);
			idL.setBounds(0, 0, 0, 0);
			idT.setBounds(0, 0, 0, 0);
			login.setBounds(415, 80, 85, 25);
			signup.setBounds(515, 80, 85, 25);
			creat.setBounds(0, 0, 0, 0);
			back.setBounds(0, 0, 0, 0);
			sLogin.setBounds(435, 110, 150, 25);
			studentLogin.setBounds(0, 0, 0, 0);
			
		}
		else if(e.getSource()==sLogin) {
			usernameL.setBounds(400, 20, 150, 20);
			usernameT.setBounds(500, 20, 120, 20);
			passwordL.setBounds(0, 0, 0, 0);
			passwordT.setBounds(0, 0, 0, 0);
			courseL.setBounds(400, 50, 150, 20);
			courseT.setBounds(500, 50, 120, 20);
			idL.setBounds(400, 80, 1500, 20);
			idT.setBounds(500, 80, 120, 20);
			login.setBounds(0, 0, 0, 0);
			signup.setBounds(0, 0, 0, 0);
			creat.setBounds(0, 0, 0, 0);
			back.setBounds(515, 110, 85, 25);
			sLogin.setBounds(0, 0, 0, 0);
			studentLogin.setBounds(415, 110, 85, 25);
		}
		else if(e.getSource()==studentLogin) {
			String s = file.Check.checkStudentProfile(usernameT.getText(),courseT.getText(),idT.getText());
			if(s==null) {
				try{
			        studentFrame = new StudentFrame(usernameT.getText(),courseT.getText(),idT.getText());
			        studentFrame.showFrame();
			        dispose();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Grade is not given yet", "Warning!", JOptionPane.WARNING_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, s + " is wrong", "Warning!", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
