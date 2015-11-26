package nju.ztww.bl.commodity;
//WJ 主要用来实现添加所有未审批的入库单
import java.util.ArrayList;

import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListodInPO;

public class StorageListInbeforecheckBL {
	public static ArrayList<ArrayList<StorageListLineofInPO>>arraylistin=new ArrayList<ArrayList<StorageListLineofInPO>>();
	public void addorder(ArrayList<StorageListLineofInPO> arraylist,String idofcenter){
		System.out.println("成了！");
		StorageListodInPO storagelistin=new StorageListodInPO(arraylist,true);
		StorageInofListBL storageinoflistbl=new StorageInofListBL();
		storageinoflistbl.addorder(storagelistin, idofcenter);
		 //arraylistin.add(arraylist);
	 }
}
