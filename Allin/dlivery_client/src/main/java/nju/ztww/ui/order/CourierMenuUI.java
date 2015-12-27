package nju.ztww.ui.order;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import confligUI.MyButton;
import nju.ztww.ui.main.Listener_Return;

public class CourierMenuUI extends JPanel{
	
	MyButton OrderInputButton = new MyButton(0);
	MyButton AcceptButton = new MyButton(1);
	MyButton CheckOrderButton = new MyButton(2);
	MyButton YourMessageButton = new MyButton(3);
	MyButton LogoutButton = new MyButton(4);
	ImageIcon OrderInput = new ImageIcon("photo/OrderInput.png");
	ImageIcon Accept = new ImageIcon("photo/Accept.png");
	ImageIcon CheckOrder = new ImageIcon("photo/CheckOrder.png");
	ImageIcon YourMessage = new ImageIcon("photo/PersonInfo.png");
	ImageIcon Logout = new ImageIcon("photo/Logout.png");
	ImageIcon OrderInput2 = new ImageIcon("photo/OrderInput2.png");
	ImageIcon Accept2 = new ImageIcon("photo/Accept2.png");
	ImageIcon CheckOrder2 = new ImageIcon("photo/CheckOrder2.png");
	ImageIcon YourMessage2 = new ImageIcon("photo/PersonInfo2.png");
	
	int panel = 1;
	
	CourierMenuUI(){



		
		this.setLayout(null);
		this.setBackground(new Color(155,122,90));
		
		
		this.setBorder(new javax.swing.border.TitledBorder(null, "",
				javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.DEFAULT_POSITION));
		
		
		OrderInputButton.setIcon(OrderInput2);
//		OrderInputButton.setBounds(0,0,150,40); //——by zyz 2015/12/3
		OrderInputButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				TestCourierUI.changePanel(1);
				removeButton(panel);
				OrderInputButton.setIcon(OrderInput2);
				panel = 0;
				MyButton.type=0;
			}
		});
		
		AcceptButton.setIcon(Accept);
//		AcceptButton.setBounds(0,40,150,40); //——by zyz 2015/12/3
		AcceptButton.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				TestCourierUI.changePanel(2);
				removeButton(panel);
				AcceptButton.setIcon(Accept2);
				panel = 1;
				MyButton.type=1;
			}
		});
		
		CheckOrderButton.setIcon(CheckOrder);
//		CheckOrderButton.setBounds(0,80,150,40); //——by zyz 2015/12/3
		CheckOrderButton.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				TestCourierUI.changePanel(3);
				removeButton(panel);
				CheckOrderButton.setIcon(CheckOrder2);
				panel = 2;
				MyButton.type=2;
			}
		});
		
		YourMessageButton.setIcon(YourMessage);
//		YourMessageButton.setBounds(0,120,150,40);	//——by zyz 2015/12/3
		YourMessageButton.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				TestCourierUI.changePanel(4);
				removeButton(panel);
				YourMessageButton.setIcon(YourMessage2);
				panel = 3;
				MyButton.type=3;
			}
		});
		
		LogoutButton.setIcon(Logout);
		LogoutButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Listener_Return returnPanel = new Listener_Return();
				returnPanel.actionPerformed(e);
			}
		});
//		LogoutButton.setBounds(0,160,150,40);	//——by zyz 2015/12/3
		
		this.add(OrderInputButton);
		this.add(AcceptButton);
		this.add(CheckOrderButton);
		this.add(YourMessageButton);
		this.add(LogoutButton);
	}
	

	private void removeButton(int i){

		switch (i){
		case 0:OrderInputButton.setIcon(OrderInput);break;
		case 1:AcceptButton.setIcon(Accept);break;
		case 2:CheckOrderButton.setIcon(CheckOrder);break;
		case 3:YourMessageButton.setIcon(YourMessage);break;
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