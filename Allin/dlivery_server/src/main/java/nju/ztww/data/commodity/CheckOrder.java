package nju.ztww.data.commodity;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForTraceForm;
import nju.ztww.dao.TraceFormDO;

public class CheckOrder {
    public  DBForTraceForm  dbfortraceform=new DBForTraceForm ();
	public ArrayList<String> findTrace(String id) {
		// TODO Auto-generated method stub
		ArrayList<TraceFormDO> traceformdolist=new ArrayList<TraceFormDO>();
		ArrayList<String> stringist=new ArrayList<String>(); 
		String tableName="traceform";
		dbfortraceform.init();
		traceformdolist=dbfortraceform.queryByID(id, tableName);
		dbfortraceform.close();
		for(int i=0;i<traceformdolist.size();i++){
			String trace=traceformdolist.get(i).getTrace();
			stringist.add(trace);
		}
		return stringist;
	}

}
