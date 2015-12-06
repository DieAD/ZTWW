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

import nju.ztww.ui.order.MyButton;

public class BusinessUI extends JPanel{
	
	MyButton CarLoadingButton=new MyButton(0);
	MyButton receiveAndSendButton=new MyButton(1);
	MyButton ReceiveBillButton=new MyButton(2);
	MyButton CarManageButton=new MyButton(3);
	MyButton DriverManageButton=new MyButton(4);
	MyButton YourMessageButton=new MyButton(5);
	
	ImageIcon CarLoading=new ImageIcon("photo/CarLoading.png");
	ImageIcon ReceiveAndSend=new ImageIcon("photo/receiveAndSend.png");
	ImageIcon ReceiveBill=new ImageIcon("photo/ReceiveBill.png");
	ImageIcon CarManage=new ImageIcon("photo/CarManage.png");
	ImageIcon DriverManage=new ImageIcon("photo/DriverManage.png");
	ImageIcon YourMessage=new ImageIcon("photo/PersonInfo.png");
	ImageIcon CarLoading2=new ImageIcon("photo/CarLoading2.png");
	ImageIcon ReceiveAndSend2=new ImageIcon("photo/receiveAndSend2.png");
	ImageIcon ReceiveBill2=new ImageIcon("photo/ReceiveBill2.png");
	ImageIcon CarManage2=new ImageIcon("photo/CarManage2.png");
	ImageIcon DriverManage2=new ImageIcon("photo/DriverManage2.png");
	ImageIcon YourMessage2=new ImageIcon("photo/PersonInfo2.png");
	int panel = 0;
	public BusinessUI(){





		this.setBackground(new Color(155,122,90));
		
		
		this.setBorder(new javax.swing.border.TitledBorder(null, "",
				javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.DEFAULT_POSITION));
				
		this.setLayout(null);
		CarLoadingButton.setIcon(CarLoading);
//		CarLoadingButton.setBounds(0,60,209,58);
		CarLoadingButton.addActionListener(new ActionListener(){


			public void actionPerformed(ActionEvent e) {

				TextBussinessUI.changePanel(1);
				removeButton(panel);
				CarLoadingButton.setIcon(CarLoading2);
				panel = 0;
			}});
		
		receiveAndSendButton.setIcon(ReceiveAndSend);
//		receiveAndSendButton.setBounds(0,118,209,58);
		receiveAndSendButton.addActionListener(new ActionListener(){


					public void actionPerformed(ActionEvent e) {

						TextBussinessUI.changePanel(2);
						removeButton(panel);
						receiveAndSendButton.setIcon(ReceiveAndSend2);
						panel = 1;
					}});
		
		ReceiveBillButton.setIcon(ReceiveBill);
//		ReceiveBillButton.setBounds(0,176,209,58);
		ReceiveBillButton.addActionListener(new ActionListener(){


			public void actionPerformed(ActionEvent e) {

				TextBussinessUI.changePanel(3);
				removeButton(panel);
				ReceiveBillButton.setIcon(ReceiveBill2);
				panel = 2;
			}});
		
		
		CarManageButton.setIcon(CarManage);
//		CarManageButton.setBounds(0,234,209,58);
		CarManageButton.addActionListener(new ActionListener(){


			public void actionPerformed(ActionEvent e) {

				TextBussinessUI.changePanel(4);
				removeButton(panel);
				CarManageButton.setIcon(CarManage2);
				panel = 3;
			}});
		
		DriverManageButton.setIcon(DriverManage);
//		DriverManageButton.setBounds(0,292,209,58);
		DriverManageButton.addActionListener(new ActionListener(){


			public void actionPerformed(ActionEvent e) {

				TextBussinessUI.changePanel(5);
				removeButton(panel);
				DriverManageButton.setIcon(DriverManage2);
				panel = 4;
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
				panel = 5;
			}});
	
		this.add(CarLoadingButton);
		this.add(receiveAndSendButton);
		this.add(ReceiveBillButton);
		this.add(CarManageButton);
		this.add(DriverManageButton);
		this.add(YourMessageButton);
		//this.repaint();
		
	}

	
	
	private void removeButton(int n){



		switch (n){
		case 0:CarLoadingButton.setIcon(CarLoading);break;
		case 1:receiveAndSendButton.setIcon(ReceiveAndSend);break;
		case 2:ReceiveBillButton.setIcon(ReceiveBill);break;
		case 3:CarManageButton.setIcon(CarManage);break;
		case 4:DriverManageButton.setIcon(DriverManage);break;
		case 5:YourMessageButton.setIcon(YourMessage);break;
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
