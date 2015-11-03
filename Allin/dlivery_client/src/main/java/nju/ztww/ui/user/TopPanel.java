package nju.ztww.ui.user;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel {
	JLabel Welcome;
	public TopPanel() {
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
	
	// TODO Auto-generated constructor stub

	

}
