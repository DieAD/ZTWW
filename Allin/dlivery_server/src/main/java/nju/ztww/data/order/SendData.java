package nju.ztww.data.order;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForDeliveryForm;
import nju.ztww.DBHelper.DBForLoadForm;
import nju.ztww.po.LoadingPO;
import nju.ztww.po.SendPO;
import nju.ztww.vo.IDVO;

/**
 * 处理派件单
 * @author TQ
 *
 */
public class SendData {
	
	DBForDeliveryForm dbHelper = new DBForDeliveryForm();
    private ArrayList<SendPO> list=new ArrayList<SendPO>();   
    private SendPO sendPO=new SendPO(6);
	
	public String insert(SendPO sendPO){
		dbHelper.init();
		list.add(sendPO);
		String result=dbHelper.insert(list, "deliveryform");
		list.clear();
		dbHelper.close();
		return result;
		
	}
	
   public String delete(String id){
	   dbHelper.init();
	   dbHelper.delete(id, "deliveryform");
	   dbHelper.close();
		return "success";
		
	}
   public SendPO find(String id){
	   dbHelper.init();
	   ArrayList<SendPO> list= dbHelper.queryByID(id, "deliveryform");
	   sendPO=list.get(0);
	   dbHelper.close();
	   return sendPO;
		
	}
   
   public String update(IDVO Id){
	   dbHelper.init();
	   ArrayList<SendPO> list= dbHelper.queryByID(Id.id, "deliveryform");
	   list.get(0).setExe(1);
	   String result=dbHelper.update(list, "deliveryform");
	   dbHelper.close();
	   return result;
	   
   }

}
