package nju.ztww.bl.order;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.BusinessArrivePO;
import nju.ztww.service.OrderDataService;

import nju.ztww.vo.BusinessArriveVO;
import nju.ztww.vo.MailingVO;

/**
 * 营业厅到达单的bl层
 * 
 * @author TQ
 * 
 * */

public class BusinessArriveOrderBl {
	//新的businessArrivePO
	BusinessArrivePO businessArrivePO=new BusinessArrivePO(2);
	//ip地址
	 private String IP = "127.0.0.1";
	 private RMIHelper rhelper = new RMIHelper(IP,"1010");
	 
	 private OrderDataService orderDataService;
	
	public BusinessArriveOrderBl(){
		
	}
	
	public String handleVO(BusinessArriveVO businessArriveVO){
		businessArrivePO.setData(businessArriveVO.getData());
		businessArrivePO.setNumber(businessArriveVO.getNumber());
		businessArrivePO.setSend(businessArriveVO.getSend());
		businessArrivePO.setState(businessArriveVO.getState());
		
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		String result=orderDataService.insert(businessArrivePO,2);
		return result;
	}
}
