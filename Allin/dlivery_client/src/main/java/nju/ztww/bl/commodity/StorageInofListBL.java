package nju.ztww.bl.commodity;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.OrderPO;
import nju.ztww.service.CommodityDataService;

public class StorageInofListBL {
	private static String IP = "127.0.0.1";
    private RMIHelper rhelper = new RMIHelper(IP,"1010");
    private CommodityDataService commoditydata;
    
    public void addorder(OrderPO po){
    	commoditydata = (CommodityDataService)rhelper.findService("CommodityDataService");
    	commoditydata.insert(po);
    }
}
