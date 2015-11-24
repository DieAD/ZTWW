package nju.ztww.bl.commodity;

import java.util.ArrayList;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.StorageListLinePO;
import nju.ztww.service.CommodityDataService;

public class StorageListBL {
	private static String IP = "127.0.0.1";
    private RMIHelper rhelper = new RMIHelper(IP,"1010");
    private CommodityDataService commoditydata;
    
	public ArrayList<StorageListLinePO> getList(String idOfCenter){
		commoditydata = (CommodityDataService)rhelper.findService("CommodityDataService");
		 ArrayList<StorageListLinePO>arraylist=commoditydata.findList(idOfCenter);
		return arraylist;
	}
}
