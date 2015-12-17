package nju.ztww.ui.main;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoniDelUI extends JPanel implements Runnable{
	Thread t=new Thread(this);
	JLabel car = new JLabel();
	int x = 100;
	int y = 100;

	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			this.repaint();
			car.setBounds(x, y, 60, 40);
			x+=5;
			if(x>350){
				x=20;
			}
			if(x>300){
				this.car.setVisible(false);
			}else{
				this.car.setVisible(true);
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
		this.setBackground(new Color(232,181,53));
		this.setSize(400, 400);
		this.setLayout(null);
		car.setIcon(new ImageIcon("photo/Lcar.png"));
		car.setBounds(x, y, 60, 40);
		this.add(car);
		t.start();
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(400, 400);
		f.setVisible(true);
		MoniDelUI m = new MoniDelUI();
		f.add(m);
	}
}
