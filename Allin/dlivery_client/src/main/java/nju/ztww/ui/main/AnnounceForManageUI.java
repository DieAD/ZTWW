package nju.ztww.ui.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import nju.ztww.thread.WriteHandlerThread;
import confligUI.MyButton;

public class AnnounceForManageUI extends JPanel implements Runnable{
	private boolean ifOK=true;
	private MyButton add=new MyButton();
	private JButton sure=new JButton("确定发送");
	private JDialog dlg=new JDialog();
	private JLabel label=new JLabel("请输入消息");
	private JLabel textlabel=new JLabel("添加新公告：");
	private JTextArea text=new JTextArea();
	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	Thread t=new Thread(this);
	public AnnounceForManageUI(){
		this.setLayout(null);
		//final ImageIcon ADD=new ImageIcon("photo2/AddAnoucement.png");
		add.setIcon(new ImageIcon("photo2/AddAnouncement.png"));
		add.setBounds(520, 0, 100, 25);
		textlabel.setBounds(400, -5, 100, 30);
		textlabel.setFont(new Font(Font.DIALOG,0,14));
		textlabel.setForeground(new Color(255,255,255));
		add.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				dlg.setSize(new Dimension(450, 360));
	            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
	            label.setBounds(10, 10, 100, 20);
	            text.setBounds(10, 40, 410, 240);
	            sure.setBounds(50, 290, 300, 20);
	            sure.addActionListener(sureListener);
	            dlg.add(sure);
	            dlg.add(label);
	            dlg.add(text);
	            dlg.setLayout(null);
				dlg.setVisible(true);
			}
			
		});
		//this.add(textlabel);
		this.add(add);
	
		this.setBounds(200, 550, 670, 30);
		this.setOpaque(false);
		this.setVisible(true);
		t.start();
	}
	
	ActionListener sureListener=new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			String s=text.getText().replace('\n',' ');
			String [] temp=s.split(" ");
			String message="";
			for(int i=0;i<temp.length;i++){
				message=message+(i+1)+"，"+temp[i]+"。";
			}
			System.out.println(message);
			WriteHandlerThread.message=message;
			WriteHandlerThread.ifSend=false;
			text.setText("");
		}
	};
	
	 public void paintComponent(Graphics g){
			super.paintComponent(g);
			
//			Image background=new ImageIcon("photo/bottom.png").getImage();
//			g.drawImage(background, 0,0,null);
			
		}

	public void run() {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket = new ServerSocket(54421);
			while(true){
				Socket client = serverSocket.accept();
				System.out.println("accept");
				new WriteHandlerThread (client);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
