package nju.ztww.bl.order;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.service.OrderDataService;

/**
 * 删除Order的Bl层
 * @author TQ
 *
 */
public class DeleteOrderBl {
	
	//ip地址
	 private String IP = "127.0.0.1";
	 private RMIHelper rhelper = new RMIHelper(IP,"1010");
		 
	private OrderDataService orderDataService;

	public DeleteOrderBl() {
		
	}
	
	public String delete(String id,String type){
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		String result=orderDataService.delete(id,type);
		return result;
	}

}
