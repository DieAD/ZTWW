package nju.ztww.ui.user;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ResultMessageUI extends JPanel{
	
	 Image background=new ImageIcon("photo/1.gif").getImage();
int x=0;
	public ResultMessageUI() {

	}
	public void setPhoto(String i){
		if(i.equals("fail")){
			background=new ImageIcon("photo/fail.gif").getImage();
		
			System.out.println("20行");
		}else{
			background=new ImageIcon("photo/success.gif").getImage();
		   x+=10;
			System.out.println("21行vv");
		}
		this.repaint();
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		x+=10;
		g.drawImage(background, x,0,null);
		System.out.println("34行");

	}
	

}
