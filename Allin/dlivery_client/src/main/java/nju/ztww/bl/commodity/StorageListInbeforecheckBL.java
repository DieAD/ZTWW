package nju.ztww.bl.commodity;
//WJ 主要用来实现添加所有未审批的入库单  这边来处理所有的未审批之前的单据
import java.util.ArrayList;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListodInPO;
import nju.ztww.service.CommodityListDataService;
//得到参数ArrayList<>
public class StorageListInbeforecheckBL {
	private static String IP = "127.0.0.1";
	private RMIHelper rhelper = new RMIHelper(IP,"1010");
	private CommodityListDataService commoditylistdata;//??注意是个全局变量
  public void changeExe() {
	  ArrayList<String> list=new ArrayList<String>();
	  
  }
}
