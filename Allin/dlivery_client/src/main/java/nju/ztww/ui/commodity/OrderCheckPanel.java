package nju.ztww.ui.commodity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nju.ztww.po.TracePO;
import nju.ztww.service.CheckOrderService;
import nju.ztww.serviceimpl.CheckOrderServiceImpl;

public class OrderCheckPanel extends JPanel {
	ArrayList<JLabel> jlabellist=new ArrayList<JLabel>();
	ArrayList<TracePO> textstring=new ArrayList<TracePO>(); 
	ArrayList<JLabel>  jlabelwdot=new ArrayList<JLabel>();
	
	public JLabel JLabelbdot;
	final ImageIcon bg=new ImageIcon("photo/bg.jpg");
	final ImageIcon wdot=new ImageIcon("photo/wdot.jpg");
	final ImageIcon bdot=new ImageIcon("photo/bdot.jpg");
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
    		 JLabel jlabel=new JLabel();
    		 jlabel.setText(textstring.get(i).getTrace());
    		 jlabellist.add(jlabel);
    	 }
    	 for(int i=0;i<textstring.size()-1;i++ ){
    		 JLabel jlabel=new JLabel();
    		 jlabel.setIcon(wdot);
    		 jlabelwdot.add(jlabel);
    	 }
    	
    	 JLabelbdot=new JLabel();
    	 JLabelbdot.setIcon(bdot);
     }
     public void setPosition(){
    	
    	 this.setLayout(null);
    	 int index=0;
    	 System.out.println(jlabellist.size());
    	 for(int i=0;i<jlabellist.size()-1;i++){
    		 index=i;
    		 jlabellist.get(i).setFont(new Font("宋体",Font.PLAIN,15));
    		jlabellist.get(i).setBounds(50, 50*i, 300, 30);
    		jlabelwdot.get(i).setBounds(0, 50*i, 25, 25);
    		this.add(jlabellist.get(i));
    		this.add(jlabelwdot.get(i));
    	 }
    	 jlabelwdot.get(index).setVisible(false);
    	 JLabelbdot.setBounds(0, 50*index, 25, 25);
    	 this.add(JLabelbdot);

     }
     public void paintComponent(Graphics g){
  		super.paintComponent(g);
  		
  		Image background=new ImageIcon("photo/checkbg.jpg").getImage();
  		g.drawImage(background, 0,0,null);
  		
  	}
}
