package nju.ztww.bl.order;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.service.OrderDataService;

public class FindOrderIDBl {
	
	private String IP = "127.0.0.1";
	 private RMIHelper rhelper = new RMIHelper(IP,"1010");
	 
	 private OrderDataService orderDataService;

	public FindOrderIDBl() {
		// TODO Auto-generated constructor stub
	}

	public String findID(String name){
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		String id=orderDataService.findID(name);
		return id;
	}
}
