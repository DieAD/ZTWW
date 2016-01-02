package nju.ztww.data.order;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForDCForm;
import nju.ztww.DBHelper.DBForOrderForm;
import nju.ztww.DBHelper.DBForTraceForm;
import nju.ztww.dao.DCFormDO;
import nju.ztww.dao.OrderFormDO;
import nju.ztww.dao.TraceFormDO;
import nju.ztww.po.BusinessArrivePO;
import nju.ztww.po.MailingPO;
import nju.ztww.po.TrackPO;
import nju.ztww.po.PriceDataPO;

public class MailingOrderData {
	DBForDCForm dbForDCForm ;
	DBForOrderForm dbForOrderForm;
	private ArrayList<OrderFormDO> list = new ArrayList<OrderFormDO>();
	private OrderFormDO orderFormDO;
	
	public PriceDataPO getPriceInfo(String place1, String place2, String type){
		PriceDataPO priceData;
		dbForDCForm = new DBForDCForm();
		dbForDCForm.init();
		DCFormDO dcForm = dbForDCForm.query(place1, place2);
		double distance = dcForm.getDistance();
		double priceConst = dcForm.getSta();
		double typePrice = 0 ;
		System.out.println("place1 = "+place1+"            place2 = "+place2+"       type = "
				+type);
		if(type.equals("标准")) typePrice = dcForm.getSta()/priceConst;
		else if(type.equals("特快")) typePrice = dcForm.getFas()/priceConst;
		else if(type.equals("经济")) typePrice = dcForm.getEco()/priceConst;
		else System.out.println("error!");
		priceData = new PriceDataPO(priceConst, distance, typePrice);
		System.out.println("priceConst = "+priceConst+"          distance = "+distance+
				"         typePrice = "+typePrice);
		dbForDCForm.close();
		return priceData;
	}
	
	public String insert(MailingPO mailingPO){

		dbForOrderForm = new DBForOrderForm();
		System.out.println("result = successful!!!!!!!!!!!!!!!!!!!!!!S");
		dbForOrderForm.init();
		orderFormDO = new OrderFormDO();
		orderFormDO.setHoll(mailingPO.getBusinID());
		orderFormDO.setUnit(mailingPO.getSendOrga());
		orderFormDO.setPhone(mailingPO.getSendTelephone());
		orderFormDO.setPretime(mailingPO.getTime()+"");
		orderFormDO.setState(mailingPO.getState());
		orderFormDO.setExe(mailingPO.getExe());
		orderFormDO.setSender(mailingPO.getSendName());
		orderFormDO.setTelephone(mailingPO.getSendTEL());
		orderFormDO.setRecip(mailingPO.getReceiveName());
		orderFormDO.setAddress(mailingPO.getReceiveLocation());
		orderFormDO.setRphone(mailingPO.getReceiveTelephone());
		orderFormDO.setOrderinfo(mailingPO.getInfortation());
		orderFormDO.setCat(mailingPO.getMethod());
		orderFormDO.setCost(mailingPO.getCount());
		orderFormDO.setOrdernumber(mailingPO.getStripNumber());
		list.add(orderFormDO);
		System.out.println("result = successful!!!!!!!!!!!!!!!!!!!!!!S");
		String result=dbForOrderForm.insert(list, "orderform");
		dbForOrderForm.close();
		System.out.println("result = successful!");
		return result;
	}
	
	 public String delete(String id){
			
			return null;
			
		}
	   public BusinessArrivePO find(String id){
			
			return null;
			
		}

	public TrackPO passOrder(String order) {

		// TODO Auto-generated method stub
		dbForOrderForm = new DBForOrderForm();
		dbForOrderForm.init();
		ArrayList<OrderFormDO> mailingOrders = dbForOrderForm.queryByID(order, "orderform");
		TrackPO mailingTrackPO = new TrackPO();
		if(!mailingOrders.isEmpty()){
			
			OrderFormDO mailingOrder = mailingOrders.get(0);
			mailingOrder.setExe(1);
			mailingTrackPO.setID(order);
			mailingTrackPO.setTrack(mailingOrder.getHoll());
			//add by wh;
			
			ArrayList<OrderFormDO> newOrders = new ArrayList<OrderFormDO>();
			newOrders.add(mailingOrder);
			dbForOrderForm.update(newOrders, "orderform");
		}
		dbForOrderForm.close();
		return mailingTrackPO;
	}

	public void addTrack(TrackPO mailingTrackPO) {
		// TODO Auto-generated method stub
		DBForTraceForm traceForm = new DBForTraceForm();
		TraceFormDO traceDO = new TraceFormDO();
		traceDO.setGoodsid(mailingTrackPO.getID());
		traceDO.setTrace(mailingTrackPO.getTrack());
		traceForm.init();
		traceForm.insert(traceDO, "tracetable");
		traceForm.close();
	}


}
