package nju.ztww.data.order;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForCarManageForm;
import nju.ztww.dao.CarManageDO;
import nju.ztww.dao.HollReciFormDO;
import nju.ztww.po.BusinessArrivePO;
import nju.ztww.po.CarManagePO;

/**
 * 处理车辆管理
 * 
 * @author TQ
 *
 */
public class CarManageData {
	
	DBForCarManageForm dbHelper=new DBForCarManageForm();
	private ArrayList<CarManagePO> list=new ArrayList<CarManagePO>();   
    private CarManagePO carManagePO=new CarManagePO(9);
	
    public String insert(CarManagePO carManagePO){
    	dbHelper.init();
		list.add(carManagePO);
		String result=dbHelper.insert(list, "carmanageform");
		dbHelper.close();
		return result;
		
	}
	
   public String delete(String id){
		
	   dbHelper.init();
	   dbHelper.delete(id, "carmanageform");
	   dbHelper.close();
		return "success";
		
	}
   public CarManagePO find(String id){
	   dbHelper.init();
	   ArrayList<CarManagePO> list= dbHelper.queryByID(id, "carmanageform");
	   carManagePO=list.get(0);
		return carManagePO;
		
	}

}
