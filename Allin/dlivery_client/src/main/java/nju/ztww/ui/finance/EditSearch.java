package nju.ztww.ui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nju.ztww.ui.main.subTrace;

public class EditSearch extends EditPanel {
    JButton button1 =new JButton("Search");
    JTextField text1 = new JTextField();
    		
	public EditSearch(){
		this.removeAll();
		init();
		this.setVisible(false);
	}
	public void init(){
		button1.setBounds(10, 10, 80, 30);
		text1.setBounds(100, 10, 80, 30);
		button1.addActionListener(new Listener(this));
		this.add(button1);
		this.add(text1);
	}
	
	
	//------------------------------------------------------Listener
	public class Listener implements ActionListener{
        JPanel panel;
        String id;
        public Listener(JPanel panel){
        	this.panel = panel;
        	
        }
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			id=text1.getText();
			panel.removeAll();
			panel.add(new subTrace(id));
			panel.repaint();
			
		}
		
	}
}
