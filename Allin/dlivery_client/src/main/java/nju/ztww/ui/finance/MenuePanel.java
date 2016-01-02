package nju.ztww.ui.finance;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import nju.ztww.ui.main.Listener_Return;
import confligUI.MyButton;

public class MenuePanel extends JPanel {
       MyButton accountButton = new MyButton(0);
       MyButton collectionButton = new MyButton(1);
       MyButton paymentButton = new MyButton(2);
       MyButton benefitButton = new MyButton(3);
       MyButton businessButton = new MyButton(4);
       MyButton initButton = new MyButton(5);
       MyButton exportFormButton = new MyButton(6);
       MyButton personInfoButton = new MyButton(6);
       MyButton checkOrderButton  = new MyButton(7);
       MyButton logoutButton = new MyButton(8);
       

	   final ImageIcon accout = new ImageIcon("photo/account.png");
	   final ImageIcon collection = new ImageIcon("photo/collection.png");
	   final ImageIcon payment = new ImageIcon("photo/payment.png");
	   final ImageIcon benefit = new ImageIcon("photo/CostForm.png");
	   final ImageIcon init = new ImageIcon("photo/init.png");
	   final ImageIcon business = new ImageIcon("photo/StateForm.png");
	   ImageIcon exportForm = new ImageIcon("photo/ExportForm.png");
	   ImageIcon perIn = new ImageIcon("photo/PersonInfo.png");
	   ImageIcon check = new ImageIcon("photo/CheckOrder.png");
	   ImageIcon lo = new ImageIcon("photo/Logout.png");
	   ImageIcon accout2 = new ImageIcon("photo/account2.png");
	   ImageIcon collection2 = new ImageIcon("photo/collection2.png");
	   ImageIcon payment2 = new ImageIcon("photo/payment2.png");
	   ImageIcon benefit2 = new ImageIcon("photo/CostForm2.png");
	   ImageIcon init2 = new ImageIcon("photo/init2.png");
	   ImageIcon business2 = new ImageIcon("photo/StateForm2.png");
	   ImageIcon exportForm2 = new ImageIcon("photo/ExportForm2.png");
	   ImageIcon perIn2 = new ImageIcon("photo/PersonInfo2.png");
	   ImageIcon check2 = new ImageIcon("photo/CheckOrder2.png");
	   ImageIcon lo2 = new ImageIcon("photo/Logout2.png");
       int panel = 0;
//       public static int width = 209;
//       public static int height = 58;
       
       
       public MenuePanel(){

    	   this.setBackground(new Color(155,122,90));
    	   this.setPicture();
    	   this.setBorder(new javax.swing.border.TitledBorder(null, "",
   				javax.swing.border.TitledBorder.CENTER,
   				javax.swing.border.TitledBorder.DEFAULT_POSITION));
    	   this.setLayout(null);
    	   accountButton.addActionListener(accountListener);
    	   collectionButton.addActionListener(collectionListener);
    	   paymentButton.addActionListener(paymentListener);
    	   benefitButton.addActionListener(benefitListener);
    	   businessButton.addActionListener(businessListener);
    	   initButton.addActionListener(initListener);
    	   exportFormButton.addActionListener(export);
    	   personInfoButton.addActionListener(yourMessage);
    	   checkOrderButton.addActionListener(checkOrder);
    	   logoutButton.addActionListener(logout);
//    	   accountButton.setBounds(0, 60, width, height);
//    	   collectionButton.setBounds(0,60+height*1,width,height);
//    	   paymentButton.setBounds(0, 60+height*2, width, height);
//    	   benefitButton.setBounds(0, 60+height*3, width, height);
//    	   initButton.setBounds(0, 60+height*4, width, height);
//    	   businessButton.setBounds(0, 60+height*5, width, height);
    	   
    	   this.add(accountButton);
    	   this.add(benefitButton);
    	   this.add(businessButton);
    	   this.add(collectionButton);
    	   this.add(paymentButton);
    	   this.add(initButton);
    	  // this.add(exportFormButton);
    	   this.add(personInfoButton);
    	   this.add(checkOrderButton);
    	   this.add(logoutButton);
    	  
       }
       public void setPicture(){

    	   
    	   accountButton.setIcon(accout2);
    	   collectionButton.setIcon(collection);
    	   paymentButton.setIcon(payment);
    	   benefitButton.setIcon(benefit);
    	   initButton.setIcon(init);
    	   businessButton.setIcon(business);
    	   exportFormButton.setIcon(exportForm);
    	   personInfoButton.setIcon(perIn);
    	   checkOrderButton.setIcon(check);
    	   logoutButton.setIcon(lo);
       }
//       public void paintComponent(Graphics g){
//   		super.paintComponent(g);
//   		
//   		Image background=new ImageIcon("photo/background.gif").getImage();
//   		g.drawImage(background, 0,0,null);
//   		
//   	}
       ActionListener accountListener = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			removeButton(panel);
			accountButton.setIcon(accout2);
			panel = 0;
			MyButton.type=0;
		}
	};
	
		ActionListener collectionListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removeButton(panel);
				collectionButton.setIcon(collection2);
				panel = 1;
				MyButton.type=1;
			}
		};
       
		ActionListener paymentListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removeButton(panel);
				paymentButton.setIcon(payment2);
				panel = 2;
				MyButton.type=2;
			}
		};
	
		ActionListener benefitListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removeButton(panel);
				benefitButton.setIcon(benefit2);
				panel = 3;
				MyButton.type=3;
			}
		};
		
		ActionListener businessListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removeButton(panel);
				businessButton.setIcon(business2);
				panel  = 4;
				MyButton.type=4;
			}
		};
		
		ActionListener initListener = new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				removeButton(panel);
				initButton.setIcon(init2);
				panel = 5;
				MyButton.type=5;
			}
		};
		
		ActionListener yourMessage = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removeButton(panel);
				personInfoButton.setIcon(perIn2);
				panel = 6;
				MyButton.type=7;
			}
		};
		
		ActionListener checkOrder = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removeButton(panel);
				checkOrderButton.setIcon(check2);
				panel = 7;
				MyButton.type=8;
			}
		};
		
		ActionListener logout = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Listener_Return re = new Listener_Return();
				re.actionPerformed(e);
			}
		};
		
		ActionListener export = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removeButton(panel);
				exportFormButton.setIcon(exportForm2);
				panel=8;
				MyButton.type=6;
			}
		};
	
	private void removeButton(int n){

		switch (n) {
		case 0: accountButton.setIcon(accout);break;
		case 1: collectionButton.setIcon(collection);break;
		case 2: paymentButton.setIcon(payment);break;
		case 3: benefitButton.setIcon(benefit);break;
		case 4: businessButton.setIcon(business);break;
		case 5: initButton.setIcon(init);break;
		case 6: personInfoButton.setIcon(perIn);break;
		case 7: checkOrderButton.setIcon(check);break;
		case 8: exportFormButton.setIcon(exportForm);break;
		default:
			break;
		}
	}
}
