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
	stocklist=dbforstock.queryALL(tableName,id);
	//System.out.println("在服务器");
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
				stocklist.get(k).getState(),
				stocklist.get(k).getIdofcenter()
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
		stocklist=dbforstock.queryByQu(string, tableName,idofcenter);
		System.out.println("在服务器");
		System.out.println(stocklist.size());
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
					stocklist.get(k).getState(),
					stocklist.get(k).getIdofcenter()
		                         );
			
			storagelistline.add(storagelistlinreofin);
			}
		dbforstock.close();
		return storagelistline;

		
	}
	public static void main(String[]args){
		StockGet sg=new StockGet();
		 ArrayList<StorageListLineofInPO>stocklist=new  ArrayList<StorageListLineofInPO>();
		 StorageListLineofInPO ss=new StorageListLineofInPO(1, "", "001", "", "", "航运区", "22", "22", "23", 0,"02501");
		stocklist=sg.getStock("02501");
	}
	public void modify(ArrayList<StorageListLineofInPO> arraylistinpo,
			String idofcenter) {
		// TODO Auto-generated method stub
		dbforstock.init();
		String tableName="stocktable";//要改
		
		ArrayList<StockDO>stocklistall=new ArrayList<StockDO>();
		for(int i=0;i<arraylistinpo.size();i++){
			ArrayList<StockDO>stocklist=new ArrayList<StockDO>();
			stocklist=dbforstock.queryByID(arraylistinpo.get(i).getId(), tableName,idofcenter);
			stocklist.get(0).setQu(arraylistinpo.get(i).getQu());
			stocklist.get(0).setJia(arraylistinpo.get(i).getJia());
			stocklist.get(0).setPai(arraylistinpo.get(i).getPai());
			stocklist.get(0).setWei(arraylistinpo.get(i).getWei());
			stocklistall.add(stocklist.get(0));
		}
		dbforstock.update(stocklistall, tableName);
		dbforstock.close();
		
	}
}
