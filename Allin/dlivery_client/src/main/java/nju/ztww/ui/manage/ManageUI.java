package nju.ztww.ui.manage;

/**
 * 田琦
 * 
 * */

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import nju.ztww.ui.user.TextBussinessUI;

public class ManageUI extends JPanel{
	
	JButton UserManageButton=new JButton();
	
	public ManageUI(){
		
		ImageIcon PowerManage=new ImageIcon("photo/PowerManage.gif");
		ImageIcon UserManage=new ImageIcon("photo/UserManage.gif");
		
		this.setBorder(new javax.swing.border.TitledBorder(null, "",
				javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.DEFAULT_POSITION));
		
		this.setLayout(null);
		
		UserManageButton.setIcon(UserManage);
		UserManageButton.setBounds(0,60,209,58);
		UserManageButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
			}});
		
		this.add(UserManageButton);

	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Image background=new ImageIcon("photo/background.gif").getImage();
		g.drawImage(background, 0,0,null);
		
	}

}
