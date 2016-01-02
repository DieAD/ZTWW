package nju.ztww.ui.user;
/**
 * 田琦
 * 
 * */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import confligUI.MyButton;
import nju.ztww.ui.main.Listener_Return;

public class BusinessUI extends JPanel{
	
	MyButton CarLoadingButton=new MyButton(0);
	MyButton receiveAndSendButton=new MyButton(1);
	MyButton ReceiveBillButton=new MyButton(2);
	MyButton CarManageButton=new MyButton(3);
	MyButton DriverManageButton=new MyButton(4);
	MyButton SendButton=new MyButton(5);
	MyButton YourMessageButton=new MyButton(6);
	MyButton CheckOrderButton = new MyButton(7);
	MyButton LogoutButton  = new MyButton(8);
	
	ImageIcon CarLoading=new ImageIcon("photo/CarLoading.png");
	ImageIcon AcceptGood=new ImageIcon("photo/AcceptGood.png");
	ImageIcon ReceiveBill=new ImageIcon("photo/ReceiveBill.png");
	ImageIcon CarManage=new ImageIcon("photo/CarManage.png");
	ImageIcon DriverManage=new ImageIcon("photo/DriverManage.png");
	ImageIcon YourMessage=new ImageIcon("photo/PersonInfo.png");
	ImageIcon CheckOrder = new ImageIcon("photo/CheckOrder.png");
	ImageIcon Deliver = new ImageIcon("photo/SendGood.png");
	ImageIcon Logout = new ImageIcon("photo/Logout.png");
	
	ImageIcon CarLoading2=new ImageIcon("photo/CarLoading2.png");
	ImageIcon AcceptGood2=new ImageIcon("photo/AcceptGood2.png");
	ImageIcon ReceiveBill2=new ImageIcon("photo/ReceiveBill2.png");
	ImageIcon CarManage2=new ImageIcon("photo/CarManage2.png");
	ImageIcon DriverManage2=new ImageIcon("photo/DriverManage2.png");
	ImageIcon YourMessage2=new ImageIcon("photo/PersonInfo2.png");
	ImageIcon Deliver2 = new ImageIcon("photo/SendGood2.png");
	ImageIcon CheckOrder2 = new ImageIcon("photo/CheckOrder2.png");
	int panel = 0;
	public BusinessUI(){
		this.setBackground(new Color(155,122,90));
		
		
		this.setBorder(new javax.swing.border.TitledBorder(null, "",
				javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.DEFAULT_POSITION));
				
		this.setLayout(null);
		CarLoadingButton.setIcon(CarLoading2);
//		CarLoadingButton.setBounds(0,60,209,58);
		CarLoadingButton.addActionListener(new ActionListener(){


			public void actionPerformed(ActionEvent e) {

				TextBussinessUI.changePanel(1);
				removeButton(panel);
				CarLoadingButton.setIcon(CarLoading2);
				panel = 0;
				MyButton.type=0;
			}});
		
		receiveAndSendButton.setIcon(AcceptGood);
//		receiveAndSendButton.setBounds(0,118,209,58);
		receiveAndSendButton.addActionListener(new ActionListener(){


					public void actionPerformed(ActionEvent e) {

						TextBussinessUI.changePanel(2);
						removeButton(panel);
						receiveAndSendButton.setIcon(AcceptGood2);
						panel = 1;
						MyButton.type=1;
					}});
		
		ReceiveBillButton.setIcon(ReceiveBill);
//		ReceiveBillButton.setBounds(0,176,209,58);
		ReceiveBillButton.addActionListener(new ActionListener(){


			public void actionPerformed(ActionEvent e) {

				TextBussinessUI.changePanel(3);
				removeButton(panel);
				ReceiveBillButton.setIcon(ReceiveBill2);
				panel = 2;
				MyButton.type=2;
			}});
		
		
		CarManageButton.setIcon(CarManage);
//		CarManageButton.setBounds(0,234,209,58);
		CarManageButton.addActionListener(new ActionListener(){


			public void actionPerformed(ActionEvent e) {

				TextBussinessUI.changePanel(4);
				removeButton(panel);
				CarManageButton.setIcon(CarManage2);
				panel = 3;
				MyButton.type=3;
			}});
		
		DriverManageButton.setIcon(DriverManage);
//		DriverManageButton.setBounds(0,292,209,58);
		DriverManageButton.addActionListener(new ActionListener(){


			public void actionPerformed(ActionEvent e) {

				TextBussinessUI.changePanel(5);
				removeButton(panel);
				DriverManageButton.setIcon(DriverManage2);
				panel = 4;
				MyButton.type=4;
			}});
		
		YourMessageButton.setIcon(YourMessage);
//		YourMessageButton.setBounds(0,350,209,58);
		YourMessageButton.addActionListener(new ActionListener(){



			public void actionPerformed(ActionEvent e) {


				TextBussinessUI.personalMessagePanel =new PersonalMesageUI();
//				TextBussinessUI.personalMessagePanel.setBounds(210,60,690,480);
				TextBussinessUI.changePanel(6);
				removeButton(panel);
				YourMessageButton.setIcon(YourMessage2);
				panel = 6;
				MyButton.type=6;
			}});
		
		SendButton.setIcon(Deliver);
		SendButton.addActionListener(new ActionListener(){


			public void actionPerformed(ActionEvent e) {

				TextBussinessUI.changePanel(7);
				removeButton(panel);
				SendButton.setIcon(Deliver2);
				panel = 5;
				MyButton.type=5;
			}});
	
		CheckOrderButton.setIcon(CheckOrder);
		CheckOrderButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				TextBussinessUI.changePanel(8);
				removeButton(panel);
				CheckOrderButton.setIcon(CheckOrder2);
				panel = 7;
				MyButton.type=7;
			}
		});
		
		LogoutButton.setIcon(Logout);
		LogoutButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Listener_Return re = new Listener_Return();
				re.actionPerformed(e);
			}
		});
		
		
		this.add(CarLoadingButton);
		this.add(receiveAndSendButton);
		this.add(ReceiveBillButton);
		this.add(CarManageButton);
		this.add(DriverManageButton);
		this.add(YourMessageButton);
		this.add(SendButton);
		this.add(CheckOrderButton);
		this.add(LogoutButton);
		//this.repaint();
		
	}

	
	
	private void removeButton(int n){

		switch (n){
		case 0:CarLoadingButton.setIcon(CarLoading);break;
		case 1:receiveAndSendButton.setIcon(AcceptGood);break;
		case 2:ReceiveBillButton.setIcon(ReceiveBill);break;
		case 3:CarManageButton.setIcon(CarManage);break;
		case 4:DriverManageButton.setIcon(DriverManage);break;
		case 5:SendButton.setIcon(Deliver);break;
		case 6:YourMessageButton.setIcon(YourMessage);break;
		case 7:CheckOrderButton.setIcon(CheckOrder);break;
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
