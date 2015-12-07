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

import nju.ztww.ui.order.MyButton;
import nju.ztww.ui.user.TextBussinessUI;

public class ManageUI extends JPanel{
	
	MyButton UserManageButton=new MyButton(0);
	
	public ManageUI(){
		
		ImageIcon PowerManage=new ImageIcon("photo/PowerManage.gif");
		ImageIcon UserManage=new ImageIcon("photo/ManaUser.png");
		
		this.setBorder(new javax.swing.border.TitledBorder(null, "",
				javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.DEFAULT_POSITION));
		
		this.setLayout(null);
		this.setBackground(new Color(155,122,90));
		UserManageButton.setIcon(UserManage);
//		UserManageButton.setBounds(0,60,209,58);
		UserManageButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
			}});
		
		this.add(UserManageButton);

	}
	
//	public void paintComponent(Graphics g){
//		super.paintComponent(g);
//		
//		Image background=new ImageIcon("photo/background.gif").getImage();
//		g.drawImage(background, 0,0,null);
//		
//	}

}
