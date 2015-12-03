package nju.ztww.bl.order;

import java.util.ArrayList;
import java.util.List;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.OrderPO;
import nju.ztww.po.ShippingPO;
import nju.ztww.service.OrderDataService;
import nju.ztww.vo.IDVO;
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
		 
		 private ShippingVO shippingVO=new ShippingVO(7);
		 
		 private List<IDVO> list=new ArrayList<IDVO>();

		
		public ShipingOrderBl(){
			
		}
		
		public String handleVO(ShippingVO shippingVO){
			shippingPO.setArrivePlace(shippingVO.getArrivePlace());
			shippingPO.setCarNumber(shippingVO.getCarNumber());
			shippingPO.setData(shippingVO.getData());
			shippingPO.setJianZhuangName(shippingVO.getJianZhuangName());
			shippingPO.setMoney(shippingVO.getMoney());
			shippingPO.setOrderNumber(shippingVO.getOrderNumber());
			shippingPO.setQiYunNumber(shippingVO.getQiYunNumber());
			shippingPO.setYaYunName(shippingVO.getYaYunName());
			shippingPO.setId(shippingVO.getId());
			orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
			String result=orderDataService.insert(shippingPO,7);
			return result;
		}

		public ShippingVO find(String id){
			orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
			shippingPO=(ShippingPO) orderDataService.find(id, 7);
			shippingVO.setArrivePlace(shippingPO.getArrivePlace());
			shippingVO.setCarNumber(shippingPO.getCarNumber());
			shippingVO.setData(shippingPO.getData());
			shippingVO.setJianZhuangName(shippingPO.getJianZhuangName());
			shippingVO.setMoney(shippingPO.getMoney());
			shippingVO.setOrderNumber(shippingPO.getOrderNumber());
			shippingVO.setQiYunNumber(shippingPO.getQiYunNumber());
			shippingVO.setYaYunName(shippingPO.getYaYunName());
			shippingVO.setId(shippingPO.getId());
			return shippingVO;
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
		    String result=orderDataService.insertToDateFactory(this.list,7);
			return result;
			
		}
}
