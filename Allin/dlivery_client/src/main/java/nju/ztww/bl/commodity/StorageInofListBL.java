package nju.ztww.bl.commodity;

import java.util.ArrayList;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.OrderPO;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListodInPO;
import nju.ztww.po.StorageListodOutPO;
import nju.ztww.service.CommodityDataService;
import nju.ztww.vo.StorageListLineofInVO;

public class StorageInofListBL {
	private static String IP = "127.0.0.1";
    private RMIHelper rhelper = new RMIHelper(IP,"1010");
    private CommodityDataService commoditydata;
    
    
    //bl这边执行一个方法  data需要将库存列表信息增加，入库信息列表增加
   public void addorder(ArrayList<StorageListLineofInPO> arraylistinpo,String idofcenter){
	   commoditydata = (CommodityDataService)rhelper.findService("CommodityDataService");
       commoditydata.insertIn(arraylistinpo,idofcenter);
    	  
    
    }

	public void addorder(StorageListLineofInPO storagelistlinepo) {
		// TODO Auto-generated method stub
		
	}
	public void deleteOrder(String idoforder,String idofcenter){
		commoditydata = (CommodityDataService)rhelper.findService("CommodityDataService");
		commoditydata.delete(idoforder,idofcenter);
	}
	//装了所有的入库单信息
   
	 
}
