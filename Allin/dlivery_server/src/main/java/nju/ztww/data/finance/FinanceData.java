package nju.ztww.data.finance;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForPayeeForm;
import nju.ztww.dao.PayeeFormDO;
import nju.ztww.po.CollectionPO;

public class FinanceData {
      DBForPayeeForm db = new DBForPayeeForm();
      
      
      public ArrayList<CollectionPO> queryByDate(String date,String holl){
    	  ArrayList<PayeeFormDO> listDO = new ArrayList<PayeeFormDO>();
    	  ArrayList<CollectionPO> listPO = new ArrayList<CollectionPO>();
    	  
    	  
    	  db.init();
    	  listDO = db.queryByDate(date, holl, "payeeform");
    	  for(PayeeFormDO form : listDO){
    		  CollectionPO collection = new CollectionPO();
    		  collection.setDate(form.getDate());
    		  collection.setCourierid(form.getCourierid());
    		  collection.setMoney(form.getMoney());
    		  collection.setGoodsid(form.getGoodsid());
    		  listPO.add(collection);
    	  }
    	  
    	  db.close();
    	  
    	  
    	  return listPO;
    	  
      }
}
