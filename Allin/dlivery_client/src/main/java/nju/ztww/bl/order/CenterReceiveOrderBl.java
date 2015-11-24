package nju.ztww.bl.order;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.BusinessArrivePO;
import nju.ztww.po.CenterReceivePO;
import nju.ztww.service.OrderDataService;
import nju.ztww.vo.BusinessArriveVO;
import nju.ztww.vo.CenterReceiveVO;

/**
 * 中转中心到达单的bl层
 * 
 * @author TQ
 * 
 * */

public class CenterReceiveOrderBl {
	//新的businessArrivePO
	CenterReceivePO centerReceivePO=new CenterReceivePO(3);
	
	 private String IP = "127.0.0.1";
	 private RMIHelper rhelper = new RMIHelper(IP,"1010");
	 
	 private OrderDataService orderDataService;

    public CenterReceiveOrderBl(){
		
	}
	
	public String handleVO(CenterReceiveVO centerReceiveVO){
		centerReceivePO.setCenterNumber(centerReceiveVO.getCenterNumber());
		centerReceivePO.setData(centerReceiveVO.getData());
		centerReceivePO.setSendPlace(centerReceiveVO.getSendPlace());
		centerReceivePO.setState(centerReceiveVO.getState());
		centerReceivePO.setTransferNumber(centerReceiveVO.getTransferNumber());
		
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		String result=orderDataService.insert(centerReceivePO,3);
		return result;
	}
}
