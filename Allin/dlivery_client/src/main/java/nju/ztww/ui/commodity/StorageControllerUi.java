package nju.ztww.ui.commodity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StorageControllerUi implements ActionListener {
	JFrame jframe;
	JPanel jpanel;
	ArrayList<JPanel>arraylist;
    public StorageControllerUi(JFrame jframe,JPanel jpanel,ArrayList<JPanel>arraylist) {
		// TODO Auto-generated constructor stub
    	this.jframe=jframe;
    	this.jpanel=jpanel;
    	this.arraylist=arraylist;
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
     for(JPanel e:arraylist){
    	 e.setVisible(false);
     }
    
     jpanel.setVisible(true);
     
	}

}
