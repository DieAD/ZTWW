package nju.ztww.ui.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import nju.ztww.service.UserService;
import nju.ztww.serviceimpl.UserLoginImpl;
import nju.ztww.vo.ManaUserVO;
import confligUI.MyLabel;
import confligUI.MyTextField;

public class UserInfoUI extends JPanel{
	public static JTextArea USERID = new JTextArea();
	Image photo;
	
	public UserInfoUI(String userID){
		
		this.setBounds(0, 0, 150, 100);
		this.setLayout(null);
		MyLabel label=new MyLabel();
		USERID.setText(userID);
		//USERID.setBounds(60, 80, 80, 20);
		//USERID.setBackground(Color.orange);
		//this.add(USERID);
		init();
	}
	
	public static String getUserID(){
		return USERID.getText();
	}
	
	 public void paintComponent(Graphics g){
			super.paintComponent(g);
			loadImage();
			Image background=new ImageIcon("photo/User.png").getImage();
			g.drawImage(background, 0,0,null);
			g.drawImage(photo, 10, 10, 55, 55, null);
			
		}
	public void init(){
		UserService us = new UserLoginImpl();
 		ManaUserVO userInfo = us.findByID(UserInfoUI.getUserID());
 		String name = userInfo.getName();
 		String position = userInfo.getPosition();
 		String idField = "ID: ";
		JLabel text1 = new JLabel();
		JLabel text2 = new JLabel();
		JLabel text3 = new JLabel();
		JLabel text4 = new JLabel();
		text1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		text2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		text3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		text4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		text1.setText(name);
		text2.setText(position);
		text3.setText(idField);
		text4.setText(UserInfoUI.getUserID());
		text1.setBounds(70,10,60,20);
		text2.setBounds(70,40,60,20);
		text3.setBounds(10,70, 30, 20);
		text4.setBounds(50, 70, 100, 20);
//		text1.setEditable(false);
//		text2.setEditable(false);
//		text3.setEditable(false);
//		text4.setEditable(false);
		text1.setHorizontalAlignment(JTextField.CENTER);
		text2.setHorizontalAlignment(JTextField.CENTER);
		text3.setHorizontalAlignment(JTextField.CENTER);
		this.add(text1);
		this.add(text2);
		this.add(text3);
		this.add(text4);
	}
	
	public void loadImage(){
		String path = "photo2/";
		System.out.print("flag="+UserInfoUI.getUserID());
		char pos =(UserInfoUI.getUserID()).charAt(8);
		//System.out.print(UserInfoUI.getUserID());
		switch (pos) {
		case '0':path+="S1.png";break;	
		case '1':path+="S2.png"; break;
		case '2':path+="S3.png";break;
		case '3':path+="S4.png";break;
		case '4':path+="S5.png";break;
		case '5':path+="S6.png";break;
		case '6':path+="S7.png";break;
		default:path+="S1.png";break;
		}
		try {
			 photo = ImageIO.read(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
