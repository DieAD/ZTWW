package nju.ztww.bl.order;

import nju.ztww.po.BusinessArrivePO;
import nju.ztww.serviceimpl.OrderDataServiceImpl;
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
	//OrderDataService的引用
	OrderDataServiceImpl orderDataServiceImpl = new OrderDataServiceImpl();
	
	public BusinessArriveOrderBl(){
		
	}
	
	public void handleVO(BusinessArriveVO businessArriveVO){
		
	}
}
