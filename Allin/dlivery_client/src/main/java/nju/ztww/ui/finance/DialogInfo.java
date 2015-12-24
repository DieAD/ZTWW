package nju.ztww.ui.finance;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import confligUI.MyTextField;

public class DialogInfo extends JDialog {
	JButton button1 = new JButton("确定");
    public DialogInfo(){
	this.setLayout(null);   
	this.setContentPane(new mainPanel());
   	this.setTitle("Info");
   	this.setSize(300, 250);
   	this.setResizable(false);
   	button1.setBounds(100,170, 80, 30);
   	button1.addActionListener(new Listener(this));
   	this.add(button1);
   	//this.pack();
    Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包  
	 Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸  
	 int screenWidth = screenSize.width;                     //获取屏幕的宽  
	 int screenHeight = screenSize.height; 
	 this.setLocation(screenWidth/2-300/2, screenHeight/2-250/2);
   	this.setVisible(false);
   }
   
   //-------------------------------------------
   
   public class mainPanel extends JPanel{
	   MyTextField info = new MyTextField("Success!!!");
	   public mainPanel(){
		   this.setLayout(null);
		   this.setBounds(0,0,300, 250);
		   info.setBounds(100, 70, 80, 40);
		   info.setEnabled(false);
		   this.add(info);
	   }
   }
   
   public class Listener implements ActionListener{
    JDialog dia;
    public Listener(JDialog dia){
    	this.dia = dia;
    }
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dia.dispose();
	}
	   
   }
}
