package nju.ztww.ui.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManaUserControllerUI  implements ActionListener{

	JFrame jframe;
	JPanel jpanel;
	ArrayList<JPanel>arraylist;
	public ManaUserControllerUI(JFrame jframe,JPanel jpanel,ArrayList<JPanel>arraylist){
		this.jframe=jframe;
    	this.jpanel=jpanel;
    	this.arraylist=arraylist;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 for(JPanel panel:arraylist){
	    	 panel.setVisible(false);
	     }	    
	     jpanel.setVisible(true);
	}

}
