package nju.ztww.bl.order;

import java.util.ArrayList;
import java.util.List;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.AcceptPO;
import nju.ztww.po.OrderPO;
import nju.ztww.po.TrackPO;
import nju.ztww.service.OrderDataService;
import nju.ztww.vo.AcceptVO;
import nju.ztww.vo.IDVO;

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

	public boolean passOrders(ArrayList<IDVO> list){
        ArrayList<String> orders  = new ArrayList<String>();
        for(IDVO vo : list){
        	String temp = vo.id;
        	orders.add(temp);
        }
		orderDataService=(OrderDataService)rHelper.findService("OrderDataService");
		for(String order : orders){
			TrackPO acceptTrackPO = orderDataService.passAcceptOrder(order);
			acceptTrackPO = adjust(acceptTrackPO);
			orderDataService.addTrack(acceptTrackPO);
		}
		return true;
	}

	private TrackPO adjust(TrackPO mailingTrackPO) {
		// TODO Auto-generated method stub
		String info = mailingTrackPO.getTrack();
		String[] infos = info.split("/");
		infos[0] = infos[0].substring(0,3);
		
		if(infos[0].equals("025")) infos[0] = "南京";
		else if(infos[0].equals("010")) infos[0] = "北京";
		else if(infos[0].equals("020")) infos[0] = "广州";
		else if(infos[0].equals("021")) infos[0] = "上海";
		
		info = "快递已在"+infos[0]+"被签收"+",签收者："+infos[2]+"，签收时间："+infos[1];
		mailingTrackPO.setTrack(info);
		return mailingTrackPO;
	}
	
}
