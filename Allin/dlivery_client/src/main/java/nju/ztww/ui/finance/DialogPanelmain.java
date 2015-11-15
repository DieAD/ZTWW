package nju.ztww.ui.finance;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DialogPanelmain extends JPanel {
	 DialogPaneledit componentPanel1 = new DaccountPanel();
	 JButton addButton = new JButton("添加");
     public DialogPanelmain(){
    	
    	 this.setLayout(null);
    	 //this.setSize(100, 450);
    	 componentPanel1.setBorder(BorderFactory.createTitledBorder("付款单信息输入"));
    	 componentPanel1.setBounds(0, 150, 295, 100);
    	 this.add(componentPanel1);
    	 
    	 addButton.setBounds(100, 350, 100, 20);
    	 this.add(addButton);
    	// this.setBounds(x, y, width, height);
    	 
     }
}
