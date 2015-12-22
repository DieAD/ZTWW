package nju.ztww.ui.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import confligUI.MyLabel;

public class UserInfoUI extends JPanel{
	public static JTextArea USERID = new JTextArea();
	
	public UserInfoUI(String userID){
		this.setBounds(0, 0, 150, 100);
		this.setLayout(null);
		MyLabel label=new MyLabel();
		USERID.setText(userID);
		USERID.setBounds(60, 80, 80, 20);
		USERID.setBackground(Color.orange);
		this.add(USERID);
	}
	
	public static String getUserID(){
		return USERID.getText();
	}
	
	 public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			Image background=new ImageIcon("photo/User.png").getImage();
			g.drawImage(background, 0,0,null);
			
		}
	
	
	
}
