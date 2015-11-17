package nju.ztww.bl.order;


import nju.ztww.po.ReceivePO;
import nju.ztww.serviceimpl.OrderDataServiceImpl;

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
		//OrderDataService的引用
		OrderDataServiceImpl orderDataServiceImpl = new OrderDataServiceImpl();
		
		public ReceiveOrderBl(){
			
		}
		
		public void handleVO(ReceiveVO receiveVO){
			
		}

}
