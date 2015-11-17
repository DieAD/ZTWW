package nju.ztww.bl.order;

import nju.ztww.vo.OrderVO;

public class OrderBL {
   
	
	public boolean addOrder(OrderVO orderVO){
		if(orderVO!=null){
			return true;
		}else{
			return false;
		}
	}
}
