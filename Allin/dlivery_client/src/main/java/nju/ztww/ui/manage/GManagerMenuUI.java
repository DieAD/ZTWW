package nju.ztww.ui.manage;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GManagerMenuUI extends JPanel{
	JButton ViewFormsButton = new JButton();
	JButton CheckOrdersButton = new JButton();	//审判单据
	JButton ManageSalaryButton = new JButton();
	JButton ManageOrgaButton = new JButton();
	JButton CheckOrderButton = new JButton();		//订单查询
	JButton YourMessageButton = new JButton();
	JButton LogoutButton = new JButton();
	
	GManagerMenuUI(){
		this.setLayout(null);
		ImageIcon ViewForms = new ImageIcon("photo/ViewForms.gif");
		ImageIcon CheckOrders = new ImageIcon("photo/CheckOrders.gif");
		ImageIcon ManageSalary = new ImageIcon("photo/ManageSalary.gif");
		ImageIcon ManageOrga = new ImageIcon("photo/ManageOrga.gif");
		ImageIcon CheckOrder = new ImageIcon("photo/CheckOrder.gif");
		ImageIcon YourMessage = new ImageIcon("photo/YourMessage.gif");
		ImageIcon Logout = new ImageIcon("photo/Logout.gif");
		
		this.setBorder(new javax.swing.border.TitledBorder(null, "",
				javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.DEFAULT_POSITION));
		
		ViewFormsButton.setIcon(ViewForms);
		ViewFormsButton.setBounds(0,60,209,58);
		
		CheckOrdersButton.setIcon(CheckOrders);
		CheckOrdersButton.setBounds(0,118,209,58);
		
		ManageSalaryButton.setIcon(ManageSalary);
		ManageSalaryButton.setBounds(0,176,209,58);
		
		ManageOrgaButton.setIcon(ManageOrga);
		ManageOrgaButton.setBounds(0,234,209,58);
		
		CheckOrderButton.setIcon(CheckOrder);
		CheckOrderButton.setBounds(0,292,209,58);
		
		YourMessageButton.setIcon(YourMessage);
		YourMessageButton.setBounds(0,350,209,58);
		
		LogoutButton.setIcon(Logout);
		LogoutButton.setBounds(0,408,209,58);
		
		this.add(ViewFormsButton);
		this.add(CheckOrdersButton);
		this.add(ManageSalaryButton);
		this.add(ManageOrgaButton);
		this.add(CheckOrderButton);
		this.add(YourMessageButton);
		this.add(LogoutButton);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Image background=new ImageIcon("photo/background.gif").getImage();
		g.drawImage(background, 0,0,null);
		
	}
}
