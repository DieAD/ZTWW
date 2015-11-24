package nju.ztww.bl.commodity;

import java.rmi.Naming;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.OrderPO;
import nju.ztww.service.CommodityDataService;
import nju.ztww.service.UserDataService;

public class StorageOutofListBL {
	private static String IP = "127.0.0.1";
    private RMIHelper rhelper = new RMIHelper(IP,"1010");
    private CommodityDataService commoditydata;
    
    public void addorder(OrderPO po){
    	commoditydata = (CommodityDataService)rhelper.findService("CommodityDataService");
    	commoditydata.insert(po);
    }
   
}
