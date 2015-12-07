package nju.ztww.bl.order;


import java.util.ArrayList;
import java.util.List;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.OrderPO;
import nju.ztww.po.ReceivePO;
import nju.ztww.service.OrderDataService;
import nju.ztww.vo.IDVO;
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
	   
	   ReceiveVO receiveVO=new ReceiveVO(5);

	   private String IP = "127.0.0.1";
	   private RMIHelper rhelper = new RMIHelper(IP,"1010");
		 
		private OrderDataService orderDataService;
		
		 private List<IDVO> list=new ArrayList<IDVO>();
		
		public ReceiveOrderBl(){
			
		}
		
		public String handleVO(ReceiveVO receiveVO){
			receivePO.setData(receiveVO.getData());
			receivePO.setOrderNumber(receiveVO.getOrderNumber());
			receivePO.setReceiveMoney(receiveVO.getReceiveMoney());
			receivePO.setReceiverName(receiveVO.getReceiverName());
			receivePO.setId(receiveVO.getId());
			receivePO.setHoll(receiveVO.getHoll());
			orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
			String result=orderDataService.insert(receivePO,5);
			return result;
		}
		
		public ReceiveVO find(String id){
			orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
			receivePO=(ReceivePO) orderDataService.find(id, 5);
			receiveVO.setData(receivePO.getData());
			receiveVO.setOrderNumber(receivePO.getOrderNumber());
			receiveVO.setReceiveMoney(receivePO.getReceiveMoney());
			receiveVO.setReceiverName(receivePO.getReceiverName());
			receiveVO.setId(receivePO.getId());
			return receiveVO;
			
		}
		
		/**
		 * 修改物流数据库
		 * 
		 * @param list
		 * @return
		 */
		public String handleAllVO(List<IDVO> list){
			for(IDVO temp:list){
				this.list.add(temp);
			}
			orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
			 String result=orderDataService.insertToDateFactory(this.list,5);
			return result;
			
		}

}
