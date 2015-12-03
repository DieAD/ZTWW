package nju.ztww.bl.commodity;

import java.util.ArrayList;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.service.CommodityListDataService;

public class GetStockListBL {
	private static String IP = "127.0.0.1";
	private RMIHelper rhelper = new RMIHelper(IP,"1010");
	private CommodityListDataService commoditylistdata;
	public ArrayList<StorageListLineofInPO> getStock(String idofcenter) {
		ArrayList<StorageListLineofInPO> storagelist=new ArrayList<StorageListLineofInPO>();
		commoditylistdata = (CommodityListDataService)rhelper.findService("CommodityListDataService");
		storagelist=commoditylistdata.getStock(idofcenter);
		return storagelist;
	}
}
