package nju.ztww.ui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import nju.ztww.po.CarManagePO;
import nju.ztww.service.FinanceService;
import nju.ztww.serviceimpl.FinanceServiceImpl;

public class INIT_Table3 extends EditPanel {
	   FinanceService FS  = new FinanceServiceImpl();	   
	   public INIT_Table3(String[] strings,Object[][] objects){
		   super(strings,objects);
		   button1.addActionListener(new Listener());
	   }
	   
	   
	   public class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList<CarManagePO> list = new ArrayList<CarManagePO>();
			int rowNum = tableModel.getRowCount();
			System.out.print((String)tableModel.getValueAt(0, 0));
			for(int i=0;i<rowNum;i++){
				CarManagePO po = new CarManagePO(0);
				po.setId((String)tableModel.getValueAt(0, 0));
				po.setCarNumber((String)tableModel.getValueAt(0,1));
				po.setPlateNUmber((String)tableModel.getValueAt(0,2));
				po.setServiceTime((String)tableModel.getValueAt(0, 3));
				po.setCarState((String)tableModel.getValueAt(0, 4));
				po.setExe(0);
				po.setState(1);
				list.add(po);	
				tableModel.removeRow(0);
			}
			FS.initCar(list);
			
		}
		   
	   }
	}