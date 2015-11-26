package nju.ztww.data.order;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForHollReciForm;
import nju.ztww.dao.HollReciFormDO;
import nju.ztww.dao.UserDO;
import nju.ztww.po.BusinessArrivePO;

/**
 * 处理营业厅到达单
 * 
 * @author TQ
 *
 */
public class BusinessArriveData {
	
	DBForHollReciForm dbHelper = new DBForHollReciForm();
    private ArrayList<HollReciFormDO> list=new ArrayList<HollReciFormDO>();   
    private HollReciFormDO hollReciFormDO;
	
	public String insert(BusinessArrivePO businessArrivePO){
		dbHelper.init();
		hollReciFormDO.setArrivetime(businessArrivePO.getData());
		hollReciFormDO.setBddress(businessArrivePO.getSend());
		hollReciFormDO.setGoodsid(businessArrivePO.getNumber());
		hollReciFormDO.setGoodsstate(businessArrivePO.getOrderState());
		hollReciFormDO.setId(businessArrivePO.getId());
		list.add(hollReciFormDO);
		String result=dbHelper.insert(list, "hollreciform");
		dbHelper.close();
		return result;
		
	}
	
   public String delete(String id){
		
		return null;
		
	}
   public BusinessArrivePO find(String id){
		
		return null;
		
	}

}
