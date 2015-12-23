package nju.ztww.data.order;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForPayeeForm;
import nju.ztww.dao.HollReciFormDO;
import nju.ztww.dao.PayeeFormDO;
import nju.ztww.po.ReceivePO;
import nju.ztww.vo.IDVO;

/**
 * 处理收款单
 * @author TQ
 *
 */
public class ReceiveData {
	
	 DBForPayeeForm dbHelper=new DBForPayeeForm();
	 private ArrayList<PayeeFormDO> list=new ArrayList<PayeeFormDO>();   
	 private PayeeFormDO payeeFormDO=new PayeeFormDO();
	 private ReceivePO receivePO=new ReceivePO(5);
	
   public String insert(ReceivePO receivePO){
   	dbHelper.init();
   	payeeFormDO.setCourierid(receivePO.getReceiverName());
   	payeeFormDO.setDate(receivePO.getData());
   	payeeFormDO.setExe(receivePO.getExe());
   	payeeFormDO.setGoodsid(receivePO.getOrderNumber());
   	payeeFormDO.setHoll(receivePO.getHoll());
   	payeeFormDO.setId(receivePO.getId());
   	payeeFormDO.setMoney(receivePO.getReceiveMoney());
   	payeeFormDO.setState(receivePO.getState());
   	list.add(payeeFormDO);
   	String result=dbHelper.insert(list, "payeeform");
		list.clear();
		dbHelper.close();
		return result;
		
	}
	
  public String delete(String id){
	   dbHelper.init();
	   dbHelper.delete(id, "payeeform");
	   dbHelper.close();
	   return "success";
		
	}
  public ReceivePO find(String id){
	   dbHelper.init();
	   ArrayList<PayeeFormDO> list= dbHelper.queryByID(id, "payeeform");
	   PayeeFormDO payeeFormDO=list.get(0);
	   receivePO.setData(payeeFormDO.getDate());
	   receivePO.setId(payeeFormDO.getId());
	   receivePO.setOrderNumber(payeeFormDO.getGoodsid());
	   receivePO.setReceiveMoney(payeeFormDO.getMoney());
	   receivePO.setReceiverName(payeeFormDO.getCourierid());
	   receivePO.setHoll(payeeFormDO.getHoll());
	   dbHelper.close();
	   return receivePO;
		
	}
  
  public String update(IDVO Id){
	   dbHelper.init();
	   ArrayList<PayeeFormDO> list= dbHelper.queryByID(Id.id, "payeeform");
	   list.get(0).setExe(1);
	   String result=dbHelper.update(list, "payeeform");
	   dbHelper.close();
	   return result;
	   
  }

}
