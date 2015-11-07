package nju.ztww.ui.commodity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClerkOfCenterController implements ActionListener {
     JFrame  jframe;
     JPanel  jpanel;
     ArrayList<JPanel>arraylist;
     public ClerkOfCenterController(JFrame  jframe,JPanel  jpanel,ArrayList<JPanel>arraylist) {
    	 this.jframe=jframe;
    	 this.jpanel=jpanel;
    	 this.arraylist=arraylist;
		// TODO Auto-generated constructor stub
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(JPanel s:arraylist){
	    	 s.setVisible(false);
	     }
	     jpanel.setVisible(true);

	}

}
