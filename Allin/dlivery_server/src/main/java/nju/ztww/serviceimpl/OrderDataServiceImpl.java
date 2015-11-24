package nju.ztww.serviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import nju.ztww.data.order.OrderHandler;
import nju.ztww.po.OrderPO;
import nju.ztww.service.OrderDataService;

public class OrderDataServiceImpl extends UnicastRemoteObject implements OrderDataService{

	private OrderHandler orderHandler=new OrderHandler();
	
	public OrderDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public String insert(OrderPO orderPO,int type) throws RemoteException {
		// TODO Auto-generated method stub
		String result=orderHandler.insert(orderPO, type);
		return result;
	}

	public String delete(OrderPO orderPO,int type) throws RemoteException {
		// TODO Auto-generated method stub
		String result=orderHandler.delete(orderPO, type);
		return result;
	}

	public String find(int id) throws RemoteException {
		// TODO Auto-generated method stub
		String result=orderHandler.find(id);
		return result;
	}

}
