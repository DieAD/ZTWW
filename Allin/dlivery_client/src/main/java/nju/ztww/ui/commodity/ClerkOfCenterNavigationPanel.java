package nju.ztww.ui.commodity;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nju.ztww.ui.commodity.InofStoragePanel;
import nju.ztww.ui.commodity.OutofStoragePanel;

public class ClerkOfCenterNavigationPanel extends JPanel {
	JButton IDbutton;//ID
	JButton Planebutton;//飞机
	JButton Trainbutton;//火车
	JButton Busbutton;//汽车
	JButton Receivebutton;//中转接收
	final ImageIcon Plane=new ImageIcon("photo/plane.jpg");
	final ImageIcon Train=new ImageIcon("photo/Train.jpg");
	final ImageIcon Bus=new ImageIcon("photo/Bus.jpg");
	final ImageIcon Receive=new ImageIcon("photo/Receive.jpg");
  public ClerkOfCenterNavigationPanel() {
	// TODO Auto-generated constructor stub
	  
	  setup();
	  setPosition();
}
  public void setup(){//初始化部件对象
	  IDbutton=new JButton("ID");
	  Planebutton=new JButton();
	  Planebutton.setIcon(Plane);
	  Trainbutton=new JButton();
	  Trainbutton.setIcon(Train);
	  Busbutton=new JButton();
	  Busbutton.setIcon(Bus);
	  Receivebutton=new JButton("接收单");
	  Receivebutton.setIcon(Receive);
  }
 public void setPosition(){//设置位置
	 this.setLayout(null);
	 IDbutton.setBounds(0, 0, 150, 100);
	 Planebutton.setBounds(0, 100, 150, 80);
	 Trainbutton.setBounds(0, 180, 150, 80);
	 Busbutton.setBounds(0, 260, 150, 80);
	 Receivebutton.setBounds(0, 340, 150, 80);
	 this.add(IDbutton);
	 this.add(Planebutton);
	 this.add(Trainbutton);
	 this.add( Busbutton);
	 this.add(Receivebutton);
	 
 }
 public void setListener(){
	
	 
 }
}


