package nju.ztww.serviceimpl;
/*
 * @Wj
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import nju.ztww.data.commodity.StorageListOut;
import nju.ztww.po.OrderPO;
import nju.ztww.po.StorageListLinePO;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;
import nju.ztww.po.StorageListodInPO;
import nju.ztww.po.StorageListodOutPO;
import nju.ztww.service.CommodityDataService;

public class CommodityDataServiceImpl extends UnicastRemoteObject implements CommodityDataService {

	public CommodityDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insert(OrderPO po) throws RemoteException {
		
		// TODO Auto-generated method stub
		
	}

	public void delete(String idoforder,String idofcenter) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public OrderPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<StorageListLinePO> findList(String idofcenter)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String insertOut(ArrayList<StorageListLineofOutPO>  arraylistoutpo,String idofcenter)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String insertIn(ArrayList<StorageListLineofInPO>  arraylistinpo,String idofcenter)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLastidofcenter(String idofcenter) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
