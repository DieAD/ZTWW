package nju.ztww.bl.commodity;
//WJ 处理审批的单据
import java.util.ArrayList;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListodInPO;
import nju.ztww.service.CommodityListDataService;
//得到参数ArrayList<>
public class StorageListInAftercheckBL {
	private static String IP = "127.0.0.1";
	private RMIHelper rhelper = new RMIHelper(IP,"1010");
	private CommodityListDataService commoditylistdata;//??注意是个全局变量
  public void changeExeAddStock() {
	  ArrayList<String> list=new ArrayList<String>();//现在还没赋值
	  commoditylistdata = (CommodityListDataService)rhelper.findService("CommodityListDataService");
	  commoditylistdata.changeExeAddStock(list);
	  
	  
	  
  }
}
