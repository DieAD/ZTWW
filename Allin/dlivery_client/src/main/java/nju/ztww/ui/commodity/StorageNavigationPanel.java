package nju.ztww.ui.commodity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StorageNavigationPanel extends JPanel {
	JButton IDbutton;//ID
	JButton Outbutton;//出库
	JButton Inbutton;//入库
	JButton Panbutton;//库存盘点
	JButton Checkbutton;//库存查看；
	InofStoragePanel inofStoragePanel;
	OutofStoragePanel outofstoragePanl;
  public StorageNavigationPanel() {
	// TODO Auto-generated constructor stub
	  
	  setup();
	  setPosition();
}
  public void setup(){//初始化部件对象
	  IDbutton=new JButton("ID");
	  Outbutton=new JButton("出库");
	  Inbutton=new JButton("入库");
	  Panbutton=new JButton("库存盘点");
	  Checkbutton=new JButton("库存查看");
  }
 public void setPosition(){//设置位置
	 this.setLayout(null);
	 IDbutton.setBounds(0, 0, 150, 100);
	 Checkbutton.setBounds(0, 100, 150, 60);
	 Panbutton.setBounds(0, 160, 150, 60);
	 Inbutton.setBounds(0, 220, 150, 60);
	 Outbutton.setBounds(0, 280, 150, 60);
	 this.add(IDbutton);
	 this.add(Checkbutton);
	 this.add(Panbutton);
	 this.add(Inbutton);
	 this.add(Outbutton);
	 
 }
 public void setListener(){
	
	 
 }
}
