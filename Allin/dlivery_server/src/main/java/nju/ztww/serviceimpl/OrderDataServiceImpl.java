package nju.ztww.serviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import nju.ztww.data.order.MailingOrderData;
import nju.ztww.data.order.OrderHandler;
import nju.ztww.po.CarManagePO;
import nju.ztww.po.OrderPO;
import nju.ztww.po.PriceDataPO;
import nju.ztww.service.OrderDataService;

public class OrderDataServiceImpl extends UnicastRemoteObject implements OrderDataService{

	private OrderHandler orderHandler=new OrderHandler();
	private MailingOrderData mailingOrderData = new MailingOrderData();
	
	public OrderDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String findID() throws RemoteException {
		String result=orderHandler.findID();
		return result;
	}

	public String insert(OrderPO orderPO,int type) throws RemoteException {
		
		String result=orderHandler.insert(orderPO, type);

		return result;
	}

	public String delete(String id,String type) throws RemoteException {
		// TODO Auto-generated method stub
		String result=orderHandler.delete(id,type);
		return result;
	}

	public OrderPO find(String id,int type) throws RemoteException {
		// TODO Auto-generated method stub
		OrderPO result=orderHandler.find(id,type);
		return result;
	}


	public String insertToDateFactory(List<OrderPO> list, int type)
			throws RemoteException {
		String result=orderHandler.insertToDateFactory(list, type);
		return result;
	}


	public PriceDataPO getPriceData(String place1, String place2, String type)
			throws RemoteException {
		// TODO Auto-generated method stub
		PriceDataPO priceData = mailingOrderData.getPriceInfo(place1, place2, type);
		return priceData;
	}

}
