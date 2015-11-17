package nju.ztww.bl.commodity;

import java.rmi.Naming;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.service.CommodityDataService;
import nju.ztww.service.UserDataService;

public class StorageOutofListTest {
	private static String IP = "127.0.0.1";
    private  String order;
    private RMIHelper rhelper = new RMIHelper(IP,"1010");
    private CommodityDataService commoditydata;
    
    public addorder(){
    
    }
    public void setUpRMI(){
    	  try{
    	commoditydata = (CommodityDataService)Naming.lookup("rmi://"+IP+":1010/CommodityDataService");
  		 
  	  }catch(Exception e){
  		  e.printStackTrace();
  	  }
}
}
