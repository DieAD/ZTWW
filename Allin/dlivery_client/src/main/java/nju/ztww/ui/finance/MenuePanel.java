package nju.ztww.ui.finance;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuePanel extends JPanel {
       JButton accountButton = new JButton("");
       JButton collectionButton = new JButton("");
       JButton paymentButton = new JButton("");
       JButton benefitButton = new JButton("");
       JButton businessButton = new JButton("");
       JButton initButton = new JButton("");
       public static int width = 209;
       public static int height = 58;
       
       
       public MenuePanel(){
    	   this.setPicture();
    	   this.setBorder(new javax.swing.border.TitledBorder(null, "",
   				javax.swing.border.TitledBorder.CENTER,
   				javax.swing.border.TitledBorder.DEFAULT_POSITION));
    	   this.setLayout(null);
    	   accountButton.setBounds(0, 60, width, height);
    	   collectionButton.setBounds(0,60+height*1,width,height);
    	   paymentButton.setBounds(0, 60+height*2, width, height);
    	   benefitButton.setBounds(0, 60+height*3, width, height);
    	   initButton.setBounds(0, 60+height*4, width, height);
    	   businessButton.setBounds(0, 60+height*5, width, height);
    	   
    	   this.add(accountButton);
    	   this.add(benefitButton);
    	   this.add(businessButton);
    	   this.add(collectionButton);
    	   this.add(paymentButton);
    	   this.add(initButton);
    	  
       }
       public void setPicture(){
    	   final ImageIcon accout = new ImageIcon("finance/account.png");
    	   final ImageIcon collection = new ImageIcon("finance/collection.png");
    	   final ImageIcon payment = new ImageIcon("finance/business.png");
    	   final ImageIcon benefit = new ImageIcon("finance/benefit.png");
    	   final ImageIcon init = new ImageIcon("finance/init.png");
    	   final ImageIcon business = new ImageIcon("finance/business2.png");
    	   
    	   accountButton.setIcon(accout);
    	   collectionButton.setIcon(collection);
    	   paymentButton.setIcon(payment);
    	   benefitButton.setIcon(benefit);
    	   initButton.setIcon(init);
    	   businessButton.setIcon(business);
       }
       public void paintComponent(Graphics g){
   		super.paintComponent(g);
   		
   		Image background=new ImageIcon("photo/background.gif").getImage();
   		g.drawImage(background, 0,0,null);
   		
   	}
}
