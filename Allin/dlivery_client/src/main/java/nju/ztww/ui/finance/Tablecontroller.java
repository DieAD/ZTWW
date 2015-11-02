package nju.ztww.ui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tablecontroller implements ActionListener {
	 private JFrame frame;
	 private JPanel panel;
	 private ArrayList<EditPanel> list;
	
	public Tablecontroller(JFrame frame,JPanel panel,ArrayList<EditPanel> list){
		this.panel = panel;
		this.list = list;
	   
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(EditPanel p:list){
			p.setVisible(false);
		}
		panel.setVisible(true);
		//frame.add(panel);
	}

}
