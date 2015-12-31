package nju.ztww.ui.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TipsUI extends JPanel implements Runnable{
	
	public static JLabel tip=new JLabel();
	private int i=0;
	public static boolean ifLine=false;
	private boolean ifrun=true;
	Thread t=new Thread(this);
	public TipsUI(){
		tip.setBounds(200, 90, 670, 30);
		tip.setFont(new Font(Font.DIALOG,1,15));
		tip.setForeground(new Color(155,122,90));
		tip.setText("");
		this.add(tip);
		this.setLayout(null);
		this.setBounds(150, 60, 750, 40);
		this.setVisible(true);
		t.start();
	}
	
//	 public void paintComponent(Graphics g){
//			super.paintComponent(g);
//			
//			Image background=new ImageIcon("photo/Tips.png").getImage();
//			g.drawImage(background, 0,0,null);
//			
//		}
	 public Color getColor(){
		 switch(i){
		 case 0:
			 i++;
			 return new Color(84,140,0);
		 case 1:
			 i++;
			 return new Color(100,166,0);
		 case 2:
			 i++;
			 return new Color(115,191,0);
		 case 3:
			 i++;
			 return new Color(130,217,0);
		 case 4:
			 i++;
			 return new Color(234,193,0);
		 case 5:
			 i++;
			 return new Color(255,220,53);
		 case 6:
			 i++;
			 return new Color(194,255,104);
		 case 7:
			 i++;
			 return new Color(204,255,128);
		 case 8:
			 i++;
			 return new Color(211,255,147);
		 case 9:
			 i++;
			 return new Color(232,255,196);
		 case 10:
			 i=0;
			 ifLine=false;
			 return new Color(245,255,232);
		 }
		 return null;
	 }

	public void run() {
		while(ifrun){
			if(ifLine){
				tip.setForeground(getColor());
			}
			try {
				Thread.sleep(350);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
