package nju.ztww.ui.finance;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HeaderPanel extends JPanel{
	public HeaderPanel(){
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Image lable=new ImageIcon("photo/theme.png").getImage();
		g.drawImage(lable, 0,0,null);
		
	}
}
