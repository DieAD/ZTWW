package nju.ztww.ui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nju.ztww.dao.AccountDO;
import nju.ztww.service.FinanceService;
import nju.ztww.serviceimpl.FinanceServiceImpl;

public class INIT_Table5 extends EditPanel {
	   FinanceService FS = new FinanceServiceImpl();
	   public INIT_Table5(String[] strings,Object[][] objects){
		   super(strings,objects);
		   button1.addActionListener(new Listener());
	   }
	   
	   public class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AccountDO account = new AccountDO();
			account.setId((String)tableModel.getValueAt(0,0));
			account.setName((String)tableModel.getValueAt(0,1));
			account.setRemain((Double)tableModel.getValueAt(0,2));
			tableModel.removeRow(0);
			FS.initAccount(account);
			
		}
		   
	   }
	}
