package nju.ztww.data.order;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForCenterreciForm;
import nju.ztww.DBHelper.DBForTraceForm;
import nju.ztww.dao.HollReciFormDO;
import nju.ztww.dao.TraceFormDO;
import nju.ztww.po.CarManagePO;
import nju.ztww.po.CenterReceivePO;
import nju.ztww.po.TransferPO;
import nju.ztww.vo.IDVO;

public class centerReceiveData {
	
	DBForCenterreciForm dbHelper=new DBForCenterreciForm();
	private ArrayList<CenterReceivePO> list=new ArrayList<CenterReceivePO>();   
    private CenterReceivePO centerReceivePO=new CenterReceivePO(3);
    DBForTraceForm dBForTraceForm=new DBForTraceForm();
    NowPlace nowPlace=new NowPlace();

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
 	  dbHelper.close();
 	   return centerReceivePO;
 		
 	}
    
    public String update(IDVO Id){
    	dbHelper.init();
    	ArrayList<CenterReceivePO> list= dbHelper.queryByID(Id.id, "centerreciform");
    	list.get(0).setExe(1);
    	String result=dbHelper.update(list, "centerreciform");
    	dbHelper.close();
		return result;
    	
    }
	
    public String addTrace(IDVO Id){
 	   dbHelper.init();
 	   dBForTraceForm.init();
 	   ArrayList<CenterReceivePO> list= dbHelper.queryByID(Id.id, "centerreciform");
 	   String number=list.get(0).getTransferNumber();
 	   String place=nowPlace.findTransferPlace(list.get(0).getId());
 	   TraceFormDO traceFormDO=new TraceFormDO();
 	   traceFormDO.setGoodsid(number);
 	   traceFormDO.setTrace(place);
 	   dBForTraceForm.insert(traceFormDO, "tracetable");
 	   dbHelper.close();
	   dBForTraceForm.close();
 	   return "success";
    }

}
