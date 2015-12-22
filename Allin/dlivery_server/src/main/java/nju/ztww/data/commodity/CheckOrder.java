package nju.ztww.data.commodity;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForTraceForm;
import nju.ztww.dao.TraceFormDO;
import nju.ztww.po.TracePO;

public class CheckOrder {
    public  DBForTraceForm  dbfortraceform=new DBForTraceForm ();
	public ArrayList<TracePO> findTrace(String id) {
		// TODO Auto-generated method stub
		ArrayList<TraceFormDO> traceformdolist=new ArrayList<TraceFormDO>();
		ArrayList<TracePO> stringist=new ArrayList<TracePO>(); 
		String tableName="tracetable";
		dbfortraceform.init();
		traceformdolist=dbfortraceform.queryByID(id, tableName);
		dbfortraceform.close();
		for(int i=0;i<traceformdolist.size();i++){
			TracePO tpo=new TracePO();
			 tpo.setTrace(traceformdolist.get(i).getTrace());
			//System.out.println(tpo.getTrace());
			stringist.add(tpo);
		}
		return stringist;
	}
   public static void main(String[]args){
	   CheckOrder co=new CheckOrder();
	   DBForTraceForm  dbfortraceform=new DBForTraceForm ();
	   ArrayList<TracePO> stringist=new ArrayList<TracePO>();
	   stringist=co.findTrace("000000002") ;
   }
public void modifyBaoJing(String idofcenter, String number) {
	// TODO Auto-generated method stub
	dbfortraceform.init();
	TraceFormDO tdo=new TraceFormDO();
	tdo.setGoodsid(idofcenter);
	tdo.setTrace(number);
	dbfortraceform.update(tdo, "tracetable");
	
	
	
	dbfortraceform.close();
	
}
public void modifyDao(String idofcenter, String number) {
	// TODO Auto-generated method stub
	dbfortraceform.init();
	TraceFormDO tdo=new TraceFormDO();
	tdo.setGoodsid(idofcenter);// idofcenter 设置为盘点 加5位
	tdo.setTrace(number);
	System.out.println(number);
	dbfortraceform.update(tdo, "tracetable");
	dbfortraceform.close();
	
}
}
