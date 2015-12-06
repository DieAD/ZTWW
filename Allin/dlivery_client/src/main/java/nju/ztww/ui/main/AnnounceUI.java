package nju.ztww.ui.main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class AnnounceUI extends JPanel{

	public AnnounceUI(){
		this.setLayout(null);
		this.setBounds(150, 550, 750, 50);
		this.setVisible(true);
	}
	 public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			Image background=new ImageIcon("photo/bottom.png").getImage();
			g.drawImage(background, 0,0,null);
			
		}
}
