package nju.ztww.data.order;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForShippingForm;
import nju.ztww.po.ShippingPO;
import nju.ztww.vo.IDVO;

public class ShippingData{

	DBForShippingForm dbHelper=new DBForShippingForm();
	private ArrayList<ShippingPO> list=new ArrayList<ShippingPO>();   
    private ShippingPO shippingPO=new ShippingPO(7);
    
public String insert(ShippingPO transferPO){
    	
    	dbHelper.init();
		list.add(transferPO);
		String result=dbHelper.insert(list, "shippingform");
		dbHelper.close();
		return result;
		
	}
	
   public String delete(String id){
		
	   dbHelper.init();
	   dbHelper.delete(id, "shippingform");
	   dbHelper.close();
		return "success";
		
	}
   public ShippingPO find(String id){
	   dbHelper.init();
	   ArrayList<ShippingPO> list= dbHelper.queryByID(id, "shippingform");
	   shippingPO=list.get(0);
	   dbHelper.close();
		return shippingPO;
		
	}
   
   public String update(IDVO Id){
	   dbHelper.init();
	   ArrayList<ShippingPO> list= dbHelper.queryByID(Id.id, "shippingform");
	   list.get(0).setExe(1);
	   String result=dbHelper.update(list, "shippingform");
	   dbHelper.close();
	   return result;
	   
   }
}
