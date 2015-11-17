package nju.ztww.bl.order;

import nju.ztww.po.ShippingPO;
import nju.ztww.po.TransferPO;
import nju.ztww.serviceimpl.OrderDataServiceImpl;
import nju.ztww.vo.ShippingVO;
import nju.ztww.vo.TransferVO;

/**
 * 中转单的bl层
 * 
 * @author TQ
 * 
 * */

public class TransferOrderBl {
	
	 //新的TransferPO
	TransferPO transferPO=new TransferPO(8);
	//OrderDataService的引用
	OrderDataServiceImpl orderDataServiceImpl = new OrderDataServiceImpl();
	
	public TransferOrderBl(){
		
	}
	
	public void handleVO(TransferVO transferVO){
		
	}

}
