package nju.ztww.data.order;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForHollReciForm;
import nju.ztww.DBHelper.DBForTraceForm;
import nju.ztww.dao.HollReciFormDO;
import nju.ztww.dao.TraceFormDO;
import nju.ztww.po.BusinessArrivePO;
import nju.ztww.vo.IDVO;

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
    DBForTraceForm dBForTraceForm=new DBForTraceForm();
    NowPlace nowPlace=new NowPlace();
	
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
   public String update(IDVO Id){
	   dbHelper.init();
	   ArrayList<HollReciFormDO> list= dbHelper.queryByID(Id.id, "hollreciform");
	   list.get(0).setExe(1);
	   String result=dbHelper.update(list, "hollreciform");
	   dbHelper.close();
	   return result;
	   
   }
   
   public String addTrace(IDVO Id){
	   dbHelper.init();
	   dBForTraceForm.init();
	   ArrayList<HollReciFormDO> list= dbHelper.queryByID(Id.id, "hollreciform");
	   String number=list.get(0).getGoodsid();
	   String place=nowPlace.findBusinessPlace(list.get(0).getId());
	   TraceFormDO traceFormDO=new TraceFormDO();
	   traceFormDO.setGoodsid(number);
	   traceFormDO.setTrace(place);
	   dBForTraceForm.insert(traceFormDO, "tracetable");
	   dbHelper.close();
	   dBForTraceForm.close();
	   return "success";
   }

}
