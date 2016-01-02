package nju.ztww.ui.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class AnnounceUI extends JPanel implements Runnable{
	private String IP="127.0.0.1";
	public static JLabel text=new JLabel("");
	private JLabel notice=new JLabel("公告：");
	Thread t=new Thread(this);
	public AnnounceUI(){
		text.setBounds(150, 0, 400, 20);
		text.setFont(new Font(Font.DIALOG,0,15));
		notice.setBounds(0, 0, 100, 20);
		notice.setFont(new Font(Font.DIALOG,1,15));
		notice.setForeground(new Color(255,255,255));
		this.add(notice);
		this.add(text);

		this.setLayout(null);
		this.setBounds(200, 550, 520, 30);
		this.setVisible(true);
		this.setOpaque(false);
		t.start();
	}
	
	 public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			Image background=new ImageIcon("photo/bottom.png").getImage();
			//g.drawImage(background, 0,0,null);
		}

	

	public void run() {
		Socket client =null;
		 DataInputStream dis = null;
			while(true){
				try {
					client = new Socket(IP, 54421);
					System.out.println("@@@@@@@@@@");
					BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream())); 
					String msg = br.readLine(); 
					System.out.println(msg+"&&&&&&&&&&&&&");
					text.setText(msg);
				} catch (IOException e) {
					
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
	}

}
