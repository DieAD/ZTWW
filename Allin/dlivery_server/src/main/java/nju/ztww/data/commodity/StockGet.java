package nju.ztww.data.commodity;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForStock;
import nju.ztww.dao.StockDO;
import nju.ztww.po.StorageListLineofInPO;

public class StockGet {
	public DBForStock dbforstock=new DBForStock();
	public ArrayList<StorageListLineofInPO> getStock(String id){
	dbforstock.init();
	String tableName="stocktable";
	ArrayList<StockDO>stocklist=new ArrayList<StockDO>();
	ArrayList<StorageListLineofInPO> storagelistline=new ArrayList<StorageListLineofInPO>();
	stocklist=dbforstock.queryALL(tableName);
	System.out.println("在服务器");
	for(int k=0;k<stocklist.size();k++){
		StorageListLineofInPO storagelistlinreofin=new StorageListLineofInPO(1,
				stocklist.get(k).getGoodsid(),
				stocklist.get(k).getEntrytime(),
				stocklist.get(k).getAddress(),
				stocklist.get(k).getQu(),
				stocklist.get(k).getPai(),
				stocklist.get(k).getJia(),
				stocklist.get(k).getWei()
	                         );
		
		storagelistline.add(storagelistlinreofin);
		}
	dbforstock.close();
	return storagelistline;
	}
}
