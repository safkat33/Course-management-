package frames;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FirstPanel extends javax.swing.JPanel {
	
	private JLabel imageLabel;
	
	public FirstPanel() {
		this("Pic/0.jpg");
	}

	public FirstPanel(String s) {
		initGUI(s);
	}
	
	private void initGUI(String s) {
		imageLabel = new JLabel(new ImageIcon(s));
		add(imageLabel);
		imageLabel.setBounds(0, 0, 640, 480);
		
		
	}

}
