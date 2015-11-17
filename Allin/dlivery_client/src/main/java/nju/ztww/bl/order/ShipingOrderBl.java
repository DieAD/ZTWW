package nju.ztww.bl.order;

import nju.ztww.po.SendPO;
import nju.ztww.po.ShippingPO;
import nju.ztww.serviceimpl.OrderDataServiceImpl;
import nju.ztww.vo.SendVO;
import nju.ztww.vo.ShippingVO;

/**
 * 中转中心装车单的bl层
 * 
 * @author TQ
 * 
 * */

public class ShipingOrderBl {
	
	    //新的ShippingPO
	    ShippingPO shippingPO=new ShippingPO(7);
		//OrderDataService的引用
		OrderDataServiceImpl orderDataServiceImpl = new OrderDataServiceImpl();
		
		public ShipingOrderBl(){
			
		}
		
		public void handleVO(ShippingVO shippingVO){
			
		}

}
