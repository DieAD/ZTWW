package nju.ztww.ui.commodity;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nju.ztww.ui.order.MyButton;

public class StorageNavigationPanel extends JPanel {
	
	MyButton Outbutton;//出库
	MyButton Inbutton;//入库
	MyButton Panbutton;//库存盘点
	MyButton Checkbutton;//库存查看；
	final ImageIcon In=new ImageIcon("photo/in.png");
	final ImageIcon Out=new ImageIcon("photo/out.png");
	final ImageIcon Check=new ImageIcon("photo/check.png");
	final ImageIcon pan=new ImageIcon("photo/pan.png");
  public StorageNavigationPanel() {
	// TODO Auto-generated constructor stub
	  this.setBackground(new Color(155,122,90));
	  setup();
	  setPosition();
}
  public void setup(){//初始化部件对象
	  
	  
	  Outbutton=new MyButton(3);
	  Outbutton.setIcon(Out);
	  Inbutton=new MyButton(2);
	  Inbutton.setIcon(In);
	  Panbutton=new MyButton(1);
	  Panbutton.setIcon(pan);
	  Checkbutton=new MyButton(0);
	  Checkbutton.setIcon(Check);
  }
 public void setPosition(){//设置位置
	 this.setLayout(null);
	
//	 Checkbutton.setBounds(0, 60, 150, 60);
//	 Panbutton.setBounds(0, 120, 150, 60);
//	 Inbutton.setBounds(0, 180, 150, 60);
//	 Outbutton.setBounds(0, 240, 150, 60);
//	 
	 this.add(Checkbutton);
	 this.add(Panbutton);
	 this.add(Inbutton);
	 this.add(Outbutton);
	 
 }
 
}
