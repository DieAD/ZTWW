package nju.ztww.bl.user;

import java.rmi.Naming;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.OrderPO;
import nju.ztww.po.StatePO;
import nju.ztww.service.UserDataService;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.StateVO;

public class UserBlTest {
	  private static String IP = "127.0.0.1";
      private  String order;
      private RMIHelper rhelper = new RMIHelper(IP,"1010");
     // private OrderVO orderVO;
      private  UserDataService userdataservice;
      
      
      public OrderVO checkOrder(String order) {
    	//this.setUpRMI();
    	
	    userdataservice = (UserDataService)rhelper.findService("UserDataService");
		
    	OrderPO  orderPO  = userdataservice.checkOrder(order);
    	StatePO  statePO = (StatePO)orderPO;
    	StateVO  stateVO = new StateVO(1);
    	stateVO.setCurrentPlace(statePO.getCurrentPlace());
    	stateVO.setHistoryPlace(statePO.getHistoryPlace());
    	
    	  return stateVO;
      }
      public void setUpRMI(){
    	  try{
    		  userdataservice = (UserDataService)Naming.lookup("rmi://"+IP+":1010/UserDataService");
    		 
    	  }catch(Exception e){
    		  e.printStackTrace();
    	  }
      }
}
