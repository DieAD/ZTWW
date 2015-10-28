package nju.ztww.serviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import nju.ztww.po.OrderPO;
import nju.ztww.service.OrderDataService;

public class OrderDataServiceImpl extends UnicastRemoteObject implements OrderDataService{

	protected OrderDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insert(OrderPO orderPO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void delete(OrderPO orderPO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void find(int id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
