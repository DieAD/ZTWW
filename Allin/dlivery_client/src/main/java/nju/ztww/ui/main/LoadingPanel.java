package nju.ztww.ui.main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoadingPanel extends JPanel {
	JFrame frame = new JFrame();
	Image icon1=new ImageIcon("photo2/1.png").getImage();
	Image icon2=new ImageIcon("photo2/2.png").getImage();
	Image icon3=new ImageIcon("photo2/3.png").getImage();
	Image icon4=new ImageIcon("photo2/4.png").getImage();
	Image icon = icon1;
	Thread thread;
	
	public LoadingPanel(){
		this.setLayout(null);
		this.setBounds(0,0,900,600);
		thread = new Thread(){
	     	   public void run(){
	     	     animate();
	     	   }
	     	};
	    //thread.start();
//	    frame.setSize(900, 600);
//		frame.setTitle("Bussiness");
//		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
//		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
//		frame.setLocation((width - 900) / 2, (height - 600) / 2);
//		frame.setResizable(false);
//		// add panel;
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLayout(null);
		
		//frame.add(this);
		
//		frame.setVisible(true);
//		frame.add(this);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(icon,500,400,400,20,null);
	}
	
	public void animate(){
		int count=1;
		while(true){
			if(count==1){
				icon = icon1;
			}
			if(count==2){
				icon = icon2;
			}
			if(count==3){
				icon= icon3;
			}
			if(count==4){
				icon = icon4;
			}
			count++;
			this.repaint();
			try   
    		{   
    		Thread.currentThread().sleep(600);//毫秒   
    		}   
    		catch(Exception e){}
			if(count==5){
				count=1;
			}
			
		}
	}
	
	public static void main(String[] args){
		new LoadingPanel();
	}
}
