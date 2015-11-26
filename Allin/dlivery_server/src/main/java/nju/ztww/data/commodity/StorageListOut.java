package nju.ztww.data.commodity;
//WJ  AUTHER  2015 11-18
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import nju.ztww.DBHelper.DBForEntryForm;
import nju.ztww.DBHelper.DBForOutStockForm;
import nju.ztww.DBHelper.DBForStock;
import nju.ztww.po.OrderPO;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;

public class StorageListOut {
	public DBForOutStockForm dbforoutstockform=new  DBForOutStockForm();
	public DBForStock dbforstock=new  DBForStock();
	
	public void insert(OrderPO storagelineout){
		
		FileWriter write;
		try {
			write = new FileWriter("TXT/wj.txt");
			BufferedWriter writer=new BufferedWriter(write);
			StorageListLineofOutPO  storageoutline=(StorageListLineofOutPO)storagelineout;
			writer.write(storageoutline.getId()+" "+storageoutline.getData());
	
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("成功了！");
		
	}
	public void insertout(ArrayList<StorageListLineofOutPO> arraylist,String idofcenter) {
		// TODO Auto-generated method stub
		dbforoutstockform.init();
		dbforstock.init();
		System.out.println("成功了！");
		dbforoutstockform.close();
		dbforstock.close();
	}
}
