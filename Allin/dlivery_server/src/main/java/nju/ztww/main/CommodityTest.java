package nju.ztww.main;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import nju.ztww.po.OrderPO;
import nju.ztww.service.CommodityDataService;
import nju.ztww.service.UserDataService;
import nju.ztww.service_stub.UserDataService_stub;
import nju.ztww.serviceimpl.CommodityDataServiceImpl;
import nju.ztww.serviceimpl.StorageOutOfListDataServiceImpl;

public class CommodityTest {
	public static String IP = "127.0.0.1";
    public static String PORT = "1010";
    public static void main(String[] args){
   	 try{
   		CommodityDataService commoditydataservice=new StorageOutOfListDataServiceImpl();
			
	//	 UserDataService userdataservice = new UserDataServiceImpl();
   		 /*
   		  * DataService List:
   		  * 
   		  * 
   		  */
   		 LocateRegistry.createRegistry(1010);
   		 Naming.rebind("rmi://"+IP+":"+PORT+"/CommodityDataService", commoditydataservice);
   		 System.out.println("Server started!");
   	 }catch(Exception e){
   		 e.printStackTrace();
   	 }
    
    }
}
