package nju.ztww.ui.finance;

import javax.swing.JDialog;

public class Dialog extends JDialog {
	DialogPanelmain mainPanel = new DialogPanelmain();
    public Dialog(){
    	this.setContentPane(mainPanel);
    	this.setTitle("付款单");
    	this.setSize(300, 450);
    	this.setResizable(false);
    	//this.pack();
    	
    	this.setVisible(false);
    }
    
}
