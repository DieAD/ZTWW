package nju.ztww.data.commodity;
//WJ  AUTHER  2015 11-18
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import nju.ztww.po.OrderPO;
import nju.ztww.po.StorageListLineofOutPO;

public class StorageListOut {
	public void insert(OrderPO storagelineout){
		
		FileWriter write;
		try {
			write = new FileWriter("TXT/wj.txt");
			BufferedWriter writer=new BufferedWriter(write);
			StorageListLineofOutPO  storageoutline=(StorageListLineofOutPO)storagelineout;
			writer.write(storageoutline.getId()+" "+storageoutline.getData()
	);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("成功了！");
		
	}

}
