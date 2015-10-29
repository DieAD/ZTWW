package nju.ztww.serviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import nju.ztww.po.OrderPO;
import nju.ztww.service.CommodityDataService;

public class CommodityDataServiceImpl extends UnicastRemoteObject implements CommodityDataService {

	protected CommodityDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insert(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void delete(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public OrderPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
