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
    private BusinessArrivePO businessArrivePO=new BusinessArrivePO(2);
	
	public String insert(BusinessArrivePO businessArrivePO){
		dbHelper.init();
		hollReciFormDO.setArrivetime(businessArrivePO.getData());
		hollReciFormDO.setBddress(businessArrivePO.getSend());
		hollReciFormDO.setGoodsid(businessArrivePO.getNumber());
		hollReciFormDO.setGoodsstate(businessArrivePO.getOrderState());
		hollReciFormDO.setId(businessArrivePO.getId());
		list.add(hollReciFormDO);
		String result=dbHelper.insert(list, "hollreciform");
		list.clear();
		dbHelper.close();
		return result;
		
	}
	
   public String delete(String id){
	   dbHelper.init();
	   dbHelper.delete(id, "hollreciform");
	   dbHelper.close();
		return "success";
		
	}
   public BusinessArrivePO find(String id){
	   dbHelper.init();
	   ArrayList<HollReciFormDO> list= dbHelper.queryByID(id, "hollreciform");
	   HollReciFormDO hollReciFormDO=list.get(0);
	   businessArrivePO.setData(hollReciFormDO.getArrivetime());
	   businessArrivePO.setId(hollReciFormDO.getId());
	   businessArrivePO.setNumber(hollReciFormDO.getGoodsid());
	   businessArrivePO.setOrderState(hollReciFormDO.getGoodsstate());
	   businessArrivePO.setSend(hollReciFormDO.getBddress());
	   dbHelper.close();
	   return businessArrivePO;
		
	}

}
