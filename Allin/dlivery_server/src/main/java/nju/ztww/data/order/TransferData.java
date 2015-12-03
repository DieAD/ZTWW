package nju.ztww.data.order;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForTransferForm;
import nju.ztww.po.TransferPO;
import nju.ztww.vo.IDVO;

public class TransferData {
	
	DBForTransferForm dbHelper=new DBForTransferForm();
	private ArrayList<TransferPO> list=new ArrayList<TransferPO>();   
    private TransferPO transferPO=new TransferPO(8);
    
public String insert(TransferPO transferPO){
    	
    	dbHelper.init();
		list.add(transferPO);
		String result=dbHelper.insert(list, "transferform");
		dbHelper.close();
		return result;
		
	}
	
   public String delete(String id){
		
	   dbHelper.init();
	   dbHelper.delete(id, "transferform");
	   dbHelper.close();
		return "success";
		
	}
   public TransferPO find(String id){
	   dbHelper.init();
	   ArrayList<TransferPO> list= dbHelper.queryByID(id, "transferform");
	   transferPO=list.get(0);
	   dbHelper.close();
		return transferPO;
		
	}
   
   public String update(IDVO Id){
	   dbHelper.init();
	   ArrayList<TransferPO> list= dbHelper.queryByID(Id.id, "transferform");
	   list.get(0).setExe(1);
	   String result=dbHelper.update(list, "transferform");
	   dbHelper.close();
	   return result;
	   
   }

}
