package nju.ztww.ui.commodity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StorageNavigationPanel extends JPanel {
	JButton IDbutton;//ID
	JButton Outbutton;//出库
	JButton Inbutton;//入库
	JButton Panbutton;//库存盘点
	JButton Checkbutton;//库存查看；
	final ImageIcon In=new ImageIcon("photo/In.jpg");
	final ImageIcon Out=new ImageIcon("photo/Out.jpg");
	final ImageIcon Check=new ImageIcon("photo/check.jpg");
	final ImageIcon pan=new ImageIcon("photo/pan.jpg");
  public StorageNavigationPanel() {
	// TODO Auto-generated constructor stub
	  
	  setup();
	  setPosition();
}
  public void setup(){//初始化部件对象
	  IDbutton=new JButton("ID");
	  
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
	 IDbutton.setBounds(0, 0, 150, 100);
	 Checkbutton.setBounds(0, 100, 150, 80);
	 Panbutton.setBounds(0, 180, 150, 80);
	 Inbutton.setBounds(0, 260, 150, 80);
	 Outbutton.setBounds(0, 340, 150, 80);
	 this.add(IDbutton);
	 this.add(Checkbutton);
	 this.add(Panbutton);
	 this.add(Inbutton);
	 this.add(Outbutton);
	 
 }
 
}
