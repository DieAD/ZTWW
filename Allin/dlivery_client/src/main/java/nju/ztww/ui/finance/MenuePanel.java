package nju.ztww.ui.finance;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import nju.ztww.ui.order.MyButton;

public class MenuePanel extends JPanel {
       MyButton accountButton = new MyButton(0);
       MyButton collectionButton = new MyButton(1);
       MyButton paymentButton = new MyButton(2);
       MyButton benefitButton = new MyButton(3);
       MyButton businessButton = new MyButton(4);
       MyButton initButton = new MyButton(5);
       

	   final ImageIcon accout = new ImageIcon("photo/account.png");
	   final ImageIcon collection = new ImageIcon("photo/collection.png");
	   final ImageIcon payment = new ImageIcon("photo/payment.png");
	   final ImageIcon benefit = new ImageIcon("photo/benefit.png");
	   final ImageIcon init = new ImageIcon("photo/init.png");
	   final ImageIcon business = new ImageIcon("photo/business.png");
	   ImageIcon accout2 = new ImageIcon("photo/account2.png");
	  ImageIcon collection2 = new ImageIcon("photo/collection2.png");
	   ImageIcon payment2 = new ImageIcon("photo/payment2.png");
	   ImageIcon benefit2 = new ImageIcon("photo/benefit2.png");
	   ImageIcon init2 = new ImageIcon("photo/init2.png");
	   ImageIcon business2 = new ImageIcon("photo/business2.png");
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
    	  
       }
       public void setPicture(){

    	   
    	   accountButton.setIcon(accout);
    	   collectionButton.setIcon(collection);
    	   paymentButton.setIcon(payment);
    	   benefitButton.setIcon(benefit);
    	   initButton.setIcon(init);
    	   businessButton.setIcon(business);
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
		}
	};
	
		ActionListener collectionListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removeButton(panel);
				collectionButton.setIcon(collection2);
				panel = 1;
			}
		};
       
		ActionListener paymentListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removeButton(panel);
				paymentButton.setIcon(payment2);
				panel = 2;
			}
		};
	
		ActionListener benefitListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removeButton(panel);
				benefitButton.setIcon(benefit2);
				panel = 3;
			}
		};
		
		ActionListener businessListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removeButton(panel);
				businessButton.setIcon(business2);
				panel  = 4;
			}
		};
		
		ActionListener initListener = new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				removeButton(panel);
				initButton.setIcon(init2);
				panel = 5;
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
		default:
			break;
		}
	}
}
