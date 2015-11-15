package nju.ztww.ui.commodity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StorageNavigationPanel extends JPanel {
	
	JButton Outbutton;//出库
	JButton Inbutton;//入库
	JButton Panbutton;//库存盘点
	JButton Checkbutton;//库存查看；
	final ImageIcon In=new ImageIcon("photo/in.jpg");
	final ImageIcon Out=new ImageIcon("photo/out.jpg");
	final ImageIcon Check=new ImageIcon("photo/check.jpg");
	final ImageIcon pan=new ImageIcon("photo/pan.jpg");
  public StorageNavigationPanel() {
	// TODO Auto-generated constructor stub
	  
	  setup();
	  setPosition();
}
  public void setup(){//初始化部件对象
	  
	  
	  Outbutton=new JButton();
	  Outbutton.setIcon(Out);
	  Inbutton=new JButton();
	  Inbutton.setIcon(In);
	  Panbutton=new JButton();
	  Panbutton.setIcon(pan);
	  Checkbutton=new JButton();
	  Checkbutton.setIcon(Check);
  }
 public void setPosition(){//设置位置
	 this.setLayout(null);
	
	 Checkbutton.setBounds(0, 60, 150, 60);
	 Panbutton.setBounds(0, 120, 150, 60);
	 Inbutton.setBounds(0, 180, 150, 60);
	 Outbutton.setBounds(0, 240, 150, 60);
	 
	 this.add(Checkbutton);
	 this.add(Panbutton);
	 this.add(Inbutton);
	 this.add(Outbutton);
	 
 }
 
}
