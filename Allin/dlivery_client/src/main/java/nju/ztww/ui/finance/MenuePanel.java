package nju.ztww.ui.finance;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

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
//       public static int width = 209;
//       public static int height = 58;
       
       
       public MenuePanel(){
    	   this.setBackground(new Color(155,122,90));
    	   this.setPicture();
    	   this.setBorder(new javax.swing.border.TitledBorder(null, "",
   				javax.swing.border.TitledBorder.CENTER,
   				javax.swing.border.TitledBorder.DEFAULT_POSITION));
    	   this.setLayout(null);
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
    	   final ImageIcon accout = new ImageIcon("photo/account.png");
    	   final ImageIcon collection = new ImageIcon("photo/collection.png");
    	   final ImageIcon payment = new ImageIcon("photo/business.png");
    	   final ImageIcon benefit = new ImageIcon("photo/benefit.png");
    	   final ImageIcon init = new ImageIcon("photo/init.png");
    	   final ImageIcon business = new ImageIcon("photo/business2.png");
    	   
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
}
