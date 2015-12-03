package nju.ztww.bl.order;

import java.util.ArrayList;
import java.util.List;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.OrderPO;
import nju.ztww.po.SendPO;
import nju.ztww.service.OrderDataService;
import nju.ztww.vo.IDVO;
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
	   
	   SendVO sendVO=new SendVO(6);
	   
	   private String IP = "127.0.0.1";
		 private RMIHelper rhelper = new RMIHelper(IP,"1010");
		 
		 private OrderDataService orderDataService;
		 
		 private List<IDVO> list=new ArrayList<IDVO>();

		public SendOrderBl(){
			
		}
		
		public String handleVO(SendVO sendVO){
			sendPO.setData(sendVO.getData());
			sendPO.setOrderNumber(sendVO.getOrderNumber());
			sendPO.setSenderName(sendVO.getSenderName());
			sendPO.setId(sendVO.getId());
			orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
			String result=orderDataService.insert(sendPO,6);
			return result;
		}

		public SendVO find(String id){
			orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
			sendPO=(SendPO) orderDataService.find(id, 6);
			sendVO.setData(sendPO.getData());
			sendVO.setOrderNumber(sendPO.getOrderNumber());
			sendVO.setSenderName(sendPO.getSenderName());
			sendVO.setId(sendPO.getId());
			return sendVO;
			
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
			 String result=orderDataService.insertToDateFactory(this.list,6);
			return result;
			
		}
}
