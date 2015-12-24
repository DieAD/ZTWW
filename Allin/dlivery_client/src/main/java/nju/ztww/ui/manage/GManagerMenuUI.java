package nju.ztww.ui.manage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import confligUI.MyButton;
import nju.ztww.ui.main.Listener_Return;

public class GManagerMenuUI extends JPanel{
	MyButton ViewFormsButton = new MyButton(0);
	MyButton CheckOrdersButton = new MyButton(1);	//审判单据
	MyButton ManageSalaryButton = new MyButton(2);
	MyButton ManageOrgaButton = new MyButton(3);
	MyButton CheckOrderButton = new MyButton(4);		//订单查询
	MyButton YourMessageButton = new MyButton(5);
	MyButton LogoutButton = new MyButton(6);
	
	ImageIcon ViewForms = new ImageIcon("photo/ViewForms.png");
	ImageIcon CheckOrders = new ImageIcon("photo/CheckOrders.png");
	ImageIcon ManageSalary = new ImageIcon("photo/ManageSalary.png");
	ImageIcon ManageOrga = new ImageIcon("photo/ManageOrga.png");
	ImageIcon CheckOrder = new ImageIcon("photo/CheckOrder.png");
	ImageIcon YourMessage = new ImageIcon("photo/PersonInfo.png");
	ImageIcon Logout = new ImageIcon("photo/Logout.png");
	ImageIcon ViewForms2 = new ImageIcon("photo/ViewForms2.png");
	ImageIcon CheckOrders2 = new ImageIcon("photo/CheckOrders2.png");
	ImageIcon ManageSalary2 = new ImageIcon("photo/ManageSalary2.png");
	ImageIcon ManageOrga2 = new ImageIcon("photo/ManageOrga2.png");
	ImageIcon CheckOrder2 = new ImageIcon("photo/CheckOrder2.png");
	ImageIcon YourMessage2 = new ImageIcon("photo/PersonInfo2.png");
	int panel = 0;
	GManagerMenuUI(){

		this.setBackground(new Color(155,122,90));
		this.setLayout(null);
		
		
		this.setBorder(new javax.swing.border.TitledBorder(null, "",
				javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.DEFAULT_POSITION));
		
		ViewFormsButton.setIcon(ViewForms);
		ViewFormsButton.addActionListener(viewForm);
//		ViewFormsButton.setBounds(0,60,209,58);
		
		CheckOrdersButton.setIcon(CheckOrders);
		CheckOrdersButton.addActionListener(checkOrders);
		
		
		ManageSalaryButton.setIcon(ManageSalary);
		ManageSalaryButton.addActionListener(manageSalary);
//		ManageSalaryButton.setBounds(0,176,209,58);
		
		ManageOrgaButton.setIcon(ManageOrga);
		ManageOrgaButton.addActionListener(manageOrga);
//		ManageOrgaButton.setBounds(0,234,209,58);
		
		CheckOrderButton.setIcon(CheckOrder);
		CheckOrderButton.addActionListener(checkOrder);
//		CheckOrderButton.setBounds(0,292,209,58);
		
		YourMessageButton.setIcon(YourMessage);
		YourMessageButton.addActionListener(yourMessage);
//		YourMessageButton.setBounds(0,350,209,58);
		
		LogoutButton.setIcon(Logout);
//		LogoutButton.setBounds(0,408,209,58);
		LogoutButton.addActionListener(logout);
		
		this.add(ViewFormsButton);
		this.add(CheckOrdersButton);
		this.add(ManageSalaryButton);
		this.add(ManageOrgaButton);
		this.add(CheckOrderButton);
		this.add(YourMessageButton);
		this.add(LogoutButton);
	}
	

	
	ActionListener viewForm = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			removeButton(panel);
			ViewFormsButton.setIcon(ViewForms2);
			panel = 0;
			MyButton.type=0;
		}
	};
	
	ActionListener checkOrders = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			removeButton(panel);
			CheckOrdersButton.setIcon(CheckOrders2);
			panel = 1;
			MyButton.type=1;
		}
	};
	
	ActionListener manageSalary = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			removeButton(panel);
			ManageSalaryButton.setIcon(ManageSalary2);
			panel = 2;
			MyButton.type=2;
		}
	};
	
	ActionListener manageOrga = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			removeButton(panel);
			ManageOrgaButton.setIcon(ManageOrga2);
			panel = 3;
			MyButton.type=3;
		}
	};
	
	ActionListener checkOrder = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			removeButton(panel);
			CheckOrderButton.setIcon(CheckOrder2);
			panel = 4;
			MyButton.type=4;
		}
	};
	
	ActionListener yourMessage = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			removeButton(panel);
			YourMessageButton.setIcon(YourMessage2);
			panel = 5;
			MyButton.type=5;
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
		switch (n) {
		case 0: ViewFormsButton.setIcon(ViewForms);break;
		case 1: CheckOrdersButton.setIcon(CheckOrders);break;
		case 2: ManageSalaryButton.setIcon(ManageSalary);break;
		case 3: ManageOrgaButton.setIcon(ManageOrga);break;
		case 4: CheckOrderButton.setIcon(CheckOrder);break;
		case 5: YourMessageButton.setIcon(YourMessage);break;
		default:
			break;
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
