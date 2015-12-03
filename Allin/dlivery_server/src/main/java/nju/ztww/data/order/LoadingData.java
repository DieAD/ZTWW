package nju.ztww.data.order;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForLoadForm;
import nju.ztww.dao.HollReciFormDO;
import nju.ztww.dao.LoadFormDO;
import nju.ztww.po.BusinessArrivePO;
import nju.ztww.po.LoadingPO;

/**
 * 处理装车单
 * @author TQ
 *
 */
public class LoadingData {
	
	DBForLoadForm dbHelper = new DBForLoadForm();
    private ArrayList<LoadingPO> list=new ArrayList<LoadingPO>();   
    private LoadingPO loadingPO=new LoadingPO(4);
	
	public String insert(LoadingPO loadingPO){
		dbHelper.init();
		list.add(loadingPO);
		String result=dbHelper.insert(list, "loadform");
		list.clear();
		dbHelper.close();
		return result;
		
	}
	
   public String delete(String id){
	   dbHelper.init();
	   dbHelper.delete(id, "loadform");
	   dbHelper.close();
		return "success";
		
	}
   public LoadingPO find(String id){
	   dbHelper.init();
	   ArrayList<LoadingPO> list= dbHelper.queryByID(id, "loadform");
	   loadingPO=list.get(0);
	   dbHelper.close();
	   return loadingPO;
		
	}

}
