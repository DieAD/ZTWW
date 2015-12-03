package nju.ztww.bl.order;

import java.util.ArrayList;
import java.util.List;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.TransferPO;
import nju.ztww.service.OrderDataService;
import nju.ztww.vo.IDVO;
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
	TransferVO transferVO=new TransferVO(8);

	 private String IP = "127.0.0.1";
	 private RMIHelper rhelper = new RMIHelper(IP,"1010");
	 
	 private OrderDataService orderDataService;
	 
	 private List<IDVO> list=new ArrayList<IDVO>();
	
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
	
	public TransferVO find(String id){
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		transferPO=(TransferPO) orderDataService.find(id, 8);
		transferVO.setArrivePlace(transferPO.getArrivePlace());
		transferVO.setCarData(transferPO.getCarData());
		transferVO.setCounterNumber(transferPO.getCounterNumber());
		transferVO.setJianZhuangName(transferPO.getJianZhuangName());
		transferVO.setMethod(transferPO.getMethod());
		transferVO.setMethodNumber(transferPO.getMethodNumber());
		transferVO.setMoney(transferPO.getMoney());
		transferVO.setSendNumber(transferPO.getSendNumber());
		transferVO.setSendPlace(transferPO.getSendPlace());
		transferVO.setTransferData(transferPO.getTransferData());
		return transferVO;
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
		 String result=orderDataService.insertToDateFactory(this.list,8);
		return result;
		
	}

}
