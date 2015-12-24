package nju.ztww.ui.commodity;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


import nju.ztww.ui.main.UserInfoUI;


import confligUI.MyButton;


public class StorageNavigationPanel extends JPanel {

	
//	MyButton Outbutton;//出库
//	MyButton Inbutton;//入库
//	MyButton Panbutton;//库存盘点
//	MyButton Checkbutton;//库存查看；
	
//	final ImageIcon In=new ImageIcon("photo/in.png");
//	final ImageIcon Out=new ImageIcon("photo/out.png");
//	final ImageIcon Check=new ImageIcon("photo/check.png");
//	final ImageIcon pan=new ImageIcon("photo/pan.png");
//	
//	
//  public StorageNavigationPanel() {
//	// TODO Auto-generated constructor stub
//	  this.setBackground(new Color(155,122,90));
//	  setup();
//	  setPosition();
//}
//  public void setup(){//初始化部件对象
	  	 
//	  Outbutton=new MyButton(3);
//	  Outbutton.setIcon(Out);
//	  Inbutton=new MyButton(2);
//	  Inbutton.setIcon(In);
//	  Panbutton=new MyButton(1);
//	  Panbutton.setIcon(pan);
//	  Checkbutton=new MyButton(0);
//	  Checkbutton.setIcon(Check);
//  }
// public void setPosition(){//设置位置
//	 this.setLayout(null);
//	
////	 Checkbutton.setBounds(0, 60, 150, 60);
////	 Panbutton.setBounds(0, 120, 150, 60);
////	 Inbutton.setBounds(0, 180, 150, 60);
////	 Outbutton.setBounds(0, 240, 150, 60);
////	 
//	 this.add(Checkbutton);
//	 this.add(Panbutton);
//	 this.add(Inbutton);
//	 this.add(Outbutton);
//	 this.add(LogoutButton);
//	 this.add(Tiaobutton);
//	 
// }
 
	MyButton Checkbutton;// 库存查看；
	MyButton Panbutton;// 库存盘点
	MyButton Inbutton;// 入库
	MyButton Outbutton;// 出库
	MyButton Tiaobutton;//库存调整
	MyButton YourMessageButton;
	MyButton CheckOrderButton;
	MyButton LogoutButton;//退出登录
	final ImageIcon In = new ImageIcon("photo/in.png");
	final ImageIcon Out = new ImageIcon("photo/out.png");
	final ImageIcon Check = new ImageIcon("photo/check.png");
	final ImageIcon pan = new ImageIcon("photo/pan.png");
	ImageIcon tiaozheng=new ImageIcon("photo/SeperateAdjust.png");
	ImageIcon yourMessage = new ImageIcon("photo/PersonInfo.png");
	ImageIcon checkOrder = new ImageIcon("photo/CheckOrder.png");
	ImageIcon Logout = new ImageIcon("photo/Logout.png");
	
	ImageIcon In2 = new ImageIcon("photo/in2.png");
	ImageIcon Out2 = new ImageIcon("photo/out2.png");
	ImageIcon Check2 = new ImageIcon("photo/check2.png");
	ImageIcon pan2 = new ImageIcon("photo/pan2.png");
	ImageIcon tiaozheng2=new ImageIcon("photo/SeperateAdjust2.png");
	ImageIcon yourMessage2 = new ImageIcon("photo/PersonInfo2.png");
	ImageIcon checkOrder2 = new ImageIcon("photo/CheckOrder2.png");
	
	int panel = 0;

	public StorageNavigationPanel() {

		// TODO Auto-generated constructor stub
		this.setBackground(new Color(155, 122, 90));
		setup();
		setPosition();
		
		Checkbutton.addActionListener(check);
		Panbutton.addActionListener(pandian);
		Inbutton.addActionListener(in);
		Outbutton.addActionListener(out);
		Tiaobutton.addActionListener(tiao);
		YourMessageButton.addActionListener(Info);
		CheckOrderButton.addActionListener(checkorder);
	}

	public void setup() {// 初始化部件对象
		
		  Tiaobutton=new MyButton(4);
		  Tiaobutton.setIcon(tiaozheng);
		Outbutton = new MyButton(3);
		Outbutton.setIcon(Out);
		Inbutton = new MyButton(2);
		Inbutton.setIcon(In);
		Panbutton = new MyButton(1);
		Panbutton.setIcon(pan);
		Checkbutton = new MyButton(0);
		Checkbutton.setIcon(Check2);
		
		YourMessageButton = new MyButton(5);
		YourMessageButton.setIcon(yourMessage);
		CheckOrderButton = new MyButton(6);
		CheckOrderButton.setIcon(checkOrder);
		 LogoutButton=new MyButton(7);
		  LogoutButton.setIcon(Logout);
	}

	public void setPosition() {// 设置位置
		this.setLayout(null);

		// Checkbutton.setBounds(0, 60, 150, 60);
		// Panbutton.setBounds(0, 120, 150, 60);
		// Inbutton.setBounds(0, 180, 150, 60);
		// Outbutton.setBounds(0, 240, 150, 60);
		//
		this.add(Checkbutton);
		this.add(Panbutton);
		this.add(Inbutton);
		this.add(Outbutton);
		this.add(LogoutButton);
		this.add(Tiaobutton);
		this.add(YourMessageButton);
		this.add(CheckOrderButton);
	}
	
	private void removeButton(int n){
		switch (n) {
		case 0:	Checkbutton.setIcon(Check);	break;
		case 1: Panbutton.setIcon(pan);	break;
		case 2:	Inbutton.setIcon(In);break;
		case 3: Outbutton.setIcon(Out);break;
		case 4: Tiaobutton.setIcon(tiaozheng);break;
		case 5: YourMessageButton.setIcon(yourMessage);break;
		case 6: CheckOrderButton.setIcon(checkOrder);break;
		default:
			break;
		}
	}

	ActionListener check = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			removeButton(panel);
			Checkbutton.setIcon(Check2);
			panel = 0;
			MyButton.type=0;
		}
	};
	
	ActionListener pandian = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			removeButton(panel);
			Panbutton.setIcon(pan2);
			panel = 1;
			MyButton.type=1;
		}
	};
	
	ActionListener in = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			removeButton(panel);
			Inbutton.setIcon(In2);
			panel = 2;
			MyButton.type=2;
		}
	};
	
	ActionListener out  = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			removeButton(panel);
			Outbutton.setIcon(Out2);
			panel = 3;
			MyButton.type=3;
		}
	};
     ActionListener tiao  = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			removeButton(panel);
			Tiaobutton.setIcon(tiaozheng2);
			panel = 4;
			MyButton.type=4;
		}
	};
	
	ActionListener Info = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			removeButton(panel);
			YourMessageButton.setIcon(yourMessage2);
			panel = 5;
			MyButton.type=5;
		}
	};
	
	ActionListener checkorder = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			removeButton(panel);
			CheckOrderButton.setIcon(checkOrder2);
			panel = 6;
			MyButton.type=6;
		}
	};

}
