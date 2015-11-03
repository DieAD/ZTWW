package nju.ztww.ui.user;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClerkOfCenterTopPanel extends JPanel {
	JLabel Welcome;
	public ClerkOfCenterTopPanel() {
		setup();
		setPosition();
		}
	public void setup(){
		 Welcome=new JLabel("Welcome Worker of Center");
			
	}
	public void setPosition(){
		this.setLayout(null);
		Welcome.setBounds(250, 0, 200, 100);
		this.add(Welcome);
}
}
