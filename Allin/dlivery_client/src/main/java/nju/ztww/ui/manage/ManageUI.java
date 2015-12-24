package nju.ztww.ui.manage;

/**
 * 田琦
 * nevigation
 * */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import confligUI.MyButton;
import nju.ztww.ui.main.Listener_Return;
import nju.ztww.ui.user.TextBussinessUI;

public class ManageUI extends JPanel{
	
	MyButton UserManageButton=new MyButton(0);
	MyButton YourMessageButton = new MyButton(1);
	MyButton CheckOrderButton = new MyButton(2);
	MyButton LogoutButton = new MyButton(3);
	ImageIcon UserManage=new ImageIcon("photo/ManaUser.png");
	ImageIcon YourMessage = new ImageIcon("photo/PersonInfo.png");
	ImageIcon CheckOrder = new ImageIcon("photo/CheckOrder.png");
	ImageIcon UserManage2=new ImageIcon("photo/ManaUser2.png");
	ImageIcon YourMessage2 = new ImageIcon("photo/PersonInfo2.png");
	ImageIcon CheckOrder2 = new ImageIcon("photo/CheckOrder2.png");
	ImageIcon Logout = new ImageIcon("photo/Logout.png");
	int panel = 0;
	
	public ManageUI(){
		
		ImageIcon PowerManage=new ImageIcon("photo/PowerManage.gif");
		
		
		
		this.setBorder(new javax.swing.border.TitledBorder(null, "",
				javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.DEFAULT_POSITION));
		
		this.setLayout(null);
		this.setBackground(new Color(155,122,90));
		UserManageButton.setIcon(UserManage2);
//		UserManageButton.setBounds(0,60,209,58);
		YourMessageButton.setIcon(YourMessage);
		CheckOrderButton.setIcon(CheckOrder);
		LogoutButton.setIcon(Logout);
		UserManageButton.addActionListener(user);
		YourMessageButton.addActionListener(info);
		CheckOrderButton.addActionListener(check);
		LogoutButton.addActionListener(logout);
		this.add(UserManageButton);
		this.add(CheckOrderButton);
		this.add(YourMessageButton);
		this.add(LogoutButton);
	}
	
	
	ActionListener user = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			removeButton(panel);
			UserManageButton.setIcon(UserManage2);
			panel = 0;
			MyButton.type=0;
		}
	};

	ActionListener info = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			removeButton(panel);
			YourMessageButton.setIcon(YourMessage2);
			panel = 1;
			MyButton.type=1;
		}
	};
	
	ActionListener check  = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			removeButton(panel);
			CheckOrderButton.setIcon(CheckOrder2);
			panel = 2;
			MyButton.type=2;
		}
	};
	
	ActionListener logout = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Listener_Return re = new Listener_Return();
			re.actionPerformed(e);
		}
	};
	private void removeButton(int n){
		switch(n){
		case 0:UserManageButton.setIcon(UserManage);
		case 1:YourMessageButton.setIcon(YourMessage);
		case 2:CheckOrderButton.setIcon(CheckOrder);
		}
	}
//	public void paintComponent(Graphics g){
//		super.paintComponent(g);
//		
//		Image background=new ImageIcon("photo/background.gif").getImage();
//		g.drawImage(background, 0,0,null);
//		
//	}

}
