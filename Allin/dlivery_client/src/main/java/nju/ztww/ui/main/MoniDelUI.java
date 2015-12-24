package nju.ztww.ui.main;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoniDelUI extends JPanel implements Runnable{
	Thread t=new Thread(this);
	JLabel car = new JLabel();
	JLabel home = new JLabel();
	int x = 100;
	int y = 100;
	int iy = 100;

	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			this.repaint();
			car.setBounds(x, y, 60, 40);
			x+=5;
			if(x>260){
				x=20;
				iy=100;
			}
			if(x>200){
				this.home.setVisible(true);
				iy+=4;
			}else{
				this.home.setVisible(false);
			}
			
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	MoniDelUI(){
		this.setBackground(new Color(155,149,134));
//		this.setBackground(null);
//		this.setOpaque(false);
		this.setSize(500, 200);
		this.setLayout(null);
		car.setIcon(new ImageIcon("photo/Lcar.png"));
		car.setBounds(x, y, 60, 40);
		home.setIcon(new ImageIcon("photo/Lhome.png"));
		home.setBounds(320, iy, 60, 40);
		this.add(car);
		this.add(home);
		t.start();
	}
	
//	public static void main(String[] args) {
//		JFrame f = new JFrame();
//		f.setSize(400, 400);
//		f.setVisible(true);
//		MoniDelUI m = new MoniDelUI();
//		f.add(m);
//	}
}
