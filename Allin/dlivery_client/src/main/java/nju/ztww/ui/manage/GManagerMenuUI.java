package nju.ztww.ui.manage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import nju.ztww.ui.order.MyButton;

public class GManagerMenuUI extends JPanel{
	MyButton ViewFormsButton = new MyButton(0);
	MyButton CheckOrdersButton = new MyButton(1);	//审判单据
	MyButton ManageSalaryButton = new MyButton(2);
	MyButton ManageOrgaButton = new MyButton(3);
	MyButton CheckOrderButton = new MyButton(4);		//订单查询
	MyButton YourMessageButton = new MyButton(5);
	MyButton LogoutButton = new MyButton(6);
	
	GManagerMenuUI(){
		this.setBackground(new Color(155,122,90));
		this.setLayout(null);
		ImageIcon ViewForms = new ImageIcon("photo/ViewForms.png");
		ImageIcon CheckOrders = new ImageIcon("photo/CheckOrders.png");
		ImageIcon ManageSalary = new ImageIcon("photo/ManageSalary.png");
		ImageIcon ManageOrga = new ImageIcon("photo/ManageOrga.png");
		ImageIcon CheckOrder = new ImageIcon("photo/CheckOrder.png");
		ImageIcon YourMessage = new ImageIcon("photo/PersonInfo.png");
		ImageIcon Logout = new ImageIcon("photo/Logout.png");
		
		this.setBorder(new javax.swing.border.TitledBorder(null, "",
				javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.DEFAULT_POSITION));
		
		ViewFormsButton.setIcon(ViewForms);
//		ViewFormsButton.setBounds(0,60,209,58);
		
		CheckOrdersButton.setIcon(CheckOrders);
		
		ManageSalaryButton.setIcon(ManageSalary);
//		ManageSalaryButton.setBounds(0,176,209,58);
		
		ManageOrgaButton.setIcon(ManageOrga);
//		ManageOrgaButton.setBounds(0,234,209,58);
		
		CheckOrderButton.setIcon(CheckOrder);
//		CheckOrderButton.setBounds(0,292,209,58);
		
		YourMessageButton.setIcon(YourMessage);
//		YourMessageButton.setBounds(0,350,209,58);
		
		LogoutButton.setIcon(Logout);
//		LogoutButton.setBounds(0,408,209,58);
		
		this.add(ViewFormsButton);
		this.add(CheckOrdersButton);
		this.add(ManageSalaryButton);
		this.add(ManageOrgaButton);
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
