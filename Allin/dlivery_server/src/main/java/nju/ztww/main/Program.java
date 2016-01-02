package nju.ztww.main;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import nju.ztww.service.CheckOrderDataService;
import nju.ztww.service.CommodityDataService;
import nju.ztww.service.CommodityListDataService;
import nju.ztww.service.FinanceDataService;
import nju.ztww.service.ManageDataService;
import nju.ztww.service.OrderDataService;
import nju.ztww.service.UserDataService;
import nju.ztww.serviceimpl.CheckOrderDataServiceImpl;
import nju.ztww.serviceimpl.CommodityListDataServiceImpl;
import nju.ztww.serviceimpl.FinanceDataServiceImpl;
import nju.ztww.serviceimpl.ManageDataServiceImpl;
import nju.ztww.serviceimpl.OrderDataServiceImpl;
import nju.ztww.serviceimpl.StorageInOfListDataServiceImpl;
import nju.ztww.serviceimpl.StorageOutOfListDataServiceImpl;
import nju.ztww.serviceimpl.UserDataServiceImpl;


public class Program {
         public  String IP = "127.0.0.1";
         public  int PORT = 1011;
         JFrame frame = new JFrame();
         JPanel panel = new JPanel();
         JTextField input = new JTextField();
         public Program(){
        	 setUpFrame();
         }
         public void setUpFrame(){
        	
        	// frame.setLayout(null);
        	 frame.setSize(300, 450);
     		 int width = Toolkit.getDefaultToolkit().getScreenSize().width;
     		 int height = Toolkit.getDefaultToolkit().getScreenSize().height;
     		 frame.setLocation((width - 900) / 2, (height - 600) / 2);
     		 frame.setResizable(false);
     		 
     		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     		 frame.setLayout(null);
     		// add panel;
        	
        	 panel.setBounds(0, 0, 300, 450);
        	 panel.setLayout(null);
        	 //
        	 input.setBounds(135,200,100,20);
        	 panel.add(input);
        	 input.requestFocus();
        	 //
        	 JTextArea text2 = new JTextArea();
        	 text2.setText("PORT");
        	 text2.setBounds(80, 200, 50, 20);
        	 panel.add(text2);
        	 //
        	
        	
        	 //
        	 JButton button1 = new JButton("CONNECT");
        	 button1.setBounds(100, 230, 100, 20);
        	 button1.addActionListener(new Listener());
        	 panel.add(button1);
        	 //
        	
        	 frame.add(panel);
        	 frame.setVisible(true);
        	 
         }
         public static void main(String[] args){
        	 new Program();
         
         }
         
         public void setUpRMI(){
        	 try{

             	
        		 OrderDataService orderDataService=new OrderDataServiceImpl();      		
        		 UserDataService userdataservice = new UserDataServiceImpl();
        		 CommodityDataService commoditydataservice=new StorageInOfListDataServiceImpl();
        		 CommodityDataService  commoditydataserviceout=new StorageOutOfListDataServiceImpl();
        		 CommodityListDataService  commoditylistdataservice=new  CommodityListDataServiceImpl();
        		 FinanceDataService  financedataservice = new FinanceDataServiceImpl();
        		 CheckOrderDataService checkorderdataservice=new CheckOrderDataServiceImpl();
        		 ManageDataService   managedataservice = new ManageDataServiceImpl();
        		 LocateRegistry.createRegistry(PORT);
        		 Naming.rebind("rmi://"+IP+":"+PORT+"/UserDataService", userdataservice);       		
        		 Naming.rebind("rmi://"+IP+":"+PORT+"/OrderDataService", orderDataService);
        		 Naming.rebind("rmi://"+IP+":"+PORT+"/CommodityDataService", commoditydataservice);
        		 Naming.rebind("rmi://"+IP+":"+PORT+"/CommodityDataServiceOut", commoditydataserviceout);
        		 Naming.rebind("rmi://"+IP+":"+PORT+"/CommodityListDataService", commoditylistdataservice);
        		 Naming.rebind("rmi://"+IP+":"+PORT+"/FinanceDataService", financedataservice);
        		 Naming.rebind("rmi://"+IP+":"+PORT+"/CheckOrderDataService", checkorderdataservice);
        		 Naming.rebind("rmi://"+IP+":"+PORT+"/ManageDataService", managedataservice);
        		 //ManageDataServiceImpl
        		 
        		// LocateRegistry.createRegistry(PORT);
        		 System.out.println("Server strated!");
        	 }catch(Exception e){
        		 e.printStackTrace();
        	 }
         }
         
         public class Listener implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String _port = input.getText();
				int port = Integer.parseInt(_port);
				PORT = port;
				setUpRMI();
				JTextArea text1 = new JTextArea();
	        	text1.setText("Server Started！！");
	        	text1.setBounds(100, 280, 100, 20);
	        	panel.add(text1);
	        	panel.repaint();
				
			}
        	 
         }
       
}

