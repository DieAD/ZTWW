package nju.ztww.ui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import confligUI.MyTextField;

public class DialogInfo extends JDialog {
	JButton button1 = new JButton("Sure");
    public DialogInfo(){
	this.setLayout(null);   
	this.setContentPane(new mainPanel());
   	this.setTitle("Info");
   	this.setSize(300, 450);
   	this.setResizable(false);
   	button1.setBounds(100,300, 80, 30);
   	button1.addActionListener(new Listener(this));
   	this.add(button1);
   	//this.pack();
   	
   	this.setVisible(false);
   }
   
   //-------------------------------------------
   
   public class mainPanel extends JPanel{
	   MyTextField info = new MyTextField("Success!!!");
	   public mainPanel(){
		   this.setLayout(null);
		   this.setBounds(0,0,300, 450);
		   info.setBounds(20, 20, 80, 40);
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
