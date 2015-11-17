package nju.ztww.serviceimpl;

/**
 * OrderService的实现
 * 
 * @author TQ
  */

import nju.ztww.bl.order.MailingOrderBl;
import nju.ztww.service.OrderService;
import nju.ztww.vo.MailingVO;
import nju.ztww.vo.OrderVO;

public class OrderServiceImpl implements OrderService{
	
	MailingOrderBl mailingOrderBl=new MailingOrderBl();
	
	public OrderServiceImpl(){
		
	}

	public OrderVO getOrder(int number) {
		switch(number){
		case 1:
			MailingVO mainingVO=new MailingVO(1);
		    return mainingVO;
		}
		return null;
	}

	public void endSales(OrderVO order, int number) {
		switch(number){
		case 1:
			MailingVO mainingVO=(MailingVO)order;
			mailingOrderBl.handleVO(mainingVO);
			break;
		}
		
	}

}
