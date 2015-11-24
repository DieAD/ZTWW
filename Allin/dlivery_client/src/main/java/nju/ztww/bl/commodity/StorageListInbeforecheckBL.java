package nju.ztww.bl.commodity;
//WJ 主要用来实现添加所有未审批的入库单
import java.util.ArrayList;

import nju.ztww.po.StorageListLineofInPO;

public class StorageListInbeforecheckBL {
	public static ArrayList<ArrayList<StorageListLineofInPO>>arraylistin=new ArrayList<ArrayList<StorageListLineofInPO>>();
	public void addorder(ArrayList<StorageListLineofInPO> arraylist,String idofcenter){
		 arraylistin.add(arraylist);
	 }
}
