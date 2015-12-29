package nju.ztww.ui.finance;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import nju.ztww.dao.matrixDO;
import nju.ztww.service.FinanceService;
import nju.ztww.service.UserService;
import nju.ztww.serviceimpl.FinanceServiceImpl;
import nju.ztww.serviceimpl.UserLoginImpl;
import nju.ztww.ui.main.UserInfoUI;
import nju.ztww.vo.ManaUserVO;

public class EditInit extends EditPanel{
	//JLabel label1  = new JLabel("");
	JButton button = new JButton("");
	final ImageIcon initaccout = new ImageIcon("finance/initaccount.png");
	
    public EditInit(String[] strings,Object[][] objects){
    	super(strings,objects);
    	this.setBackground(new Color(250, 240, 230));
    	button.setIcon(initaccout);
    	this.remove(button1);
    	this.remove(button2);
    	this.remove(button3);
    	
    	this.scrollPane.setBounds(0,0,690,250);
    	this.button.setBounds(130, 260, 400, 200);//picture 600x200
    	
    	this.add(button);
    	button.addActionListener(new Listener(this));
    	setTable();
    	this.setVisible(false);
    }
    
    public class Listener implements ActionListener{
    	EditInit panel;
    	INIT init ;
    	public Listener(EditInit panel){
    		this.panel = panel;
    		init =  new INIT(panel);
    	}

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			addMatrix();
		    panel.removeAll();
			init.setBounds(0, 0, 750, 450);
			init.setVisible(true);
		//	init.repaint();
			panel.add(init);
			//init.repaint();
			panel.repaint();
		}
    	public void addMatrix(){
    		ArrayList<matrixDO> list = new ArrayList<matrixDO>();
        	FinanceService fs = new FinanceServiceImpl();
        	list = fs.queryM();
        	int _id = list.size();
        	String id = _id+"";
        	//
        	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
     		String time = df.format(new Date());
     		//
     		UserService us = new UserLoginImpl();
     		ManaUserVO userInfo = us.findByID(UserInfoUI.getUserID());
     		String men = userInfo.getName();
     		//
     		String state = "使用中";
     		
     	    matrixDO form = new matrixDO();
     	    form.setId(id);
     	    form.setMen(men);
     	    form.setState(state);
     	    form.setTime(time);
     	    
     	    fs.insertM(form);
     		
    	}
    }
    
    public void setTable(){
    	int count = tableModel.getRowCount();
    	for(int i=0;i<count;i++){
    		tableModel.removeRow(0);
    	}
    	ArrayList<matrixDO> list = new ArrayList<matrixDO>();
    	FinanceService fs = new FinanceServiceImpl();
    	list = fs.queryM();
    	for(int i=0;i<list.size();i++){
    		String id = list.get(i).getId();
    		String time = list.get(i).getTime();
    		String men = list.get(i).getMen();
    		String state = list.get(i).getState();
    		tableModel.addRow(new Object[]{id,time,men,state});
    	}
    }
    
    
}
