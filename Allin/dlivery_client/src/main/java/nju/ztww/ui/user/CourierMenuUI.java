package nju.ztww.ui.user;


import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CourierMenuUI extends JPanel{
	
	JButton OrderInputButton = new JButton();
	JButton AcceptButton = new JButton();
	JButton CheckOrderButton = new JButton();
	JButton YourMessageButton = new JButton();
	JButton LogoutButton = new JButton();
	
	CourierMenuUI(){
		this.setLayout(null);
		ImageIcon OrderInput = new ImageIcon("photo/OrderInput.gif");
		ImageIcon Accept = new ImageIcon("photo/Accept.gif");
		ImageIcon CheckOrder = new ImageIcon("photo/CheckOrder.gif");
		ImageIcon YourMessage = new ImageIcon("photo/YourMessage.gif");
		ImageIcon Logout = new ImageIcon("photo/Logout.gif");
		
		this.setBorder(new javax.swing.border.TitledBorder(null, "",
				javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.DEFAULT_POSITION));
		
		
		OrderInputButton.setIcon(OrderInput);
		OrderInputButton.setBounds(0,60,209,58);
		
		AcceptButton.setIcon(Accept);
		AcceptButton.setBounds(0,118,209,58);
		
		CheckOrderButton.setIcon(CheckOrder);
		CheckOrderButton.setBounds(0,176,209,58);
		
		YourMessageButton.setIcon(YourMessage);
		YourMessageButton.setBounds(0,234,209,58);
		
		LogoutButton.setIcon(Logout);
		LogoutButton.setBounds(0,292,209,58);
		
		this.add(OrderInputButton);
		this.add(AcceptButton);
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