package nju.ztww.ui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import nju.ztww.po.CarManagePO;

public class INIT_Table3 extends EditPanel {
	   
	   public INIT_Table3(String[] strings,Object[][] objects){
		   super(strings,objects);
	   }
	   
	   
	   public class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList<CarManagePO> list = new ArrayList<CarManagePO>();
			int rowNum = tableModel.getRowCount();
			for(int i=0;i<rowNum;i++){
				
			}
			
		}
		   
	   }
	}
