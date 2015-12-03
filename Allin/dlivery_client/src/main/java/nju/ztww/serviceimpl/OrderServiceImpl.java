package nju.ztww.serviceimpl;

/**
 * OrderService的实现
 * 
 * @author TQ
  */



import java.text.SimpleDateFormat;
import java.util.Date;

import nju.ztww.bl.order.AcceptOrderBl;
import nju.ztww.bl.order.BusinessArriveOrderBl;
import nju.ztww.bl.order.CarManageBl;
import nju.ztww.bl.order.CenterReceiveOrderBl;
import nju.ztww.bl.order.DeleteOrderBl;
import nju.ztww.bl.order.DriverMessageBl;
import nju.ztww.bl.order.FindOrderIDBl;
import nju.ztww.bl.order.LoadingOrderBl;
import nju.ztww.bl.order.MailingOrderBl;
import nju.ztww.bl.order.ReceiveOrderBl;
import nju.ztww.bl.order.SendOrderBl;
import nju.ztww.bl.order.ShipingOrderBl;
import nju.ztww.bl.order.TransferOrderBl;
import nju.ztww.service.OrderService;
import nju.ztww.ui.main.UserInfoUI;
import nju.ztww.vo.AcceptVO;
import nju.ztww.vo.BusinessArriveVO;
import nju.ztww.vo.CarManageVO;
import nju.ztww.vo.CenterReceiveVO;
import nju.ztww.vo.DeliverFeesVO;
import nju.ztww.vo.DriverMessageVO;
import nju.ztww.vo.LoadingVO;
import nju.ztww.vo.MailingVO;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.ReceiveVO;
import nju.ztww.vo.SendVO;
import nju.ztww.vo.ShippingVO;
import nju.ztww.vo.TransferVO;

public class OrderServiceImpl implements OrderService{
	
	MailingOrderBl mailingOrderBl=new MailingOrderBl();
	LoadingOrderBl loadingOrderBl=new LoadingOrderBl();
	BusinessArriveOrderBl businessArriveOrderBl=new BusinessArriveOrderBl();
	CenterReceiveOrderBl centerReceiveOrderBl=new CenterReceiveOrderBl();
	ReceiveOrderBl receiveOrderBl=new ReceiveOrderBl();
	SendOrderBl sendOrderBl=new SendOrderBl();
	ShipingOrderBl shipingOrderBl=new ShipingOrderBl();
	TransferOrderBl transferOrderBl=new TransferOrderBl();
	CarManageBl carManageBl=new CarManageBl();
	DriverMessageBl driverMessageBl=new DriverMessageBl();
	FindOrderIDBl findOrderIDBl=new FindOrderIDBl();
	DeleteOrderBl deleteOrderBl=new DeleteOrderBl();
	AcceptOrderBl acceptOrderBl = new AcceptOrderBl();
	
	
	
	public OrderServiceImpl(){
		
	}

	public OrderVO getOrder(int number) {
		String date = getDate();
		String id=null;
		switch(number){
		case 1:
			MailingVO mainingVO=new MailingVO(1);
			id=findOrderIDBl.findID();
			mainingVO.setId(date+id);
		    return mainingVO;
		case 2:
			BusinessArriveVO businessArriveVO=new BusinessArriveVO(2);
			id=findOrderIDBl.findID();
			businessArriveVO.setId(UserInfoUI.getUserID().substring(0, 8)+date+id);
		    return businessArriveVO;
		case 3:
			CenterReceiveVO centerReceiveVO=new CenterReceiveVO(3);
			id=findOrderIDBl.findID();
			centerReceiveVO.setId(UserInfoUI.getUserID().substring(0, 8)+date+id);
		    return centerReceiveVO;
		case 4:
			LoadingVO loadingVO=new LoadingVO(4);
		    id=findOrderIDBl.findID();
		    loadingVO.setId(UserInfoUI.getUserID().substring(0, 8)+date+id);
			return loadingVO;
		case 5:
			ReceiveVO receiveVO=new ReceiveVO(5);
			 id=findOrderIDBl.findID();
			 receiveVO.setId(UserInfoUI.getUserID().substring(0, 8)+date+id);
			return receiveVO;
		case 6:
			SendVO sendVO=new SendVO(6);
			 id=findOrderIDBl.findID();
			 sendVO.setId(UserInfoUI.getUserID().substring(0, 8)+date+id);
			return sendVO;
		case 7:
			ShippingVO shippingVO=new ShippingVO(7);
			id=findOrderIDBl.findID();
			shippingVO.setId(UserInfoUI.getUserID().substring(0, 8)+date+id);
			return shippingVO;
		case 8:
			TransferVO transferVO=new TransferVO(8);
			 id=findOrderIDBl.findID();
			 transferVO.setId(UserInfoUI.getUserID().substring(0, 8)+date+id);
			return transferVO;
		case 9:
			CarManageVO carManageVO=new CarManageVO(9);
			 id=findOrderIDBl.findID();
			 carManageVO.setId(UserInfoUI.getUserID().substring(0, 8)+date+id);
			return carManageVO;
		case 10:
			DriverMessageVO driverMessageVO=new DriverMessageVO(10);
			 id=findOrderIDBl.findID();
			 driverMessageVO.setId(UserInfoUI.getUserID().substring(0, 8)+date+id);
			return driverMessageVO;
		case 11:
			AcceptVO acceptVO = new AcceptVO(11);
			id = findOrderIDBl.findID();
			acceptVO.setAcceptID(date+id);
			return acceptVO;
		}
		
		return null;
	}

	public String endSales(OrderVO order, int number) {
		String result=null;
		switch(number){
		case 1:
			MailingVO mainingVO=(MailingVO)order;
			result=mailingOrderBl.handleVO(mainingVO);
			return result;
		case 2:
			BusinessArriveVO businessArriveVO=(BusinessArriveVO) order;
			result=businessArriveOrderBl.handleVO(businessArriveVO);
		    return result;
		case 3:
			CenterReceiveVO centerReceiveVO=(CenterReceiveVO) order;
			result=centerReceiveOrderBl.handleVO(centerReceiveVO);
		    return result;
		case 4:
			LoadingVO loadingVO=(LoadingVO) order;
			result=loadingOrderBl.handleVO(loadingVO);
			return "success";
		case 5:
			ReceiveVO receiveVO=(ReceiveVO) order;
			result=receiveOrderBl.handleVO(receiveVO);
			return result;
		case 6:
			SendVO sendVO=(SendVO) order;
			result=sendOrderBl.handleVO(sendVO);
			return result;
		case 7:
			ShippingVO shippingVO=(ShippingVO) order;
			result=shipingOrderBl.handleVO(shippingVO);
			return result;
		case 8:
			TransferVO transferVO=(TransferVO) order;
			result=transferOrderBl.handleVO(transferVO);
			return result;
		case 9:
			CarManageVO carManageVO=(CarManageVO) order;
			result=carManageBl.handleVO(carManageVO);
			return result;
		case 10:
			DriverMessageVO driverMessageVO=(DriverMessageVO) order;
			result=driverMessageBl.handleVO(driverMessageVO);
			return result;
		case 11:
			AcceptVO acceptVO = (AcceptVO) order;
			result = acceptOrderBl.handleVO(acceptVO);
			return result;
		}
		
		return null;
	}
	
	public OrderVO find(String id,int number) {
		switch(number){
		case 1:
			
			return null;
		case 2:
			BusinessArriveVO businessArriveVO=new BusinessArriveVO(2);
			businessArriveVO=businessArriveOrderBl.find(id);
		    return businessArriveVO;
		case 3:
			CenterReceiveVO centerReceiveVO=new CenterReceiveVO(3);
			centerReceiveVO=centerReceiveOrderBl.find(id);
		    return centerReceiveVO;
		case 4:
			LoadingVO loadingVO=new LoadingVO(4);
			loadingVO=loadingOrderBl.find(id);
			return loadingVO;
		case 5:
			ReceiveVO receiveVO=new ReceiveVO(5);
			receiveVO=receiveOrderBl.find(id);
			return receiveVO;
		case 6:
			SendVO sendVO=new SendVO(6);
			sendVO=sendOrderBl.find(id);
			return sendVO;
		case 7:
			ShippingVO shippingVO=new ShippingVO(7);
			shippingVO=shipingOrderBl.find(id);
			return shippingVO;
		case 8:
			TransferVO transferVO=new TransferVO(8);
			transferVO=transferOrderBl.find(id);
			return transferVO;
		case 9:
			CarManageVO carManageVO=new CarManageVO(9);
			carManageVO=carManageBl.find(id);
			return carManageVO;
		case 10:
			DriverMessageVO driverMessageVO=new DriverMessageVO(10);
			driverMessageVO=driverMessageBl.find(id);
			return driverMessageVO;
		}
		return null;
	}

	public double getMoney(String city, String city2,int type) {
		if((city=="北京"&&city2=="上海")||(city2=="北京"&&city=="上海")){
			return calculate(1064.7,type);
		}else if((city=="北京"&&city2=="广州")||(city2=="北京"&&city=="广州")){
			return calculate(1888.8,type);
		}else if((city=="北京"&&city2=="南京")||(city2=="北京"&&city=="南京")){
			return calculate(900,type);
		}else if((city=="上海"&&city2=="广州")||(city2=="上海"&&city=="广州")){
			return calculate(1213,type);
		}else if((city=="上海"&&city2=="南京")||(city2=="上海"&&city=="南京")){
			return calculate(266,type);
		}else if((city=="南京"&&city2=="广州")||(city2=="南京"&&city=="广州")){
			return calculate(1132,type);
		}else{
			return 0;
		}
	}

	public String getDate(String city, String city2,int type) {
		// TODO Auto-generated method stub
		return "2015-11-11";
	}

	public double calculate(double distance,int type){
		if(type==1){
			return (distance/1000)*18;
		}else if(type==2){
			return (distance/1000)*23;
		}else{
			return (distance/1000)*25;
		}
	}


	public String deleteOrder(String id,String type) {
		String result=deleteOrderBl.delete(id,type);
		return result;
}

	public double getCost(DeliverFeesVO deliverFees) {
		double result = mailingOrderBl.getCost(deliverFees);
		return result;
	}
	
	public String getOrderID(){
//		String mailingOrderID = getDate();
//		
//		String random = mailingOrderBl.getRandom();
//		mailingOrderID += random;
		String OrderID = mailingOrderBl.getRandom();
		
		return OrderID;
	}
	
	public static String getDate(){
		Date now = new Date(); 
		SimpleDateFormat matter = new SimpleDateFormat("yyMMdd");
		String date = matter.format(now);
		return date;
	}


}
