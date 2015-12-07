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
		storagelist=commoditylistdata.findInList(timebegin, timeend,idofcenter);
		System.out.println("zai BL");

		return storagelist;
		
	}
	public ArrayList<StorageListLineofOutPO> getOutList(String time,String idofcenter){
		commoditylistdata = (CommodityListDataService)rhelper.findService("CommodityListDataService");
		ArrayList<StorageListLineofOutPO>arraylist=commoditylistdata.findOutList(time,idofcenter);
		
		return arraylist;
		
	}
	public ArrayList<StorageListLineofOutPO> getOutList(String timebegin,String timeend,String idofcenter){ 
		commoditylistdata = (CommodityListDataService)rhelper.findService("CommodityListDataService");
		ArrayList<StorageListLineofOutPO> storagelist=new ArrayList<StorageListLineofOutPO>();
      storagelist=commoditylistdata.findOutList(timebegin,timeend,idofcenter);

		 System.out.println("客服端"+ storagelist.size());
		 
		return storagelist;
	}
	    
  public static void main(String[]args){
	  StorageListGetByStringBL ss=new StorageListGetByStringBL();
	  ArrayList<StorageListLineofOutPO> list=new ArrayList<StorageListLineofOutPO>();
	  list=ss.getOutList("15/11/29", "15/12/02", "00");
	 
  }
}

