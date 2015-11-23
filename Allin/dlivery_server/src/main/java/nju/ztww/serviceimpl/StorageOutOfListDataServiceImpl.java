package nju.ztww.serviceimpl;
//WJ 实现出库单接口的实现
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import nju.ztww.data.commodity.StorageListOut;
import nju.ztww.po.OrderPO;
import nju.ztww.service.CommodityDataService;


public class StorageOutOfListDataServiceImpl extends UnicastRemoteObject implements
		CommodityDataService {  
	public StorageOutOfListDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insert(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		StorageListOut storagelistlineout=new StorageListOut();
		storagelistlineout.insert(po);
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
