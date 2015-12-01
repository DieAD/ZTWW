package nju.ztww.data.finance;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForPayeeForm;
import nju.ztww.DBHelper.DBForPaymentForm;
import nju.ztww.dao.PayeeFormDO;
import nju.ztww.dao.PaymentFormDO;
import nju.ztww.po.CollectionPO;
import nju.ztww.po.PCPO;
import nju.ztww.po.PaymentPO;

public class FinanceData {
      DBForPayeeForm db = new DBForPayeeForm();
      DBForPaymentForm db2 = new DBForPaymentForm();
      DateHelper dh = new DateHelper();
      
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
      
      public boolean addPaymentForm(ArrayList<PaymentPO> list){
    	  ArrayList<PaymentPO> listPO = list;
    	  ArrayList<PaymentFormDO> listDO = new ArrayList<PaymentFormDO>();
    	  db2.init();
    	  for(PaymentPO po : listPO){
    		  PaymentFormDO form = new PaymentFormDO();
    		  form.setId("000000001");
    		  form.setDate(po.getDate());
    		  form.setMoney(po.getMoney());
    		  form.setPaymen(po.getPaymen());
    		  form.setPayaccount(po.getPayaccount());
    		  form.setPaycat(po.getPaycat());
    		  form.setPs(po.getPs());
    		  listDO.add(form);
    	  }
    	 
    	  db2.insert(listDO, "paymentform");
    	  db2.close();
    	  return true;
    	  
      }
      
     
      
      public ArrayList<PaymentPO> queryPCP(String beginTime,String endTime,String holl){
    	  ArrayList<PaymentFormDO> paymentDO  = new ArrayList<PaymentFormDO>();
    	  ArrayList<PaymentPO> paymentPO = new ArrayList<PaymentPO>();
    	  ArrayList<String> dateList = dh.SetTime(beginTime, endTime);
    	  db2.init();
    	  for(String date: dateList){
    		  paymentDO.addAll(db2.queryByDate(date, "paymentform"));
    	  }
    	  for(PaymentFormDO DO : paymentDO){
    		  PaymentPO po=new PaymentPO();
    		  po.setDate( DO.getDate());
    		  po.setMoney(DO.getMoney());
    		  po.setPayaccount(DO.getPayaccount());
    		  po.setPaycat(DO.getPaycat());
    		  po.setPaymen(DO.getPaymen());
    		  po.setPs(DO.getPs());
    		  
    		  paymentPO.add(po);
    	  }
    	  db2.close();
    	  return paymentPO;
      }
      
      public ArrayList<CollectionPO> queryPCC(String beginTime,String endTime,String holl){
    	  ArrayList<String> dateList = dh.SetTime(beginTime, endTime);
    	  ArrayList<CollectionPO> collectionPO = new ArrayList<CollectionPO>();
    	  for(String date: dateList){
    		  collectionPO.addAll(queryByDate(date,holl));
    		 
    	  }
    	  return collectionPO;
      }
      
    
}
