package nju.ztww.bl.order;

import java.util.ArrayList;
import java.util.List;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.BusinessArrivePO;
import nju.ztww.po.OrderPO;
import nju.ztww.service.OrderDataService;
import nju.ztww.ui.main.Login;
import nju.ztww.vo.BusinessArriveVO;
import nju.ztww.vo.IDVO;
import nju.ztww.vo.MailingVO;
import nju.ztww.vo.OrderVO;

/**
 * 营业厅到达单的bl层
 * 
 * @author TQ
 * 
 * */

public class BusinessArriveOrderBl {
	//新的businessArrivePO
	BusinessArrivePO businessArrivePO=new BusinessArrivePO(2);
	
	BusinessArriveVO businessArriveVO=new BusinessArriveVO(2);
	//ip地址
	 private String IP = "127.0.0.1";
	 private RMIHelper rhelper = new RMIHelper(IP,"1010");
	 
	 private OrderDataService orderDataService;
	 
	 private List<IDVO> list=new ArrayList<IDVO>();
	
	public BusinessArriveOrderBl(){
		
	}
	
	/**
	 * 将单据添加到临时数据库
	 * 
	 * @param businessArriveVO
	 * @return
	 */
	public String handleVO(BusinessArriveVO businessArriveVO){
		businessArrivePO.setData(businessArriveVO.getData());
		businessArrivePO.setNumber(businessArriveVO.getNumber());
		businessArrivePO.setSend(businessArriveVO.getSend());
		businessArrivePO.setOrderState(businessArriveVO.getOrderState());
		businessArrivePO.setId(businessArriveVO.getId());

		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		String result=orderDataService.insert(businessArrivePO,2);
		return result;
	}
	
	public BusinessArriveVO find(String id){
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		businessArrivePO= (BusinessArrivePO) orderDataService.find(id, 2);
		businessArriveVO.setData(businessArrivePO.getData());
		businessArriveVO.setNumber(businessArrivePO.getNumber());
		businessArriveVO.setSend(businessArrivePO.getSend());
		businessArriveVO.setOrderState(businessArrivePO.getOrderState());
		businessArriveVO.setId(businessArrivePO.getId());
		return businessArriveVO;
		
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
		String result=orderDataService.insertToDateFactory(this.list, 2);
		orderDataService.addTrace(this.list, 2);
		return result;
		
	}
}
