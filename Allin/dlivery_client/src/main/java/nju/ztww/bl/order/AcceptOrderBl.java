package nju.ztww.bl.order;

import java.util.List;
import java.util.ArrayList;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.AcceptPO;
import nju.ztww.po.OrderPO;
import nju.ztww.service.OrderDataService;
import nju.ztww.vo.AcceptVO;

public class AcceptOrderBl {

	AcceptPO acceptPO = new AcceptPO(11);
	
	private String IP = "127.0.0.1";
	private String port = "1010";
	private RMIHelper rHelper = new RMIHelper(IP, port);
	private OrderDataService orderDataService;
	private List<OrderPO> list = new ArrayList<OrderPO>();
	
	public String handleVO(AcceptVO acceptVO){
		
		acceptPO.setBusinID(acceptVO.getBusinID());
		acceptPO.setAcceptID(acceptVO.getAcceptID());
		acceptPO.setAccepter(acceptVO.getAccepter());
		acceptPO.setAcceptTime(acceptVO.getAcceptTime());
		acceptPO.setCourier(acceptVO.getCourierID());
		acceptPO.setExe(acceptVO.getExe());
		acceptPO.setState(acceptVO.getState());
		orderDataService = (OrderDataService)rHelper.findService("OrderDataService");
		String result = orderDataService.insert(acceptPO, 11);
		return result;
	}
	
	public String handleAllVO(List<AcceptPO> list){
		for(AcceptPO temp: list){
			this.list.add(temp);
		}
		orderDataService=(OrderDataService)rHelper.findService("OrderDataService");
//		String result = orderDataService.insertToDateFactory(this.list, 11);
		return null;
	}
}
