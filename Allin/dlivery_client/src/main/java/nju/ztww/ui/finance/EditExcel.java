package nju.ztww.ui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import nju.ztww.service.FinanceService;
import nju.ztww.serviceimpl.FinanceServiceImpl;

public class EditExcel extends EditPanel {

	JButton button1 = new JButton("经营情况表");
	JButton button2 = new JButton("成本收益表");
	public EditExcel(){
		this.removeAll();
		init();
	}
	public void init(){
		button1.setBounds(10, 10, 80,30 );
		button2.setBounds(10,70,80,30);
		button1.addActionListener(new Listener(this,1));
		button2.addActionListener(new Listener(this,2));
		this.add(button1);
		this.add(button2);
	}
	//--------------------------------------------
	public class Listener implements ActionListener{
        int index;
        JPanel panel;
        public Listener(JPanel panel,int index){
        	this.panel = panel;
        	this.index = index;
        }
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			FinanceService  fs = new FinanceServiceImpl();
			fs.exportExcel(index);
			new DialogInfo().show();
		}
		
	}
}
