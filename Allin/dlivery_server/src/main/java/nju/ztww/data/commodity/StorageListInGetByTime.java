package nju.ztww.data.commodity;
// 数据层具体实现找List的方法（库存盘点或库存查看） 数据库表需要记录出库。
import java.text.ParseException;
import java.util.ArrayList;

import nju.ztww.DBHelper.DBForEntryForm;
import nju.ztww.DBHelper.DBForStock;
import nju.ztww.dao.EntryFormDO;
import nju.ztww.dao.StockDO;
import nju.ztww.po.StorageListLineofInPO;

public class StorageListInGetByTime {
    
	public DBForEntryForm dbforentryform=new DBForEntryForm();
	public DBForStock dbforstock=new DBForStock();
	
	
	
	//库存盘点  
	public ArrayList<StorageListLineofInPO> findInList(String time,String idofcenter) {
		dbforstock.init();
		String tableName="stocktable";
		ArrayList<StockDO>stocklist=new ArrayList<StockDO>();
		ArrayList<StorageListLineofInPO> storagelistline=new ArrayList<StorageListLineofInPO>();
		stocklist=dbforstock.queryByTime(time, tableName,idofcenter);
		for(int k=0;k<storagelistline.size();k++){
		StorageListLineofInPO storagelistlinreofin=new StorageListLineofInPO(1,
				" 没有用",
				stocklist.get(k).getGoodsid(),
				stocklist.get(k).getEntrytime(),
				stocklist.get(k).getAddress(),
				stocklist.get(k).getQu(),
				stocklist.get(k).getPai(),
				stocklist.get(k).getJia(),
				stocklist.get(k).getWei(),
				stocklist.get(k).getState(),
				stocklist.get(k).getIdofcenter()
				
	                         );
		storagelistline.add(storagelistlinreofin);
		}
		
		dbforstock.close();
		return storagelistline;
	}
	
	
	// 现在实现的时候两个时间必须不相同（入库单查看）
	public ArrayList<StorageListLineofInPO> findInList(String timebegin,String timeend,String idofcenter) throws ParseException{
		ArrayList<EntryFormDO> entryfromdolist =new ArrayList<EntryFormDO>();
		ArrayList<StorageListLineofInPO> storagelistlineofinpo=new ArrayList<StorageListLineofInPO>();
        dbforentryform.init();
        String tableName="entryform";
        if(timebegin.equals(timeend)){
        	
        	entryfromdolist=dbforentryform.queryByTime(timebegin, tableName,idofcenter);
        	for(int k=0;k<entryfromdolist.size();k++){
        		 StorageListLineofInPO storagelistlinreofin=new StorageListLineofInPO(1,
        				 "没有用",
        		    		entryfromdolist.get(k).getGoodsid(),
        		    		entryfromdolist.get(k).getEntrytime(),
        		    		entryfromdolist.get(k).getAddress(),
        		    		entryfromdolist.get(k).getQu(),
        		    		entryfromdolist.get(k).getPai(),
        		    		entryfromdolist.get(k).getJia(),
        		    		entryfromdolist.get(k).getWei(),
        		    		entryfromdolist.get(k).getState(),
        		    		entryfromdolist.get(k).getIdofcenter()
        		                         );
        		 storagelistlineofinpo.add(storagelistlinreofin);
        	}
        	System.out.println("在0");
        	System.out.println("入库单共有"+entryfromdolist.size());
        	 dbforentryform.close();
        	return  storagelistlineofinpo;
        }
        
        else{//两个时间端点不同的情况
       
        ArrayList<String>  timelist=new ArrayList<String>();
        TimeChange time=new TimeChange();
        timelist=time.timechange(timebegin, timeend);
        entryfromdolist=dbforentryform.queryByTime(timebegin,tableName,idofcenter);
        for(int i=0;i<timelist.size();i++){
        ArrayList<EntryFormDO> entryfromdolist2 =new ArrayList<EntryFormDO>();
        entryfromdolist2=dbforentryform.queryByTime(timelist.get(i), tableName,idofcenter);
       
        for(int j=0;j<entryfromdolist2.size();j++){
        	entryfromdolist.add(entryfromdolist2.get(j));	
        }
        }
       for(int k=0;k<entryfromdolist.size();k++){
	    StorageListLineofInPO storagelistlinreofin=new StorageListLineofInPO(1,
	    		"没有用",
	    		entryfromdolist.get(k).getGoodsid(),
	    		entryfromdolist.get(k).getEntrytime(),
	    		entryfromdolist.get(k).getAddress(),
	    		entryfromdolist.get(k).getQu(),
	    		entryfromdolist.get(k).getPai(),
	    		entryfromdolist.get(k).getJia(),
	    		entryfromdolist.get(k).getWei(),
	    		entryfromdolist.get(k).getState(),
	    		entryfromdolist.get(k).getIdofcenter()
	                         );
	    
	    storagelistlineofinpo.add(storagelistlinreofin);
       }
		// TODO Auto-generated method stub
	    dbforentryform.close();
	    System.out.println("入库单共有"+entryfromdolist.size());
		return storagelistlineofinpo;
	}
	}
	public static void main(String[]args) throws ParseException{
		StorageListInGetByTime slig=new StorageListInGetByTime();
		ArrayList<EntryFormDO> entryfromdolist =new ArrayList<EntryFormDO>();
		ArrayList<StorageListLineofInPO> storagelistlineofinpo=new ArrayList<StorageListLineofInPO>();
		storagelistlineofinpo=slig.findInList("15/12/09", "15/12/10", "0008");
	}
}


