package nju.ztww.data.commodity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import nju.ztww.po.OrderPO;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;
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

}
