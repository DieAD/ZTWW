package nju.ztww.ui.manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GManager_Listener implements ActionListener {
	private JFrame frame;
	private JPanel panel;
	private ArrayList<JPanel> panelList;

	public GManager_Listener(JFrame frame,JPanel panel,ArrayList<JPanel> panelList){
		this.frame = frame;
		this.panel = panel;
		this.panelList = panelList;
		
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(JPanel p : panelList){
			p.setVisible(false);
		}
		panel.setVisible(true);
	}

}
