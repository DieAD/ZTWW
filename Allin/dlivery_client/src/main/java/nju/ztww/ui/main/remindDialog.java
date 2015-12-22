package nju.ztww.ui.main;

import java.awt.Dimension;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class remindDialog extends JDialog implements Runnable{
	public JTextArea text;
    private JScrollPane scrollPane;
    private String IP;
    private String port;
    private String serviceName;
    public Object	service;
    public boolean ifLine=true;
    Thread t=new Thread(this);
	public remindDialog(String IP,String port,String serviceName){
	
		this.IP = IP;
    	this.port = port;
    	this.serviceName=serviceName;
		text=new JTextArea("和服务器断开连接......"+"\n");
		scrollPane= new JScrollPane(text);
		scrollPane.setBounds(0, 0, 500, 400);
		this.add(scrollPane);
		t.start();
		this.setSize(new Dimension(510, 410));
    	this.setModal(true);
		this.setLayout(null);
		this.setVisible(true);
	
	}
	
	public void run() {
		while(ifLine){
			boolean temp=false;
			text.append("正在重新连接"+"\n");
			try {
				service =(Object) Naming.lookup("rmi://"+IP+":"+port+"/"+serviceName);
			//	dia.text.append("连接成功"+"\n");
			} catch (NotBoundException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				temp=true;
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			if(!temp){
				ifLine=false;
				this.dispose();
			}
			System.out.println("正在重新连接");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
