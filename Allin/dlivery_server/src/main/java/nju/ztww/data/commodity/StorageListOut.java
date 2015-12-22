package nju.ztww.data.commodity;
//WJ  AUTHER  2015 11-18
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import nju.ztww.DBHelper.DB;
import nju.ztww.DBHelper.DBForEntryForm;
import nju.ztww.DBHelper.DBForOutStockForm;
import nju.ztww.DBHelper.DBForStock;
import nju.ztww.dao.OutStockFormDO;
import nju.ztww.po.OrderPO;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;
import nju.ztww.po.StorageListodOutPO;

public class StorageListOut {
	 
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
	//还需要写，没写完
	public String insertout(ArrayList<StorageListLineofOutPO> arraylistout,String idofcenter) {
		// TODO Auto-generated method stub
		DBForOutStockForm dbforoutstockform=new  DBForOutStockForm();
		ArrayList<OutStockFormDO>outstock=new ArrayList<OutStockFormDO>();
	
		dbforoutstockform.init();
		for(int i=0;i<arraylistout.size();i++){
			System.out.println(arraylistout.get(i).getData()+" ");
			outstock.add(arraylistout.get(i).changetodo());
		}
		String result=dbforoutstockform.insert(outstock, "outstockform");
		dbforoutstockform.close();
		return result;
	}
	public void delete(String idoforder, String idofcenter) {
		// TODO Auto-generated method stub
		DBForOutStockForm dbforoutstockform=new  DBForOutStockForm();
        dbforoutstockform.init();
		dbforoutstockform.delete(idoforder, "outstockform");
		dbforoutstockform.close();
	}
	public String getLastidofcenter(String idofcenter) {
		// TODO Auto-generated method stub
		DB dbforoutstockform=new  DB();
		dbforoutstockform.init();
		String tableName="outstockform";//要改
		String index="";
		index=dbforoutstockform.getSize(tableName);
	    dbforoutstockform.close();		
		return index;
	}
}
