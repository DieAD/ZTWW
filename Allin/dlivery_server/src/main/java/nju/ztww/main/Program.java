package nju.ztww.main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import nju.ztww.service.UserDataService;
import nju.ztww.service_stub.UserDataService_stub;

public class Program {
         public static String IP = "127.0.0.1";
         public static void main(String[] args){
        	 try{
        		 UserDataService userdataservice = new UserDataService_stub();
        		 LocateRegistry.createRegistry(1010);
        		 Naming.rebind("rmi://"+IP+":1010/UserDataService", userdataservice);
        		 System.out.println("Server strated!");
        	 }catch(Exception e){
        		 e.printStackTrace();
        	 }
         }
}
