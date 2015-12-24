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
		else if(flag==1){
			special1();
		}
		else if(flag==2){
			special2();
		}
		//frame.add(panel);
	}
	
	public void special1(){
		for(EditPanel p:list){
			p.setVisible(false);
		}
		EditPanel init = new EditInit(new String[]{"账号","创建时间","创建人","是否使用中"}, null);
		init.setBounds(150,100,750,450);
		init.setVisible(true);
		list.add(init);
	    frame.add(init);
	    frame.repaint();
	}
	
	public void special2(){
		for(EditPanel p:list){
			p.setVisible(false);
		}
		EditPanel search = new EditSearch();
		search.setBounds(150,100,750,450);
		search.setVisible(true);
		list.add(search);
	    frame.add(search);
	    frame.repaint();
	}

}
