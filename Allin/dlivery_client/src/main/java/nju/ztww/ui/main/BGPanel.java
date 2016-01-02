package nju.ztww.ui.main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BGPanel extends JPanel{
	Image icon2=new ImageIcon("photo2/bg.png").getImage();
	public BGPanel(){
		this.setBounds(0, 0, 900, 600);
		this.setLayout(null);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(icon2, 0, 0, 900, 600, null);
	}
}
