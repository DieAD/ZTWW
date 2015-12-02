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
import nju.ztww.po.StorageListodInPO;
import nju.ztww.service.CommodityDataService;
import nju.ztww.serviceimpl.StorageOutOfListDataServiceImpl;
// 实现入库data层
public class StorageListIn {
	public DBForEntryForm dbforentryform=new DBForEntryForm();
	
	ArrayList<EntryFormDO> entryfromdolist =new ArrayList<EntryFormDO>();
   
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

public void insertin(ArrayList<StorageListLineofInPO> arraylist ,String idofcenter) {
	// TODO Auto-generated method stub
	//找到本中转中心的库存和入库信息两个表
	
	for(int i=0;i<arraylist.size();i++){
		System.out.println(arraylist.get(i).getData()+" ");
		entryfromdolist.add(arraylist.get(i).changetoIndo());
		
	}
	dbforentryform.init();
	dbforentryform.insert(entryfromdolist, "entryform");
	dbforentryform.close();
	
	
}

public void delete(String idoforder, String idofcenter) {
	// TODO Auto-generated method stub
	dbforentryform.init();
	dbforentryform.delete(idoforder, "entryform");
	dbforentryform.close();
}
   
}
