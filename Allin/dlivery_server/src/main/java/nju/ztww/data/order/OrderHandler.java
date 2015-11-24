package nju.ztww.data.order;

import nju.ztww.po.BusinessArrivePO;
import nju.ztww.po.CenterReceivePO;
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
		}
		
		return null;
		
	}
	
	public String delete(OrderPO orderPO,int type){
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
		}
		return null;
		
	}
	
	public String find(int type){
		return null;
		
	}
}
