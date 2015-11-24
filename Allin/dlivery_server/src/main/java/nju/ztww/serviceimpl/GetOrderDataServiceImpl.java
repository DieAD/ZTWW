package nju.ztww.serviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import nju.ztww.data.order.FindAllOrderHandler;
import nju.ztww.po.OrderPO;
import nju.ztww.service.GetOrderDataService;

public class GetOrderDataServiceImpl extends UnicastRemoteObject implements GetOrderDataService {
	
	private FindAllOrderHandler findAllOrderHandler=new FindAllOrderHandler();

	protected GetOrderDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<OrderPO> finds() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<OrderPO> result=findAllOrderHandler.finds();
		return result;
	}

}
