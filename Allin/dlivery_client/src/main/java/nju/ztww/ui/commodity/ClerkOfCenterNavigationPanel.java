package nju.ztww.ui.commodity;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class ClerkOfCenterNavigationPanel extends JPanel {
	
	JButton ArriveMid;//椋炴満
	JButton ArriveEnd;//鐏溅
	JButton Transfer;//姹借溅
	JButton CarLoadbutton;//涓浆鎺ユ敹
	JButton StorageFind;
	final ImageIcon Plane=new ImageIcon("photo/arriveMid.gif");
	final ImageIcon Train=new ImageIcon("photo/arriveEnd.gif");
	final ImageIcon Bus=new ImageIcon("photo/zhongzhuan.gif");
	final ImageIcon Receive=new ImageIcon("photo/CarLoading2.gif");
  public ClerkOfCenterNavigationPanel() {
	// TODO Auto-generated constructor stub
	  
	  setup();
	  setPosition();
}
  public void setup(){//鍒濆鍖栭儴浠跺璞�
	  
	  ArriveMid=new JButton();
	  ArriveMid.setIcon(Plane);
//	  ArriveEnd=new JButton();
//	  ArriveEnd.setIcon(Train);
	  Transfer=new JButton();
	  Transfer.setIcon(Bus);
	  CarLoadbutton=new JButton();
	  CarLoadbutton.setIcon(Receive);
	  StorageFind=new JButton("查看库存");
	  StorageFind.setIcon(null);
  }
 public void setPosition(){//璁剧疆浣嶇疆
	 this.setLayout(null);
	 
	 ArriveMid.setBounds(0, 60, 210, 58);
//	 ArriveEnd.setBounds(0, 118, 210, 58);
	 Transfer.setBounds(0, 118, 210, 58);
	 CarLoadbutton.setBounds(0, 176, 210, 58);
	 StorageFind.setBounds(0, 234, 210, 58);
	// this.add(IDbutton);
	 this.add(ArriveMid);
//	 this.add(ArriveEnd);
	 this.add( Transfer);
	 this.add(CarLoadbutton);
	 this.add(StorageFind);
 }
 public void setListener(){
	
	 
 }
 
 public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Image background=new ImageIcon("photo/bbbackground.gif").getImage();
		g.drawImage(background, 0,0,null);
		
	}
}


