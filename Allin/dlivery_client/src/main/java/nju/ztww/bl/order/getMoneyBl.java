package nju.ztww.bl.order;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.service.OrderDataService;
import nju.ztww.vo.DeliverFeesVO;

public class getMoneyBl {
	
	//ip地址
		 private String IP = "127.0.0.1";
		 private RMIHelper rhelper = new RMIHelper(IP,"1010");
		 
		 private OrderDataService orderDataService;
		 
		 public double getmoney(DeliverFeesVO deliverFees){
			 orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
			 double distence=orderDataService.getmoney(deliverFees.place1,deliverFees.place2);
			 if(deliverFees.type.equals("飞机")){
				 return 20*distence*(Double.parseDouble(deliverFees.info));
			 }else if(deliverFees.type.equals("火车")){
				 return 0.2*distence*(Double.parseDouble(deliverFees.info));
			 }else if(deliverFees.type.equals("汽车")){
				 return 2*distence*(Double.parseDouble(deliverFees.info));

			 }
			 return 0;
		 }

}
