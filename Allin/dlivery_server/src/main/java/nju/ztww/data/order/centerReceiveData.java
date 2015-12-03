package nju.ztww.data.order;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForCenterreciForm;
import nju.ztww.po.CarManagePO;
import nju.ztww.po.CenterReceivePO;
import nju.ztww.po.TransferPO;

public class centerReceiveData {
	
	DBForCenterreciForm dbHelper=new DBForCenterreciForm();
	private ArrayList<CenterReceivePO> list=new ArrayList<CenterReceivePO>();   
    private CenterReceivePO centerReceivePO=new CenterReceivePO(3);

    public String insert(CenterReceivePO centerReceivePO){
    	
    	dbHelper.init();
		list.add(centerReceivePO);
		String result=dbHelper.insert(list, "centerreciform");
		dbHelper.close();
		return result;
		
	}
    
    public String delete(String id){
		
 	   dbHelper.init();
 	   dbHelper.delete(id, "centerreciform");
 	   dbHelper.close();
 		return "success";
 		
 	}
    public CenterReceivePO find(String id){
 	   dbHelper.init();
 	   ArrayList<CenterReceivePO> list= dbHelper.queryByID(id, "centerreciform");
 	   centerReceivePO=list.get(0);
 	   return centerReceivePO;
 		
 	}
	

}
