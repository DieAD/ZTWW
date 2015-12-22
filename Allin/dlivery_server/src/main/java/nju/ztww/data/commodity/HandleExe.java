package nju.ztww.data.commodity;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForEntryForm;
import nju.ztww.DBHelper.DBForOutStockForm;
import nju.ztww.DBHelper.DBForStock;
import nju.ztww.dao.EntryFormDO;
import nju.ztww.dao.OutStockFormDO;
import nju.ztww.dao.StockDO;

public class HandleExe {
  

public String changeExeAddStock(ArrayList<String> list) {
	// TODO Auto-generated method stub
	 DBForEntryForm dbentry=new DBForEntryForm();
	 DBForStock dbstock=new DBForStock();
	 String result="success";
	 dbentry.init();
	 dbstock.init();
	 for(int i=0;i<list.size();i++){
		 String idofcenter=list.get(i).substring(0,8);//还没检测
		 ArrayList<EntryFormDO>entrylist=new  ArrayList<EntryFormDO>(); 
		 ArrayList<StockDO>stocklist=new ArrayList<StockDO>();
		 //之后需要用到 idofcenter
		 entrylist=dbentry.queryByCenterID(list.get(i), "entryform");
		 for(int j=0;j<entrylist.size();j++){
			 entrylist.get(j).setExe(1);
			 StockDO stockdo=new StockDO();
			 stockdo.setGoodsid(entrylist.get(j).getGoodsid());
			 stockdo.setEntrytime(entrylist.get(j).getEntrytime());
			 stockdo.setAddress(entrylist.get(j).getAddress());
			 stockdo.setQu(entrylist.get(j).getQu());
			 stockdo.setPai(entrylist.get(j).getPai());
			 stockdo.setJia(entrylist.get(j).getJia());
			 stockdo.setWei(entrylist.get(j).getWei());
			 stocklist.add(stockdo);
		 }
		 String temp=dbentry.update(entrylist, "entryform");//表名之后要改
		 String temp2=dbstock.insert(stocklist, "stocktable");
		 if(temp.equals("fail")||temp2.equals("fail")){
			 result="fail";
		 }
	 }
	 dbstock.close();
	 dbentry.close();
	 return result;
}
  public  String changeExeDeleteStock(ArrayList<String> list){
	  String result="success";
	  DBForOutStockForm dbout=new DBForOutStockForm();
	  DBForStock dbstock=new DBForStock();
	 dbout.init();
	 dbstock.init();
	  for(int i=0;i<list.size();i++){
		  ArrayList<OutStockFormDO> outstockdolist=new  ArrayList<OutStockFormDO>();
		  System.out.println(list.get(i));
		  String idofCenter=list.get(i).substring(0, 8);
		  ArrayList<StockDO>stocklist=new ArrayList<StockDO>();
		  outstockdolist=dbout.queryByID(list.get(i), "outstockform");//表名需要改
		  for(int j=0;j<outstockdolist.size();j++){
			  outstockdolist.get(j).setExe(1);
			  dbstock.delete( outstockdolist.get(j).getGoodsid(), "stocktable");
		  }
		  String temp=dbout.update(outstockdolist, "outstockform");
		  if(temp.equals("fail")){
			  result="fail";
		  }
	  }
	 dbout.close();
	 dbstock.close();
	  return result;
  }
}
