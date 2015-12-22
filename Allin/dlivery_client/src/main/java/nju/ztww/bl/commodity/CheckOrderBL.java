package nju.ztww.bl.commodity;

import java.util.ArrayList;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.TracePO;
import nju.ztww.service.CheckOrderDataService;
import nju.ztww.service.CheckOrderService;
import nju.ztww.service.CommodityDataService;
import nju.ztww.service.CommodityListDataService;

public class CheckOrderBL {
	private static String IP = "127.0.0.1";
	private RMIHelper rhelper = new RMIHelper(IP,"1010");
	private CheckOrderDataService checkorderdataservice;


	public ArrayList<TracePO> findTrace(String id) {
		// TODO Auto-generated method stub
		ArrayList<TracePO> stringlist=new ArrayList<TracePO>();
		checkorderdataservice=(CheckOrderDataService)rhelper.findService("CheckOrderDataService");
		stringlist=checkorderdataservice.findTrace(id);
		
		return stringlist;
	}
	public static void main(String[]args){
		CheckOrderBL s=new CheckOrderBL();
		ArrayList<TracePO> stringlist=new ArrayList<TracePO>();
		stringlist=s.findTrace("000000002");
	}

}
