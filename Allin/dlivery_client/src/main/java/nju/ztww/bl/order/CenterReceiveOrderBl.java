package nju.ztww.bl.order;

import java.util.ArrayList;
import java.util.List;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.BusinessArrivePO;
import nju.ztww.po.CarManagePO;
import nju.ztww.po.CenterReceivePO;
import nju.ztww.po.OrderPO;
import nju.ztww.service.OrderDataService;
import nju.ztww.vo.BusinessArriveVO;
import nju.ztww.vo.CarManageVO;
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
	 
	 private CenterReceiveVO centerReceiveVO=new CenterReceiveVO(3);
	 
	 private List<OrderPO> list=new ArrayList<OrderPO>();

    public CenterReceiveOrderBl(){
		
	}
	
	public String handleVO(CenterReceiveVO centerReceiveVO){
		centerReceivePO.setCenterNumber(centerReceiveVO.getCenterNumber());
		centerReceivePO.setData(centerReceiveVO.getData());
		centerReceivePO.setSendPlace(centerReceiveVO.getSendPlace());
		centerReceivePO.setState(centerReceiveVO.getState());
		centerReceivePO.setTransferNumber(centerReceiveVO.getTransferNumber());
		centerReceivePO.setId(centerReceiveVO.getId());
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		String result=orderDataService.insert(centerReceivePO,3);
		return result;
	}
	
	public CenterReceiveVO find(String id){
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		centerReceivePO=(CenterReceivePO) orderDataService.find(id, 3);
		centerReceiveVO.setCenterNumber(centerReceivePO.getCenterNumber());
		centerReceiveVO.setData(centerReceivePO.getData());
		centerReceiveVO.setSendPlace(centerReceivePO.getSendPlace());
		centerReceiveVO.setState(centerReceivePO.getState());
		centerReceiveVO.setTransferNumber(centerReceivePO.getTransferNumber());
		centerReceiveVO.setId(centerReceivePO.getId());
		return centerReceiveVO;
	}
	
	/**
	 * 修改物流数据库
	 * 
	 * @param list
	 * @return
	 */
	public String handleAllVO(List<CenterReceivePO> list){
		for(CenterReceivePO temp:list){
			this.list.add(temp);
		}
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		String result=orderDataService.insertToDateFactory(this.list,3);
		return result;
		
	}
}
