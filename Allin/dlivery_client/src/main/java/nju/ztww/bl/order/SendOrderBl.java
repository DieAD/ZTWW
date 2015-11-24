package nju.ztww.bl.order;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.ReceivePO;
import nju.ztww.po.SendPO;
import nju.ztww.service.OrderDataService;
import nju.ztww.vo.ReceiveVO;
import nju.ztww.vo.SendVO;

/**
 * 派件单的bl层
 * 
 * @author TQ
 * 
 * */

public class SendOrderBl {
	
	   //新的SendPO
	   SendPO sendPO=new SendPO(6);
	   
	   private String IP = "127.0.0.1";
		 private RMIHelper rhelper = new RMIHelper(IP,"1010");
		 
		 private OrderDataService orderDataService;

		public SendOrderBl(){
			
		}
		
		public String handleVO(SendVO sendVO){
			sendPO.setData(sendVO.getData());
			sendPO.setOrderNumber(sendVO.getOrderNumber());
			sendPO.setSenderName(sendVO.getSenderName());
			orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
			String result=orderDataService.insert(sendPO,6);
			return result;
		}

}
