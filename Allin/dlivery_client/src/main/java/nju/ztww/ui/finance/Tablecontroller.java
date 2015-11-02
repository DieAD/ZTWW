package nju.ztww.ui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tablecontroller implements ActionListener {
	 private JFrame frame;
	 private JPanel panel;
	
	public Tablecontroller(JFrame frame,JPanel panel){
		this.frame = frame;
		this.panel = panel;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame.add(panel);
	}

}
