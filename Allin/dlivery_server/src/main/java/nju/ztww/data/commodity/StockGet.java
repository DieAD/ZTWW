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
				"没有用",
				stocklist.get(k).getGoodsid(),
				stocklist.get(k).getEntrytime(),
				stocklist.get(k).getAddress(),
				stocklist.get(k).getQu(),
				stocklist.get(k).getPai(),
				stocklist.get(k).getJia(),
				stocklist.get(k).getWei(),
				stocklist.get(k).getState()
	                         );
		
		storagelistline.add(storagelistlinreofin);
		}
	dbforstock.close();
	return storagelistline;
	}
	public ArrayList<StorageListLineofInPO> getStockByQu(String string,
			String idofcenter) {
		// TODO Auto-generated method stub
		dbforstock.init();
		String tableName="stocktable";//要改
		ArrayList<StockDO>stocklist=new ArrayList<StockDO>();
		ArrayList<StorageListLineofInPO> storagelistline=new ArrayList<StorageListLineofInPO>();
		stocklist=dbforstock.queryByQu(string, tableName);
		System.out.println("在服务器");
		for(int k=0;k<stocklist.size();k++){
			StorageListLineofInPO storagelistlinreofin=new StorageListLineofInPO(1,
					"没有用",
					stocklist.get(k).getGoodsid(),
					stocklist.get(k).getEntrytime(),
					stocklist.get(k).getAddress(),
					stocklist.get(k).getQu(),
					stocklist.get(k).getPai(),
					stocklist.get(k).getJia(),
					stocklist.get(k).getWei(),
					stocklist.get(k).getState()
		                         );
			
			storagelistline.add(storagelistlinreofin);
			}
		dbforstock.close();
		return storagelistline;

		
	}
}
