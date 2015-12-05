package nju.ztww.ui.order;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CourierMenuUI extends JPanel{
	
	MyButton OrderInputButton = new MyButton();
	MyButton AcceptButton = new MyButton();
	MyButton CheckOrderButton = new MyButton();
	MyButton YourMessageButton = new MyButton();
	MyButton LogoutButton = new MyButton();
	
	CourierMenuUI(){
		
		this.setLayout(null);
		this.setBackground(new Color(155,122,90));
		ImageIcon OrderInput = new ImageIcon("photo/OrderInput.png");
		ImageIcon Accept = new ImageIcon("photo/Accept.png");
		ImageIcon CheckOrder = new ImageIcon("photo/CheckOrder.png");
		ImageIcon YourMessage = new ImageIcon("photo/PersonInfo.png");
		ImageIcon Logout = new ImageIcon("photo/Logout.png");
		
		this.setBorder(new javax.swing.border.TitledBorder(null, "",
				javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.DEFAULT_POSITION));
		
		
		OrderInputButton.setIcon(OrderInput);
		OrderInputButton.setBounds(0,0,150,40); //——by zyz 2015/12/3
		OrderInputButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TestCourierUI.changePanel(1);
			}
		});
		
		AcceptButton.setIcon(Accept);
		AcceptButton.setBounds(0,40,150,40); //——by zyz 2015/12/3
		AcceptButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TestCourierUI.changePanel(2);
			}
		});
		
		CheckOrderButton.setIcon(CheckOrder);
		CheckOrderButton.setBounds(0,80,150,40); //——by zyz 2015/12/3
		CheckOrderButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TestCourierUI.changePanel(3);
			}
		});
		
		YourMessageButton.setIcon(YourMessage);
		YourMessageButton.setBounds(0,120,150,40);	//——by zyz 2015/12/3
		YourMessageButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TestCourierUI.changePanel(4);
			}
		});
		
		LogoutButton.setIcon(Logout);
		LogoutButton.setBounds(0,160,150,40);	//——by zyz 2015/12/3
		
		this.add(OrderInputButton);
		this.add(AcceptButton);
		this.add(CheckOrderButton);
		this.add(YourMessageButton);
		this.add(LogoutButton);
	}
	
//	public void paintComponent(Graphics g){
//		super.paintComponent(g);
//		
//		Image background=new ImageIcon("photo/background.gif").getImage();
//		g.drawImage(background, 0,0,null);
//		
//	}
}