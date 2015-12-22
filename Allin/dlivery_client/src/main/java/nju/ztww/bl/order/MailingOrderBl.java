package nju.ztww.bl.order;

/**
 * 寄件单的bl层
 * 
 * @author TQ
  */

import java.util.ArrayList;
import java.util.List;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.LoadingPO;
import nju.ztww.po.MailingPO;
import nju.ztww.po.TrackPO;
import nju.ztww.po.OrderPO;
import nju.ztww.po.PriceDataPO;
import nju.ztww.service.OrderDataService;
import nju.ztww.ui.main.TipsUI;
import nju.ztww.vo.DeliverFeesVO;
import nju.ztww.vo.IDVO;
import nju.ztww.vo.MailingVO;

public class MailingOrderBl {
	//新的MainingPO
	MailingPO mailingPO=new MailingPO(1);

	
	 private String IP = "127.0.0.1";
	 
	 private RMIHelper rhelper = new RMIHelper(IP,"1010");
	 
	 private OrderDataService orderDataService;
	 
	 private List<OrderPO> list=new ArrayList<OrderPO>();
	 
	 private double priceConst;   //价格常量
	 private double distance;  //距离
	 private double typePrice;  //当前价格比例
	 
	
	
	public MailingOrderBl(){
		
	}
	
	public String handleVO(MailingVO mailingVO){

		mailingPO.setSendName(mailingVO.getSendName());
		mailingPO.setSendLocation(mailingVO.getSendLocation());
		mailingPO.setSendTelephone(mailingVO.getSendTelephone());
		mailingPO.setReceiveName(mailingVO.getReceiveName());
		mailingPO.setReceiveLocation(mailingVO.getReceiveLocation());
		mailingPO.setReceiveTelephone(mailingVO.getReceiveTelephone());
		mailingPO.setInfortation(mailingVO.getInfortation());
		mailingPO.setMethod(mailingVO.getMethod());
		
		mailingPO.setCount(mailingVO.getCount());
		mailingPO.setStripNumber(mailingVO.getStripNumber());

	
		mailingPO.setBusinID(mailingVO.getBusinID());
		mailingPO.setSendOrga(mailingVO.getSendOrga());
		mailingPO.setSendTEL(mailingVO.getSendTEL());
		mailingPO.setTime(mailingVO.getTime());
		mailingPO.setState(mailingVO.getState());
//		orderDataServiceImpl.insert(mailingPO);

		
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		String result=orderDataService.insert(mailingPO,1);
		return result;
	}
	
	/**
	 * 修改物流数据库
	 * 
	 * @param list
	 * @return
	 */
	public String handleAllVO(List<MailingPO> list){
		for(MailingPO temp:list){
			this.list.add(temp);
		}
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
//		String result=orderDataService.insertToDateFactory(this.list,1);
		return null;
		
	}
	
	
	public double getCost(DeliverFeesVO deliverFees){
		
		double result = 0;
		String place1 = deliverFees.getPlace1();
		String place2 = deliverFees.getPlace2();
		String type = deliverFees.getType();
		System.out.println("place1 = "+place1);
		System.out.println("place2 = "+place2);
		System.out.println("type = "+type);
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		PriceDataPO priceData = orderDataService.getPriceData(place1, place2, type);
		this.priceConst = priceData.getPriceConst();
		this.distance = priceData.getDistance();
		this.typePrice = priceData.getTypePrice();
		double weight = Double.valueOf(deliverFees.getInfo());
		double price = distance/1000*priceConst;
		result = price*weight*typePrice + deliverFees.getPackCost();
		return result;
	}
	
	public String getRandom(){
		String random = "";
		
		return random;
	}

	public void passOrders(ArrayList<IDVO> list){
		String result="success";
		 ArrayList<String> orders  = new ArrayList<String>();
	        for(IDVO vo : list){
	        	String temp = vo.id;
	        	orders.add(temp);
	        }

		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		for(String order : orders){
			TrackPO mailingTrackPO = orderDataService.passMailingOrder(order);
			mailingTrackPO = adjust(mailingTrackPO);
			String temp=orderDataService.addTrack(mailingTrackPO);
			if(temp.equals("fail")){
				result="fail";
			}
		}
		if(result.equals("success")){
			TipsUI.tip.setText("操作成功！");
		}else if(result.equals("fasil")){
			TipsUI.tip.setText("数据库错误！");
		}
		TipsUI.ifLine=true;
		
	}
	
	public TrackPO adjust(TrackPO mailingTrackPO){
		String place = mailingTrackPO.getTrack().substring(0, 3);
		if(place.equals("025")) place = "南京";
		else if(place.equals("010")) place = "北京";
		else if(place.equals("020")) place = "广州";
		else if(place.equals("021")) place = "上海";
		mailingTrackPO.setTrack("出发地："+place);
		return mailingTrackPO;
	}
}
