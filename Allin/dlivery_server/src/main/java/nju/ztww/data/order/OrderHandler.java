package nju.ztww.data.order;

import java.util.List;

import nju.ztww.po.BusinessArrivePO;
import nju.ztww.po.CarManagePO;
import nju.ztww.po.CenterReceivePO;
import nju.ztww.po.DriverMessagePO;
import nju.ztww.po.LoadingPO;
import nju.ztww.po.MailingPO;
import nju.ztww.po.OrderPO;
import nju.ztww.po.ReceivePO;
import nju.ztww.po.SendPO;
import nju.ztww.po.ShippingPO;
import nju.ztww.po.TransferPO;

public class OrderHandler {
	
	public OrderHandler(){
		
	}
	
	public String findID(){
		return "66";
		
	}

	public String insert(OrderPO orderPO,int type){
		switch(type){
		case 1:
			MailingPO mailingPO=(MailingPO) orderPO;
		case 2:
			BusinessArrivePO businessArrivePO=(BusinessArrivePO) orderPO;
		case 3:
			CenterReceivePO centerReceivePO=(CenterReceivePO) orderPO;
		case 4:
			LoadingPO loadingPO=(LoadingPO) orderPO;
		case 5:
			ReceivePO receivePO=(ReceivePO) orderPO;
		case 6:
			SendPO sendPO=(SendPO) orderPO;
		case 7:
			ShippingPO shippingPO=(ShippingPO) orderPO;
		case 8:
			TransferPO transferPO=(TransferPO) orderPO;
		case 9:
			CarManagePO carManagePO=(CarManagePO) orderPO;
		case 10:
			DriverMessagePO driverMessagePO=(DriverMessagePO) orderPO;
		}
		
		return null;
		
	}
	
	public String delete(String id){
		
		return null;
		
	}
	
	public String find(int type){
		return null;
		
	}
	
	public String insertToDateFactory(List<OrderPO> list, int type){
		switch(type){
		case 1:
			for(OrderPO orderPO:list){
				MailingPO mailingPO=(MailingPO) orderPO;
			}
		case 2:
			for(OrderPO orderPO:list){
			    BusinessArrivePO businessArrivePO=(BusinessArrivePO) orderPO;
			}
		case 3:
			for(OrderPO orderPO:list){
			    CenterReceivePO centerReceivePO=(CenterReceivePO) orderPO;
			}
		case 4:
			for(OrderPO orderPO:list){
			    LoadingPO loadingPO=(LoadingPO) orderPO;
			}
		case 5:
			for(OrderPO orderPO:list){
			    ReceivePO receivePO=(ReceivePO) orderPO;
			}
		case 6:
			for(OrderPO orderPO:list){
		    	SendPO sendPO=(SendPO) orderPO;
			}
		case 7:
			for(OrderPO orderPO:list){
		    	ShippingPO shippingPO=(ShippingPO) orderPO;
			}
		case 8:
			for(OrderPO orderPO:list){
		    	TransferPO transferPO=(TransferPO) orderPO;
			}
		case 9:
			for(OrderPO orderPO:list){
			     CarManagePO carManagePO=(CarManagePO) orderPO;
			}
		case 10:
			for(OrderPO orderPO:list){
		    	DriverMessagePO driverMessagePO=(DriverMessagePO) orderPO;
			}
		}
		return null;
		
	}
}
