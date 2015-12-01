package nju.ztww.bl.commodity;

import java.util.ArrayList;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.service.CheckOrderDataService;
import nju.ztww.service.CheckOrderService;
import nju.ztww.service.CommodityDataService;
import nju.ztww.service.CommodityListDataService;

public class CheckOrderBL {
	private static String IP = "127.0.0.1";
	private RMIHelper rhelper = new RMIHelper(IP,"1010");
	private CheckOrderDataService checkorderdataservice;
	

	public ArrayList<String> findTrace(String id) {
		// TODO Auto-generated method stub
		ArrayList<String> stringlist=new ArrayList<String>();
		checkorderdataservice=(CheckOrderDataService)rhelper.findService("CheckOrderDataService");
		checkorderdataservice.findTrace(id);
		return stringlist;
	}

}
