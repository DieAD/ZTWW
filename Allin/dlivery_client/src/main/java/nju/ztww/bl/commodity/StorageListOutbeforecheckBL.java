package nju.ztww.bl.commodity;

import java.util.ArrayList;
import nju.ztww.po.StorageListLineofOutPO;

public class StorageListOutbeforecheckBL {
	public static ArrayList<ArrayList<StorageListLineofOutPO>>arraylistin=new ArrayList<ArrayList<StorageListLineofOutPO>>();
	public void addorder(ArrayList<StorageListLineofOutPO> arraylist,String idofcenter){
		 arraylistin.add(arraylist);
	 }
	//需要判断有没有审批过
}
