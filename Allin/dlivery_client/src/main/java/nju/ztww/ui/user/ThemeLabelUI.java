package nju.ztww.ui.user;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ThemeLabelUI extends JPanel{
	

	public ThemeLabelUI(){
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Image label=new ImageIcon("photo/lable.gif").getImage();
		g.drawImage(label, 0,0,null);
		
	}
}
