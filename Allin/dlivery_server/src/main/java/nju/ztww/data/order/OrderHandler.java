package nju.ztww.data.order;

import java.util.List;

import nju.ztww.DBHelper.DB;
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
	
	private BusinessArriveData businessArriveData=new BusinessArriveData();
	private CarManageData carManageData=new CarManageData();
	private DriverMessageData DriverMessageData=new DriverMessageData();
	private LoadingData loadingData=new LoadingData();
	private ReceiveData receiveData=new ReceiveData();
	private SendData sendData=new SendData();
	private DB db;
	
	public OrderHandler(){
		
	}
	
	public String findID(){
		return "66";
		
	}

	public String insert(OrderPO orderPO,int type){
		String result=null;
		switch(type){
		case 1:
			MailingPO mailingPO=(MailingPO) orderPO;
			break;
		case 2:
			BusinessArrivePO businessArrivePO=(BusinessArrivePO) orderPO;
			result=businessArriveData.insert(businessArrivePO);
			break;
		case 3:
			CenterReceivePO centerReceivePO=(CenterReceivePO) orderPO;
			break;
		case 4:
			LoadingPO loadingPO=(LoadingPO) orderPO;
			result=loadingData.insert(loadingPO);
			break;
		case 5:
			ReceivePO receivePO=(ReceivePO) orderPO;
			result=receiveData.insert(receivePO);
			break;
		case 6:
			SendPO sendPO=(SendPO) orderPO;
			result=sendData.insert(sendPO);
			break;
		case 7:
			ShippingPO shippingPO=(ShippingPO) orderPO;
			break;
		case 8:
			TransferPO transferPO=(TransferPO) orderPO;
			break;
		case 9:
			CarManagePO carManagePO=(CarManagePO) orderPO;
			result=carManageData.insert(carManagePO);
			return result;
		case 10:
			DriverMessagePO driverMessagePO=(DriverMessagePO) orderPO;
			result=DriverMessageData.insert(driverMessagePO);
			break;
		}
		
		return result;
		
	}
	
	public String delete(String id,String type){
		db.delete(id, type);
		return "success";
		
	}
	
	public OrderPO find(String id,int type){
		switch(type){
		case 1:
			return null;
		case 2:
			BusinessArrivePO businessArrivePO=new BusinessArrivePO(2);
			businessArrivePO=businessArriveData.find(id);
			return businessArrivePO;
		case 3:
			return null;
		case 4:
			LoadingPO loadingPO=new LoadingPO(4);
			loadingPO=loadingData.find(id);
			return loadingPO;
		case 5:
			ReceivePO receivePO=new ReceivePO(5);
			receivePO=receiveData.find(id);
			return receivePO;
		case 6:
			SendPO sendPO=new SendPO(6);
			sendPO=sendData.find(id);
			return sendPO;
		case 7:
			return null;
		case 8:
			return null;
		case 9:
			CarManagePO carManagePO=new CarManagePO(9);
			carManagePO=carManageData.find(id);
			return carManagePO;
		case 10:
			DriverMessagePO driverMessagePO=new DriverMessagePO(10);
			driverMessagePO=DriverMessageData.find(id);
			return driverMessagePO;
		}
		
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
