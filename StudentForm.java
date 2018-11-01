package frames;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


@SuppressWarnings("serial")
public class StudentForm extends Frame implements ActionListener {
	
	private JLabel idL;
	private JTextField idT;
	private JButton done;
	private String username;
	private String coursename;

	public StudentForm(String username,String coursename) {
		this.username = username;
		this.coursename = coursename;
		initGUI();
	}
	
	public void showFrame() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void initGUI() {
		setLayout(new GridLayout(2,2));
		idL = new JLabel("ID");
		idT = new JTextField();
		done = new JButton("Done");
		done.addActionListener(this);
		add(idL);
		add(idT);
		add(new JLabel());
		add(done);
		setSize(300,100);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==done) {
			if(file.Create.createStudent(username, coursename, idT.getText())) {
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "Id already exists","Warning",JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}

}
