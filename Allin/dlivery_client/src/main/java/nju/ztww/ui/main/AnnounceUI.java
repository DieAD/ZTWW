package nju.ztww.ui.main;

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

public class AnnounceUI extends JPanel implements Runnable{
	private String IP="127.0.0.1";
	private JLabel text=new JLabel("!!!!!!!!");
	Thread t=new Thread(this);
	public AnnounceUI(){
		text.setBounds(20, 10, 200, 10);
		this.add(text);
		this.setLayout(null);
		this.setBounds(150, 550, 750, 50);
		this.setVisible(true);
		t.start();
	}
	 public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			Image background=new ImageIcon("photo/bottom.png").getImage();
			g.drawImage(background, 0,0,null);
		}
	public void run() {

		try {
			while(true){
				Socket client = new Socket(IP, 54421);
				System.out.println("@@@@@@@@@@");
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream())); 
				String msg = br.readLine(); 
				System.out.println(msg);
				text.setText(msg);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
