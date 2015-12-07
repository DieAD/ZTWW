package nju.ztww.ui.commodity;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClerkOfCenterTopPanel extends JPanel {
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Image lable=new ImageIcon("photo/theme.png").getImage();
		g.drawImage(lable, 0,0,null);
		
	}
}
