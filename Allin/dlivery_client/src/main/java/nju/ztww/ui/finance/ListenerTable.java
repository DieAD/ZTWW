package nju.ztww.ui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ListenerTable implements ActionListener {
	 private JFrame frame;
	 private JPanel panel;
	 private ArrayList<EditPanel> list;
	 private int flag;
	
	public ListenerTable(JFrame frame,JPanel panel,ArrayList<EditPanel> list,int flag){
		this.frame = frame;
		this.panel = panel;
		this.list = list;
	    this.flag = flag;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(flag==0){
		for(EditPanel p:list){
			p.setVisible(false);
		}
		panel.setVisible(true);}
		else{
			special();
		}
		//frame.add(panel);
	}
	
	public void special(){
		for(EditPanel p:list){
			p.setVisible(false);
		}
		EditPanel init = new EditInit(null, null);
		init.setBounds(150,100,750,450);
		list.add(init);
	    frame.add(init);
	    frame.repaint();
	}

}
