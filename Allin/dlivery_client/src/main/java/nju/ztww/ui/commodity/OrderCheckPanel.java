package nju.ztww.ui.commodity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import confligUI.MyLabel;
import nju.ztww.po.TracePO;
import nju.ztww.service.CheckOrderService;
import nju.ztww.serviceimpl.CheckOrderServiceImpl;

public class OrderCheckPanel extends JPanel  {
	
 
	ArrayList<MovingMessagePanel> jpanellist=new ArrayList<MovingMessagePanel>();
	ArrayList<TracePO> textstring=new ArrayList<TracePO>(); 
	ArrayList<MyLabel>  MyLabelwdot=new ArrayList<MyLabel>();
	
	public MyLabel MyLabelbdot;
	final ImageIcon bg=new ImageIcon("photo/bg.jpg");
	final ImageIcon wdot=new ImageIcon("photo/wdot.jpg");
	final ImageIcon bdot=new ImageIcon("photo/bdot.jpg");
	Font font1 = new Font("微软雅黑", Font.PLAIN, 12);
	public OrderCheckPanel(String id) {
		// TODO Auto-generated constructor stub
		System.out.println(id);
		CheckOrderService checkorderservice=new CheckOrderServiceImpl();
		
		textstring=checkorderservice.findTrace(id);
		System.out.println(textstring.get(0).getTrace());
		
		setup();
		setPosition();
	}
     public void setup(){
    	 for(int i=0;i<textstring.size();i++ ){
    		 MovingMessagePanel movingpanel=new  MovingMessagePanel(textstring.get(i).getTrace());
    		 
    		 jpanellist.add(movingpanel);
    	 }
    	 for(int i=0;i<textstring.size()-1;i++ ){
    		 MyLabel MyLabel=new MyLabel();
    		 MyLabel.setIcon(wdot);
    		 MyLabelwdot.add(MyLabel);
    	 }
    	
    	 MyLabelbdot=new MyLabel();
    	 MyLabelbdot.setIcon(bdot);
     }
     public void setPosition(){
    	
    	 this.setLayout(null);
    	 int index=0;
    	 System.out.println(jpanellist.size());
    	 for(int i=0;i<jpanellist.size()-1;i++){
    		 index=i;
    		
    	     
    		jpanellist.get(i).setBounds(50, 50*i, 600, 30);
    		jpanellist.get(i).setFont(font1);
    		jpanellist.get(i).setForeground(Color.getHSBColor(155, 120, 90));
    		jpanellist.get(i).setBackground(Color.darkGray);
    		MyLabelwdot.get(i).setBounds(0, 50*i, 25, 25);
    		this.add(jpanellist.get(i));
    		this.add(MyLabelwdot.get(i));
    	 }
    	 MyLabelwdot.get(index).setVisible(false);
    	 MyLabelbdot.setBounds(0, 50*index, 25, 25);
    	 this.add(MyLabelbdot);

     }
     public void paintComponent(Graphics g){
  		super.paintComponent(g);
  		
  		Image background=new ImageIcon("photo/checkbg.png").getImage();
  		g.drawImage(background, 0,0,null);
  		
  	}
	public void run() {
		// TODO Auto-generated method stub
		  
		
		
	}
	
}
