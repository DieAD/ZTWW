package nju.ztww.data.order;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForDriverMessageForm;
import nju.ztww.po.CarManagePO;
import nju.ztww.po.DriverMessagePO;
import nju.ztww.vo.IDVO;

/**
 * 处理司机信息管理
 * @author TQ
 *
 */
public class DriverMessageData {
	
	DBForDriverMessageForm dbHelper=new DBForDriverMessageForm();
	private ArrayList<DriverMessagePO> list=new ArrayList<DriverMessagePO>();   
    private DriverMessagePO driverMessagePO=new DriverMessagePO(10);
	
    public String insert(DriverMessagePO driverMessagePO){
    	dbHelper.init();
		list.add(driverMessagePO);
		String result=dbHelper.insert(list, "drivermessageform");
		dbHelper.close();
		return result;
		
	}
	
   public String delete(String id){
		
	   dbHelper.init();
	   dbHelper.delete(id, "drivermessageform");
	   dbHelper.close();
		return "success";
		
	}
   public DriverMessagePO find(String id){
	   dbHelper.init();
	   ArrayList<DriverMessagePO> list= dbHelper.queryByID(id, "drivermessageform");
	   driverMessagePO=list.get(0);
	   dbHelper.close();
		return driverMessagePO;
		
	}
   
   public String update(IDVO Id){
	   dbHelper.init();
	   ArrayList<DriverMessagePO> list= dbHelper.queryByID(Id.id, "drivermessageform");
	   list.get(0).setExe(1);
	   String result=dbHelper.update(list, "drivermessageform");
	   dbHelper.close();
	   return result;
	   
   }

}
