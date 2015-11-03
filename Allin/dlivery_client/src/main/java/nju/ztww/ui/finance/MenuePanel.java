package nju.ztww.ui.finance;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuePanel extends JPanel {
       JButton accountButton = new JButton("账户查询");
       JButton collectionButton = new JButton("查看收款单");
       JButton paymentButton = new JButton("成本管理");
       JButton benefitButton = new JButton("成本收益表");
       JButton businessButton = new JButton("经营情况表");
       JButton initButton = new JButton("期初建账");
       public static int width = 209;
       public static int height = 58;
       
       
       public MenuePanel(){
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
    	   this.add(initButton);
    	   this.add(paymentButton);
    	  
       }
       public void paintComponent(Graphics g){
   		super.paintComponent(g);
   		
   		Image background=new ImageIcon("photo/background.gif").getImage();
   		g.drawImage(background, 0,0,null);
   		
   	}
}
