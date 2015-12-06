package nju.ztww.serviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import nju.ztww.data.order.AcceptOrderData;
import nju.ztww.data.order.MailingOrderData;
import nju.ztww.data.order.OrderHandler;
import nju.ztww.po.CarManagePO;
import nju.ztww.po.TrackPO;
import nju.ztww.po.OrderPO;
import nju.ztww.po.PriceDataPO;
import nju.ztww.service.OrderDataService;
import nju.ztww.vo.DeliverFeesVO;
import nju.ztww.vo.IDVO;

public class OrderDataServiceImpl extends UnicastRemoteObject implements OrderDataService{

	private OrderHandler orderHandler=new OrderHandler();
	private MailingOrderData mailingOrderData = new MailingOrderData();
	private AcceptOrderData acceptOrderData = new AcceptOrderData();
	
	public OrderDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String findID(String name) throws RemoteException {
		String result=orderHandler.findID(name);
		return result;
	}

	public String insert(OrderPO orderPO,int type) throws RemoteException {
		System.out.println("DataImpl");
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


	public String insertToDateFactory(List<IDVO> list, int type)
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


	public String addTrace(List<IDVO> list, int type)
			throws RemoteException {
		String result=orderHandler.addTrace(list, type);
	    return result;
	}


	public TrackPO passOrder(String order) throws RemoteException {
		// TODO Auto-generated method stub
		TrackPO mailingTrackPO = mailingOrderData.passOrder(order);
		return mailingTrackPO;
	}

	public void addTrack(TrackPO mailingTrackPO) throws RemoteException {
		// TODO Auto-generated method stub
		mailingOrderData.addTrack(mailingTrackPO);
	}

	public TrackPO passAcceptOrder(String order) throws RemoteException {
		// TODO Auto-generated method stub
		TrackPO accepTrackPO = acceptOrderData.passOrder(order);
		return null;
	}

	public double getmoney(DeliverFeesVO deliverFees) throws RemoteException {
		double distence =orderHandler.getdistence(deliverFees);
		return distence;
	}


}
