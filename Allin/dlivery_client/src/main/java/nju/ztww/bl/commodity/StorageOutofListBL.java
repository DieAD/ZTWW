package nju.ztww.bl.commodity;
// 写审批时限的方法步骤是 setArrayLIST  Set ischeck,然后在总单子中将这个单子remove
import java.rmi.Naming;
import java.util.ArrayList;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.OrderPO;
import nju.ztww.po.StorageListLineofOutPO;
import nju.ztww.po.StorageListodOutPO;
import nju.ztww.service.CommodityDataService;
import nju.ztww.service.UserDataService;

public class StorageOutofListBL {
	private static String IP = "127.0.0.1";
    private RMIHelper rhelper = new RMIHelper(IP,"1010");
    private CommodityDataService commoditydata;
    //两个操作 增加信息到出库列表， 在库存中删除信息
    public void addorder(StorageListodOutPO outList,String idofcenter){
    	if(outList.isIscheck()){
    	commoditydata = (CommodityDataService)rhelper.findService("CommodityDataService");
    	commoditydata.insertOut(outList.getArraylist(), idofcenter);
    	}
    }

	public void addorder(StorageListLineofOutPO storagelistlinepo) {
		// TODO Auto-generated method stub
		
	}
   
}
