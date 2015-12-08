package nju.ztww.ui.finance;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class EditInit extends EditPanel{
	//JLabel label1  = new JLabel("");
	JButton button = new JButton("");
	final ImageIcon initaccout = new ImageIcon("finance/initaccount.png");
	
    public EditInit(String[] strings,Object[][] objects){
    	super(strings,objects);
    	this.setBackground(new Color(250, 240, 230));
    	button.setIcon(initaccout);
    	this.remove(button1);
    	this.remove(button2);
    	this.remove(button3);
    	
    	this.scrollPane.setBounds(0,0,690,250);
    	this.button.setBounds(130, 260, 400, 200);//picture 600x200
    	
    	this.add(button);
    	button.addActionListener(new Listener(this));
    }
    
    public class Listener implements ActionListener{
    	EditInit panel;
    	INIT init = new INIT();
    	public Listener(EditInit panel){
    		this.panel = panel;
    	}

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			panel.removeAll();
			init.setBounds(0, 0, 750, 450);
			panel.add(init);
			panel.repaint();
		}
    	
    }
}
