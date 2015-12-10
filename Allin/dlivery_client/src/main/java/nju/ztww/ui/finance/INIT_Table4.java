package nju.ztww.ui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import nju.ztww.dao.StockDO;
import nju.ztww.service.FinanceService;
import nju.ztww.serviceimpl.FinanceServiceImpl;

public class INIT_Table4 extends EditPanel {
	   FinanceService FS = new FinanceServiceImpl();
	   public INIT_Table4(String[] strings,Object[][] objects){
		   super(strings,objects);
		   button1.addActionListener(new Listener());
	   }
	   
	   
	   public class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList<StockDO> list = new ArrayList<StockDO>();
			int rowNum = tableModel.getRowCount();
			for(int i=0;i<rowNum;i++){
				StockDO stock = new StockDO();
			    stock.setGoodsid((String)tableModel.getValueAt(0, 0));
			    stock.setEntrytime((String)tableModel.getValueAt(0, 1));
			    stock.setAddress((String)tableModel.getValueAt(0,2));
			    stock.setQu((String)tableModel.getValueAt(0, 3));
			    stock.setPai((String)tableModel.getValueAt(0, 4));
			    stock.setJia((String)tableModel.getValueAt(0, 5));
			    stock.setWei((String)tableModel.getValueAt(0,6));
			    stock.setState(0);			
			    
			    list.add(stock);
			    tableModel.removeRow(0);
			}
			FS.initStock(list);
			
			
		}
		   
	   }
	}
