package nju.ztww.main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import nju.ztww.service.CommodityDataService;
import nju.ztww.serviceimpl.StorageInOfListDataServiceImpl;
import nju.ztww.serviceimpl.StorageOutOfListDataServiceImpl;

public class InTest {
	public static String IP = "127.0.0.1";
    public static String PORT = "1010";
    public static void main(String[] args){
   	 try{
   		CommodityDataService commoditydataservice=new StorageInOfListDataServiceImpl();
			
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
