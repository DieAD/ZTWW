package nju.ztww.ui.finance;

import javax.swing.JButton;
import javax.swing.JPanel;

public class INIT extends JPanel{
   JButton button1  = new JButton("机构建账");
   JButton button2  = new JButton("人员建账");
   JButton button3  = new JButton("车辆建账");
   JButton button4  = new JButton("库存建账");
   JButton button5  = new JButton("银行账户建账");
   public INIT(){
	   setUp();
   }
   
   public void setUp(){
	   button1.setBounds(10,10,100,50);
	   button2.setBounds(10,70,100,50);
	   button3.setBounds(10,130,100,50);
	   button4.setBounds(10,190,100,50);
	   button5.setBounds(10,250,100,50);
	   
	   this.add(button1);
	   this.add(button2);
	   this.add(button3);
	   this.add(button4);
	   this.add(button5);
   }
}
