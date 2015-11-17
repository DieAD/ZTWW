package nju.ztww.bl.order;

import nju.ztww.po.ReceivePO;
import nju.ztww.po.SendPO;
import nju.ztww.serviceimpl.OrderDataServiceImpl;
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
		//OrderDataService的引用
		OrderDataServiceImpl orderDataServiceImpl = new OrderDataServiceImpl();
		
		public SendOrderBl(){
			
		}
		
		public void handleVO(SendVO sendVO){
			
		}

}
