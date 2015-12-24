package nju.ztww.data.order;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForCarManageForm;
import nju.ztww.dao.CarManageDO;
import nju.ztww.dao.HollReciFormDO;
import nju.ztww.po.BusinessArrivePO;
import nju.ztww.po.CarManagePO;
import nju.ztww.vo.IDVO;

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
	   dbHelper.close();
		return carManagePO;
		
	}
   public ArrayList<CarManagePO> findAll(){
	   dbHelper.init();
	   ArrayList<CarManagePO> list= dbHelper.queryAll("carmanageform");
	   dbHelper.close();
		return list;
		
	}
   
   public String update(IDVO Id){
	   dbHelper.init();
	   ArrayList<CarManagePO> list= dbHelper.queryByID(Id.id, "carmanageform");
	   list.get(0).setExe(1);
	   String result=dbHelper.update(list, "carmanageform");
	   dbHelper.close();
	   return result;
	   
   }


}
