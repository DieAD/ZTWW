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
	
	public BusinessUI(){
		this.setBackground(new Color(155,122,90));
		ImageIcon CarLoading=new ImageIcon("photo/CarLoading.png");
		ImageIcon receiveAndSend=new ImageIcon("photo/receiveAndSend.png");
		ImageIcon ReceiveBill=new ImageIcon("photo/ReceiveBill.png");
		ImageIcon CarManage=new ImageIcon("photo/CarManage.png");
		ImageIcon DriverManage=new ImageIcon("photo/DriverManage.png");
		ImageIcon YourMessage=new ImageIcon("photo/PersonInfo.png");
		
		this.setBorder(new javax.swing.border.TitledBorder(null, "",
				javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.DEFAULT_POSITION));
				
		this.setLayout(null);
		CarLoadingButton.setIcon(CarLoading);
//		CarLoadingButton.setBounds(0,60,209,58);
		CarLoadingButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				TextBussinessUI.changePanel(1);
			}});
		
		receiveAndSendButton.setIcon(receiveAndSend);
//		receiveAndSendButton.setBounds(0,118,209,58);
		receiveAndSendButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						TextBussinessUI.changePanel(2);
					}});
		
		ReceiveBillButton.setIcon(ReceiveBill);
//		ReceiveBillButton.setBounds(0,176,209,58);
		ReceiveBillButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				TextBussinessUI.changePanel(3);
			}});
		
		
		CarManageButton.setIcon(CarManage);
//		CarManageButton.setBounds(0,234,209,58);
		CarManageButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				TextBussinessUI.changePanel(4);
			}});
		
		DriverManageButton.setIcon(DriverManage);
//		DriverManageButton.setBounds(0,292,209,58);
		DriverManageButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				TextBussinessUI.changePanel(5);
			}});
		
		YourMessageButton.setIcon(YourMessage);
//		YourMessageButton.setBounds(0,350,209,58);
		YourMessageButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				TextBussinessUI.personalMessagePanel =new PersonalMesageUI();
//				TextBussinessUI.personalMessagePanel.setBounds(210,60,690,480);
				TextBussinessUI.changePanel(6);
			}});
	
		this.add(CarLoadingButton);
		this.add(receiveAndSendButton);
		this.add(ReceiveBillButton);
		this.add(CarManageButton);
		this.add(DriverManageButton);
		this.add(YourMessageButton);
		//this.repaint();
		
	}

//	public void paintComponent(Graphics g){
//		super.paintComponent(g);
//		
//		Image background=new ImageIcon("photo/background.gif").getImage();
//		g.drawImage(background, 0,0,null);
//		
//	}
	
}
