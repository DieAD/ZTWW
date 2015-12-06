package nju.ztww.ui.main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UserInfoUI extends JPanel{
	public static JTextArea USERID = new JTextArea();
	
	public UserInfoUI(String userID){
		this.setBounds(0, 0, 150, 100);
		this.setLayout(null);
		USERID.setText(userID);
		USERID.setBounds(20, 20, 120, 20);
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
