package nju.ztww.data.commodity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

import nju.ztww.DBHelper.DB;
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

public String insertin(ArrayList<StorageListLineofInPO> arraylist ,String idofcenter) {
	// TODO Auto-generated method stub
	
 DBForEntryForm dbforentryform=new DBForEntryForm();
	
	ArrayList<EntryFormDO> entryfromdolist =new ArrayList<EntryFormDO>();
	for(int i=0;i<arraylist.size();i++){
		System.out.println(arraylist.get(i).getData()+" ");
		entryfromdolist.add(arraylist.get(i).changetoIndo());
		
	}
	dbforentryform.init();
    String result=dbforentryform.insert(entryfromdolist, "entryform");
	dbforentryform.close();
	return result;
	
}

public void delete(String idoforder, String idofcenter) {
	// TODO Auto-generated method stub
	DBForEntryForm dbforentryform=new DBForEntryForm();
	dbforentryform.init();
	dbforentryform.delete(idoforder, "entryform");
	dbforentryform.close();
}

public String getLastidofcenter(String idofcenter) {
	// TODO Auto-generated method stub
	DB dbforentryform=new DB();
	String tableName="entryform";//表建多了要设置那个idofcenter 表名
	String index="";
	dbforentryform.init();
	index=dbforentryform.getSize(tableName);
	System.out.println(index);
	dbforentryform.close();
	return index;
	
}
 public static void main(String[]args){
	StorageListIn sli=new StorageListIn();
	sli.getLastidofcenter("ss");
 }
}
