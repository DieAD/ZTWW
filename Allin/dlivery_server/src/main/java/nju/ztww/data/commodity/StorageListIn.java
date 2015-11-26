package nju.ztww.data.commodity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

import nju.ztww.DBHelper.DBForEntryForm;
import nju.ztww.DBHelper.DBForStock;
import nju.ztww.DBHelper.DBHelper;
import nju.ztww.dao.EntryFormDO;
import nju.ztww.dao.StockDO;
import nju.ztww.po.OrderPO;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;
import nju.ztww.service.CommodityDataService;
import nju.ztww.serviceimpl.StorageOutOfListDataServiceImpl;
// 实现入库data层
public class StorageListIn {
	public DBForEntryForm dbforentryform=new DBForEntryForm();
	public DBForStock  dbforstock=new DBForStock();
	public DBHelper dbhelper=new DBHelper();
	ArrayList<EntryFormDO> entryfromdolist ;
	ArrayList<StockDO>stockdolist;
public void insert(OrderPO storagelinein){
		
		FileWriter write;
		try {
			write = new FileWriter("TXT/wj.txt");
			BufferedWriter writer=new BufferedWriter(write);
			StorageListLineofInPO  storageinline=(StorageListLineofInPO)storagelinein;
			writer.write(storageinline.getId()+" "+storageinline.getData());
	
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("成功了！");
		
	}

public void insertin(ArrayList<StorageListLineofInPO> arraylist,String idofcenter) {
	// TODO Auto-generated method stub
	//找到本中转中心的库存和入库信息两个表
	for(int i=0;i<arraylist.size();i++){
		entryfromdolist.add(arraylist.get(i).changetodo());
	}
	dbforentryform.init();
	dbforstock.init();
	
	dbforentryform.insert(entryfromdolist, "entryform");
	
	dbforentryform.close();
	dbforstock.close();
}
   
}
