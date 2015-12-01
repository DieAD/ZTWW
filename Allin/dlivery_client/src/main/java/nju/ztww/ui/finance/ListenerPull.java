package nju.ztww.ui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import nju.ztww.service.FinanceService;
import nju.ztww.serviceimpl.FinanceServiceImpl;
import nju.ztww.vo.PaymentVO;

public class ListenerPull implements ActionListener{
    private EditPanel panel;
    private FinanceService financeservice = new FinanceServiceImpl();
    public ListenerPull(EditPanel panel){
    	this.panel = panel;
    }
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ArrayList<PaymentVO> list = new ArrayList<PaymentVO>();
		int count = panel.tableModel.getRowCount();
		for(int i=0;i<count;i++){
		 String date =(String)panel.tableModel.getValueAt(0, 0);
		 double money = (Double)panel.tableModel.getValueAt(0, 1);
		 String paymen = (String)panel.tableModel.getValueAt(0, 2);
		 String payaccount = (String)panel.tableModel.getValueAt(0, 3);
		 String paycat = (String)panel.tableModel.getValueAt(0, 4);
		 String ps = (String)panel.tableModel.getValueAt(0, 5);
		// System.out.print((Double)panel.tableModel.getValueAt(0, 1));
		 list.add(new PaymentVO(date,money,paymen,payaccount,paycat,ps));	
		 panel.tableModel.removeRow(0);
		}
		financeservice.addPaymentForm(list);
		// for(PaymentVO vo : list){
		// System.out.print(vo.date);
		// }
		
	}

}
