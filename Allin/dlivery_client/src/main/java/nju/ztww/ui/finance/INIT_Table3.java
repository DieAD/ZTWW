package nju.ztww.ui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import nju.ztww.po.CarManagePO;
import nju.ztww.service.FinanceService;
import nju.ztww.serviceimpl.FinanceServiceImpl;
import confligUI.MyButton;

public class INIT_Table3 extends EditPanel {
	   FinanceService FS  = new FinanceServiceImpl();
	   Dialog_init3 dia = new Dialog_init3(this);
	   MyButton add = new MyButton('c');
	   public INIT_Table3(String[] strings,Object[][] objects){
		   super(strings,objects);
		   button1.addActionListener(new Listener());
		   button3.addActionListener(new Listener2());
		   add.setIcon(new ImageIcon("photo2/back(1).png"));
		   this.add(button3);
		   this.add(add);
		   this.setOpaque(false);
		   
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
	   
	   public class Listener2 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int rowNum = tableModel.getRowCount();
//			for(int i=0;i<rowNum;i++){
//				tableModel.removeRow(0);
//			}
			dia.show();
		}
		   
	   }
	}
