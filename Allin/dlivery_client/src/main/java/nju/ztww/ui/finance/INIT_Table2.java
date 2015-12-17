package nju.ztww.ui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import nju.ztww.dao.UserDO;
import nju.ztww.service.FinanceService;
import nju.ztww.serviceimpl.FinanceServiceImpl;

public class INIT_Table2 extends EditPanel {
	FinanceService fs =  new FinanceServiceImpl();
  public INIT_Table2(String[] strings,Object[][] objects){
	  super(strings,objects);
	  this.button1.addActionListener(new Listener());
  }
  
  public class Listener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub"ID","姓名","年龄","职务","性别"
		ArrayList<UserDO> list = new ArrayList<UserDO>();
		int rowCount = tableModel.getRowCount();
		for(int i=0;i<rowCount;i++){
			String id =(String)tableModel.getValueAt(0, 0);
			String name =(String)tableModel.getValueAt(0, 1);
			int age = (Integer)tableModel.getValueAt(0, 2);
			String position = (String)tableModel.getValueAt(0, 3);
			String _sex = (String)tableModel.getValueAt(0, 4);
			int sex = 0;
			if(_sex.equals("男")){
				sex = 0;
			}else{
				sex = 1;
			}
			UserDO user = new UserDO();
			user.setId(id);
			user.setName(name);
			user.setAge(age);
			user.setPosition(position);
			user.setSex(sex);
			list.add(user);
			tableModel.removeRow(0);
		}
		fs.initUser(list);
	}
	  
  }
}
