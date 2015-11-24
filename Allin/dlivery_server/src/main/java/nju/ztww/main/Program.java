package nju.ztww.main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import nju.ztww.service.OrderDataService;
import nju.ztww.service.UserDataService;
import nju.ztww.service_stub.UserDataService_stub;
import nju.ztww.serviceimpl.OrderDataServiceImpl;

public class Program {
         public static String IP = "127.0.0.1";
         public static String PORT = "1010";
         public static void main(String[] args){
        	 try{
        		 UserDataService userdataservice = new UserDataService_stub();
        		 OrderDataService orderDataService=new OrderDataServiceImpl();
        	//	 UserDataService userdataservice = new UserDataServiceImpl();
        		 /*
        		  * DataService List:
        		  * 
        		  * 
        		  */
        		 LocateRegistry.createRegistry(1010);
        		 Naming.rebind("rmi://"+IP+":"+PORT+"/UserDataService", userdataservice);
        		 Naming.rebind("rmi://"+IP+":"+PORT+"/OrderDataService", orderDataService);
        		 System.out.println("Server strated!");
        	 }catch(Exception e){
        		 e.printStackTrace();
        	 }
         
         }
}

