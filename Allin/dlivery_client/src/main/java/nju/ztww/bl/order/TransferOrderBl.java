package nju.ztww.bl.order;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.ShippingPO;
import nju.ztww.po.TransferPO;
import nju.ztww.service.OrderDataService;
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

	 private String IP = "127.0.0.1";
	 private RMIHelper rhelper = new RMIHelper(IP,"1010");
	 
	 private OrderDataService orderDataService;
	
	public TransferOrderBl(){
		
	}
	
	public String handleVO(TransferVO transferVO){
		transferPO.setArrivePlace(transferVO.getArrivePlace());
		transferPO.setCarData(transferVO.getCarData());
		transferPO.setCounterNumber(transferVO.getCounterNumber());
		transferPO.setJianZhuangName(transferVO.getJianZhuangName());
		transferPO.setMethod(transferVO.getMethod());
		transferPO.setMethodNumber(transferVO.getMethodNumber());
		transferPO.setMoney(transferVO.getMoney());
		transferPO.setSendNumber(transferVO.getSendNumber());
		transferPO.setSendPlace(transferVO.getSendPlace());
		transferPO.setTransferData(transferVO.getTransferData());
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		String result=orderDataService.insert(transferPO,8);
		return result;
	}

}
