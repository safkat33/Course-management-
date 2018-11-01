package frames;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Animation extends javax.swing.JPanel implements ActionListener {
	
	private JLabel imageLabel;
	private Timer t;
	private int i = 1;
	private boolean plus = true;
	private Font font;
	public JLabel usernameL;
	public JTextField usernameT;
	public JLabel passwordL;
	public JPasswordField passwordT;
	public JLabel courseL;
	public JTextField courseT;
	public JLabel idL;
	public JTextField idT;
	public JButton login;
	public JButton signup;
	public JButton creat;
	public JButton back;
	public JButton sLogin;
	public JButton studentLogin;

	public Animation() {
		initText();
		initGUI();
	}
	
	private void initText() {
		// TODO Auto-generated method stub
		font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		usernameL = new JLabel("Instractor");
		usernameL.setForeground(Color.white);
		usernameL.setFont(font);
		usernameL.setBounds(400, 20, 150, 20);
		add(usernameL);
		usernameT = new JTextField();
		usernameT.setBackground(Color.LIGHT_GRAY);
		usernameT.setBounds(500, 20, 120, 20);
		add(usernameT);
		passwordL = new JLabel("Password");
		passwordL.setForeground(Color.white);
		passwordL.setFont(font);
		passwordL.setBounds(400, 50, 150, 20);
		add(passwordL);
		passwordT = new JPasswordField();
		passwordT.setBackground(Color.LIGHT_GRAY);
		passwordT.setBounds(500, 50, 120, 20);
		add(passwordT);
		courseL = new JLabel("Course");
		courseL.setFont(font);
		courseL.setForeground(Color.WHITE);
		courseL.setBounds(0, 0, 0, 0);
		add(courseL);
		courseT = new JTextField();
		courseT.setBackground(Color.LIGHT_GRAY);
		courseT.setBounds(0, 0, 0, 0);
		add(courseT);
		idL = new JLabel("Id");
		idL.setFont(font);
		idL.setForeground(Color.WHITE);
		idL.setBounds(0, 0, 0, 0);
		add(idL);
		idT = new JTextField();
		idT.setBackground(Color.LIGHT_GRAY);
		idT.setBounds(0, 0, 0, 0);
		add(idT);
		login = new JButton("Login", new ImageIcon("Pic/login.png"));
		login.setForeground(Color.BLACK);
		login.setBackground(Color.CYAN);
		login.setBounds(415, 80, 85, 25);
		add(login);
		signup = new JButton("Signup");
		signup.setForeground(Color.BLACK);
		signup.setBackground(Color.WHITE);
		signup.setBounds(515, 80, 85, 25);
		add(signup);
		creat = new JButton("Creat");
		creat.setForeground(Color.BLACK);
		creat.setBackground(Color.CYAN);
		creat.setBounds(0, 0, 0, 0);
		add(creat);
		back = new JButton("Back", new ImageIcon("Pic/back.png"));
		back.setForeground(Color.BLACK);
		back.setBackground(Color.white);
		back.setBounds(0, 0, 0, 0);
		add(back);
		sLogin = new JButton("Login as student");
		sLogin.setBounds(435, 110, 150, 25);
		add(sLogin);
		studentLogin = new JButton("Login");
		studentLogin.setBackground(Color.cyan);
		studentLogin.setBounds(0, 0, 0, 0);
		add(studentLogin);
	}

	private void initGUI() {
		imageLabel = new JLabel(new ImageIcon("Pic/0.jpg"));
		add(imageLabel);
		imageLabel.setBounds(0, 0, 640, 480);
		t = new Timer(50,this);
		t.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==t) {
			imageLabel.setIcon(new ImageIcon("Pic/" + i + ".jpg"));
			if(plus) {
				i++;
				if(i==25) {
					plus = false;
				}
			}
			else {
				i--;
				if(i==0) {
					plus = true;
				}
			}
		}
		
	}

	

}
