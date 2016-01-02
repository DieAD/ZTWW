package nju.ztww.ui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import nju.ztww.dao.InsDO;
import nju.ztww.service.FinanceService;
import nju.ztww.serviceimpl.FinanceServiceImpl;
import confligUI.MyButton;

public class INIT_Table1 extends EditPanel {
	
	FinanceService FS = new FinanceServiceImpl();
    MyButton add = new MyButton('c');
    Dialog_init1 dia = new Dialog_init1(this);
   public INIT_Table1(String[] strings,Object[][] objects){
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
		ArrayList<InsDO> listDO = new ArrayList<InsDO>();
		int rowNum  = tableModel.getRowCount();
		int cloNum  = tableModel.getColumnCount();
		for(int i=0;i<rowNum;i++){
		   InsDO form = new InsDO();
		   form.setId((String)tableModel.getValueAt(0, 0));
		   form.setName((String)tableModel.getValueAt(0, 1));
		   form.setN1((Integer)tableModel.getValueAt(0, 2));
		   form.setN2((Integer)tableModel.getValueAt(0, 3));
		   form.setN3((Integer)tableModel.getValueAt(0, 4));
		   form.setN4((Integer)tableModel.getValueAt(0, 5));
		   form.setN5((Integer)tableModel.getValueAt(0, 6));
		   form.setN6((Integer)tableModel.getValueAt(0, 7));
		   form.setN7((Integer)tableModel.getValueAt(0, 8));
		   listDO.add(form);
		   tableModel.removeRow(0);
		   
		}
		FS.init(listDO);
	}
	   
   }
   
   public class Listener2 implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int rowNum = tableModel.getRowCount();
//		for(int i=0;i<rowNum;i++){
//			tableModel.removeRow(0);
//		}
		dia.show();
	}
	   
   }
}
