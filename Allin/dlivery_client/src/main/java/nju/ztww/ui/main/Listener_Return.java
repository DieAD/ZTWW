package nju.ztww.ui.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener_Return implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Login.frame.getContentPane().removeAll();
		Login.frame.getContentPane().add(Login.panel);
		Login.frame.repaint();
	}

}
