package nju.ztww.ui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import nju.ztww.dao.AccountDO;
import nju.ztww.service.FinanceService;
import nju.ztww.serviceimpl.FinanceServiceImpl;
import confligUI.MyButton;

public class INIT_Table5 extends EditPanel {
	   FinanceService FS = new FinanceServiceImpl();
	   MyButton save = new MyButton('c');
	   Dialog_init5  dia = new Dialog_init5(this);
	   public INIT_Table5(String[] strings,Object[][] objects){
		   
		   super(strings,objects);
		   
		   button1.addActionListener(new Listener());
		   button3.addActionListener(new Listener2());
		   save.setIcon(new ImageIcon("photo/return.png"));
		   this.add(button3);
		   this.add(save);
	   }
	   
	   public class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AccountDO account = new AccountDO();
			account.setId((String)tableModel.getValueAt(0,0));
			account.setName((String)tableModel.getValueAt(0,1));
		    account.setRemain((Double)tableModel.getValueAt(0, 2));
		    ///tableModel.getValueAt(0, 3);
			//account.setRemain(re);
			System.out.print(account.getRemain());
			//System.out.print(remain);
			tableModel.removeRow(0);
			FS.initAccount(account);
			
		}
		   
	   }
	   
	   public class Listener2 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int rowCount = tableModel.getRowCount();
//			for(int i=0;i<rowCount;i++){
//			tableModel.removeRow(0);}
			dia.show();
		}
		   
	   }
	}
