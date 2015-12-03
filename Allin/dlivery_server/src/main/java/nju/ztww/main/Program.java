package nju.ztww.main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import nju.ztww.service.CheckOrderDataService;
import nju.ztww.service.CommodityDataService;
import nju.ztww.service.CommodityListDataService;
import nju.ztww.service.FinanceDataService;
import nju.ztww.service.OrderDataService;
import nju.ztww.service.UserDataService;
import nju.ztww.serviceimpl.CheckOrderDataServiceImpl;
import nju.ztww.serviceimpl.CommodityListDataServiceImpl;
import nju.ztww.serviceimpl.FinanceDataServiceImpl;
import nju.ztww.serviceimpl.OrderDataServiceImpl;
import nju.ztww.serviceimpl.StorageInOfListDataServiceImpl;
import nju.ztww.serviceimpl.StorageOutOfListDataServiceImpl;
import nju.ztww.serviceimpl.UserDataServiceImpl;


public class Program {
         public static String IP = "127.0.0.1";
         public static int PORT = 1010;
         public static void main(String[] args){
        	 try{

        	
        		 OrderDataService orderDataService=new OrderDataServiceImpl();      		
        		 UserDataService userdataservice = new UserDataServiceImpl();
        		 CommodityDataService commoditydataservice=new StorageInOfListDataServiceImpl();
        		 CommodityDataService  commoditydataserviceout=new StorageOutOfListDataServiceImpl();
        		 CommodityListDataService  commoditylistdataservice=new  CommodityListDataServiceImpl();
        		// FinanceDataService  financedataservice = new FinanceDataServiceImpl();
        		 CheckOrderDataService checkorderdataservice=new CheckOrderDataServiceImpl();
        		 LocateRegistry.createRegistry(PORT);
        		 Naming.rebind("rmi://"+IP+":"+PORT+"/UserDataService", userdataservice);       		
        		 Naming.rebind("rmi://"+IP+":"+PORT+"/OrderDataService", orderDataService);
        		 Naming.rebind("rmi://"+IP+":"+PORT+"/CommodityDataService", commoditydataservice);
        		 Naming.rebind("rmi://"+IP+":"+PORT+"/CommodityDataServiceOut", commoditydataserviceout);
        		 Naming.rebind("rmi://"+IP+":"+PORT+"/CommodityListDataService", commoditylistdataservice);
        		// Naming.rebind("rmi://"+IP+":"+PORT+"/FinanceDataService", financedataservice);
        		 Naming.rebind("rmi://"+IP+":"+PORT+"/CheckOrderDataService", checkorderdataservice);
        		 
        		// LocateRegistry.createRegistry(PORT);
        		 System.out.println("Server strated!");
        	 }catch(Exception e){
        		 e.printStackTrace();
        	 }
         
         }
}

