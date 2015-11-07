package nju.ztww.ui.commodity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OrderCheckPanel extends JPanel {
	public JLabel JLabel1;
	public JLabel JLabel2;
	public JLabel JLabel3;
	public JLabel JLabel4;
	public JLabel JLabel5;
	public JLabel JLabel6;
	public JLabel JLabel1wdot;
	public JLabel JLabelbdot;
	final ImageIcon bg=new ImageIcon("photo/bg.jpg");
	final ImageIcon wdot=new ImageIcon("photo/wdot.jpg");
	final ImageIcon bdot=new ImageIcon("photo/bdot.jpg");
	public OrderCheckPanel() {
		// TODO Auto-generated constructor stub
		setup();
		setPosition();
	}
     public void setup(){
    	 JLabel1=new JLabel();
    	 JLabel1.setText("商家正通知快递公司揽件");
    	 JLabel2=new JLabel();
    	 JLabel2.setText("圆通速递已揽件");
    	 JLabel3=new JLabel();
    	 JLabel4=new JLabel();
    	 JLabel5=new JLabel();
    	 JLabel6=new JLabel();
    	 JLabelbdot=new JLabel();
    	 JLabel1wdot=new JLabel();
    	 JLabel1wdot.setIcon(wdot);
    	 JLabelbdot.setIcon(bdot);
     }
     public void setPosition(){
    	 this.setLayout(null);
    	 JLabel1wdot.setBounds(0, 500, 25, 25);
    	 JLabel1.setBounds(50, 500, 300, 30);
    	 JLabel1.setFont(new Font("宋体",Font.PLAIN,15));
    	 JLabelbdot.setBounds(0, 450, 25, 25);
    	 JLabel2.setFont(new Font("宋体",Font.PLAIN,15));
    	 JLabel2.setBounds(50, 450, 300, 30);
    	 this.add(JLabel1wdot);
    	 this.add(JLabel1);
    	 this.add(JLabel2);
    	 this.add(JLabelbdot);
         

     }
     public void paintComponent(Graphics g){
  		super.paintComponent(g);
  		
  		Image background=new ImageIcon("photo/checkbg.jpg").getImage();
  		g.drawImage(background, 0,0,null);
  		
  	}
}
