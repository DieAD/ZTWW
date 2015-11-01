package nju.ztww.ui.user;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BusinessLableUI extends JPanel{
	

	public BusinessLableUI(){
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Image lable=new ImageIcon("photo/lable.gif").getImage();
		g.drawImage(lable, 0,0,null);
		
	}
}
