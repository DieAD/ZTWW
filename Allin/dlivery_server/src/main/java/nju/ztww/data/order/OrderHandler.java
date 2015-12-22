package nju.ztww.data.order;

import java.util.List;

import nju.ztww.DBHelper.DB;
import nju.ztww.DBHelper.DBForDCForm;
import nju.ztww.dao.DCFormDO;
import nju.ztww.po.AcceptPO;
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
import nju.ztww.vo.DeliverFeesVO;
import nju.ztww.vo.IDVO;

public class OrderHandler {
	



	private CarManageData carManageData=new CarManageData();
	private DriverMessageData DriverMessageData=new DriverMessageData();
	private LoadingData loadingData=new LoadingData();
	private ReceiveData receiveData=new ReceiveData();
	private SendData sendData=new SendData();
	private centerReceiveData CenterReceiveData=new centerReceiveData();
	private ShippingData shippingData=new ShippingData();
	private TransferData transferData=new TransferData();
	private DB db = new DB();
	private DBForDCForm dBForDCForm=new DBForDCForm();
	private DCFormDO dCFormDO;
	

	private BusinessArriveData businessArriveData = new BusinessArriveData();
	private MailingOrderData mailingOrderData = new MailingOrderData();
	private AcceptOrderData acceptOrderData = new AcceptOrderData();

	public OrderHandler(){
		
	}
	
	public String findID(String name){
		db.init();
		String id=db.getSize(name);
		db.close();
		return id;
		
	}
	
	public double getdistence(String place1,String place2){
		dBForDCForm.init();
		dCFormDO=dBForDCForm.query(place1, place2);
		dBForDCForm.close();
		return dCFormDO.getDistance();
	}

	public String insert(OrderPO orderPO,int type){
		String result=null;
		switch(type){
		case 1:
			MailingPO mailingPO=(MailingPO) orderPO;

			result = mailingOrderData.insert(mailingPO);
			break;

		case 2:
			BusinessArrivePO businessArrivePO=(BusinessArrivePO) orderPO;
			result=businessArriveData.insert(businessArrivePO);
			break;
		case 3:
			CenterReceivePO centerReceivePO=(CenterReceivePO) orderPO;
			result=CenterReceiveData.insert(centerReceivePO);
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
			result=shippingData.insert(shippingPO);
			break;
		case 8:
			TransferPO transferPO=(TransferPO) orderPO;
			result=transferData.insert(transferPO);
			break;
		case 9:
			CarManagePO carManagePO=(CarManagePO) orderPO;
			result=carManageData.insert(carManagePO);
			return result;
		case 10:
			DriverMessagePO driverMessagePO=(DriverMessagePO) orderPO;
			result=DriverMessageData.insert(driverMessagePO);
			break;

		case 11:
			AcceptPO acceptPO = (AcceptPO) orderPO;
			result=acceptOrderData.insert(acceptPO);
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
			CenterReceivePO centerReceivePO=new CenterReceivePO(3);
			centerReceivePO=CenterReceiveData.find(id);
			return centerReceivePO;
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
			ShippingPO shippingPO=new ShippingPO(7);
			shippingPO=shippingData.find(id);
			return shippingPO;
		case 8:
			TransferPO transferPO=new TransferPO(8);
			transferPO=transferData.find(id);
			return transferPO;
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
	
	public String insertToDateFactory(List<IDVO> list, int type){
		String result=null;
		switch(type){
		case 1:
			for(IDVO orderPO:list){
//				MailingPO mailingPO=(MailingPO) orderPO;
			}
		case 2:
			for(IDVO orderPO:list){
			    result=businessArriveData.update(orderPO);
			    if(result!="success"){
			    	return "fail";
			    }
			}
			break;
		case 3:
			for(IDVO orderPO:list){
				 result=CenterReceiveData.update(orderPO);
				    if(result!="success"){
				    	return "fail";
				    }
			}
			break;
		case 4:
			for(IDVO orderPO:list){
				result=loadingData.update(orderPO);
			    if(result!="success"){
			    	return "fail";
			    }
		    }
		    break;
		case 5:
			for(IDVO orderPO:list){
				result=receiveData.update(orderPO);
			    if(result!="success"){
			    	return "fail";
			    }
		    }
		    break;
		case 6:
			for(IDVO orderPO:list){
				result=sendData.update(orderPO);
			    if(result!="success"){
			    	return "fail";
			    }
		    }
		    break;
		case 7:
			for(IDVO orderPO:list){
				result=shippingData.update(orderPO);
			    if(result!="success"){
			    	return "fail";
			    }
		    }
		    break;
		case 8:
			for(IDVO orderPO:list){
				result=transferData.update(orderPO);
			    if(result!="success"){
			    	return "fail";
			    }
		    }
		    break;
		case 9:
			for(IDVO orderPO:list){
				result=carManageData.update(orderPO);
			    if(result!="success"){
			    	return "fail";
			    }
		    }
		    break;
		case 10:
			for(IDVO orderPO:list){
				result=DriverMessageData.update(orderPO);
			    if(result!="success"){
			    	return "fail";
			    }
		    }
		    break;
		case 11:
			for(IDVO orderPO:list){
				
			}
		}
		return result;
		
	}
	
	public String addTrace(List<IDVO> list, int type){
		String result=null;
		if(type==2){
			for(IDVO orderPO:list){
			    result=businessArriveData.addTrace(orderPO);
			}
			return result;
		}else if(type==3){
			for(IDVO orderPO:list){
			    result=CenterReceiveData.addTrace(orderPO);
			}
			return result;
		}
		return null;
		
	}
	

}
