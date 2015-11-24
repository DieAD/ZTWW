package nju.ztww.bl.order;


import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.ReceivePO;
import nju.ztww.service.OrderDataService;
import nju.ztww.vo.ReceiveVO;

/**
 * 收款单的bl层
 * 
 * @author TQ
 * 
 * */

public class ReceiveOrderBl {

	   //新的ReceivePO
	   ReceivePO receivePO=new ReceivePO(5);

	   private String IP = "127.0.0.1";
	   private RMIHelper rhelper = new RMIHelper(IP,"1010");
		 
		private OrderDataService orderDataService;
		
		public ReceiveOrderBl(){
			
		}
		
		public String handleVO(ReceiveVO receiveVO){
			receivePO.setData(receiveVO.getData());
			receivePO.setOrderNumber(receiveVO.getOrderNumber());
			receivePO.setReceiveMoney(receiveVO.getReceiveMoney());
			receivePO.setReceiverName(receiveVO.getReceiverName());
			orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
			String result=orderDataService.insert(receivePO,5);
			return result;
		}

}
