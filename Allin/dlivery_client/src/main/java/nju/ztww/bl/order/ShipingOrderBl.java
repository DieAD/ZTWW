package nju.ztww.bl.order;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.SendPO;
import nju.ztww.po.ShippingPO;
import nju.ztww.service.OrderDataService;
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
	    
	    private String IP = "127.0.0.1";
		 private RMIHelper rhelper = new RMIHelper(IP,"1010");
		 
		 private OrderDataService orderDataService;

		
		public ShipingOrderBl(){
			
		}
		
		public String handleVO(ShippingVO shippingVO){
			shippingPO.setArrivePlace(shippingVO.getArrivePlace());
			shippingPO.setCarNumber(shippingVO.getCarNumber());
			shippingPO.setData(shippingVO.getData());
			shippingPO.setJianZhuangName(shippingVO.getJianZhuangName());
			shippingPO.setMoney(shippingVO.getMoney());
			shippingPO.setOrderNumber(shippingVO.getOrderNumber());
			shippingPO.setTransferNumber(shippingVO.getTransferNumber());
			shippingPO.setYaYunName(shippingVO.getYaYunName());
			orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
			String result=orderDataService.insert(shippingPO,7);
			return result;
		}

}
