package nju.ztww.ui.finance;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class Dialog extends JDialog {
	DialogPanelmain mainPanel;
    public Dialog(JPanel panel){
    	mainPanel = new DialogPanelmain(panel,this);
    	this.setContentPane(mainPanel);
    	this.setTitle("付款单");
    	this.setSize(300, 450);
    	this.setResizable(false);
    	//this.pack();
    	
    	this.setVisible(false);
    }
    
}
