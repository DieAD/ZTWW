package nju.ztww.bl.commodity;

import java.util.ArrayList;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.service.CommodityListDataService;
import nju.ztww.vo.IDVO;
//list 还没赋值
public class StorageListOutAftercheckBL {
	private static String IP = "127.0.0.1";
	private RMIHelper rhelper = new RMIHelper(IP,"1010");
	private CommodityListDataService commoditylistdata;//??注意是个全局变量
	 public void changeExeDeleteStock(ArrayList<IDVO> listVO) {
		  
		  ArrayList<String> list=new ArrayList<String>();//现在还没赋值
		  for(IDVO vo : listVO){
			  String temp = vo.id;
			  list.add(temp);
		  }
		  commoditylistdata = (CommodityListDataService)rhelper.findService("CommodityListDataService");
		  commoditylistdata.changeExeDeleteStock(list);
		  
		  
		  
	  }
	//需要判断有没有审批过
}
