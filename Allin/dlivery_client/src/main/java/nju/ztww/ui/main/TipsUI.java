package nju.ztww.ui.main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TipsUI extends JPanel{
	
	public TipsUI(){
		this.setLayout(null);
		this.setBounds(150, 60, 750, 40);
		this.setVisible(true);
	}
	
	 public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			Image background=new ImageIcon("photo/Tips.png").getImage();
			g.drawImage(background, 0,0,null);
			
		}
}
