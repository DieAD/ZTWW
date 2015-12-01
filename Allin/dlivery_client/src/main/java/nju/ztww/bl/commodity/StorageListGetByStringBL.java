package nju.ztww.bl.commodity;

import java.util.ArrayList;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.OrderPO;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;
import nju.ztww.service.CommodityDataService;
import nju.ztww.service.CommodityListDataService;

public class StorageListGetByStringBL {
	private static String IP = "127.0.0.1";
	private RMIHelper rhelper = new RMIHelper(IP,"1010");
	private CommodityListDataService commoditylistdata;//??注意是个全局变量
	
	public ArrayList<StorageListLineofInPO> getInList(String time,String idofcenter) {
		// TODO Auto-generated method stub
		commoditylistdata = (CommodityListDataService)rhelper.findService("CommodityListDataService");
	ArrayList<StorageListLineofInPO> storagelist=new ArrayList<StorageListLineofInPO>();
	storagelist=commoditylistdata.findInList(time,idofcenter);
		return storagelist;
	}
	public ArrayList<StorageListLineofInPO> getInList(String timebegin,String timeend,String idofcenter){
		commoditylistdata = (CommodityListDataService)rhelper.findService("CommodityListDataService");
		ArrayList<StorageListLineofInPO> storagelist=new ArrayList<StorageListLineofInPO>();
		ArrayList<StorageListLineofInPO>arraylist=commoditylistdata.findInList(timebegin, timeend,idofcenter);
		System.out.println("zai BL");
		System.out.println(arraylist.get(0).getId());
		return arraylist;
		
	}
	public ArrayList<StorageListLineofOutPO> getOutList(String time,String idofcenter){
		commoditylistdata = (CommodityListDataService)rhelper.findService("CommodityListDataService");
		ArrayList<StorageListLineofOutPO>arraylist=commoditylistdata.findOutList(time,idofcenter);
		return arraylist;
		
	}
	public ArrayList<StorageListLineofOutPO> getOutList(String timebegin,String timeend,String idofcenter){ 
		commoditylistdata = (CommodityListDataService)rhelper.findService("CommodityListDataService");
		ArrayList<StorageListLineofOutPO> storagelist=new ArrayList<StorageListLineofOutPO>();
		ArrayList<StorageListLineofOutPO>arraylist=commoditylistdata.findOutList(timebegin,timeend,idofcenter);
		System.out.println(arraylist.get(0).getDestination());
		return arraylist;
	}
	    

}

