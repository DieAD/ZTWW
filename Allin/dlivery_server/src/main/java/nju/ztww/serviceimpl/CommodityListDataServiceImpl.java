package nju.ztww.serviceimpl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import nju.ztww.data.commodity.StorageListInGetByTime;
import nju.ztww.data.commodity.StorageListOutGetByTime;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;
//WJ 用来处理commoditylist
import nju.ztww.service.CommodityListDataService;

public class CommodityListDataServiceImpl extends UnicastRemoteObject implements CommodityListDataService {

	public CommodityListDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<StorageListLineofInPO> findInList(String time,String idofcenter) {
		// TODO Auto-generated method stub
		
		StorageListInGetByTime storagelistingetbytime=new StorageListInGetByTime();
		ArrayList<StorageListLineofInPO> arraylistin=storagelistingetbytime.findInList(time,idofcenter);
		return arraylistin;
	}

	public ArrayList<StorageListLineofOutPO> findOutList(String time,String idofcenter) {
		// TODO Auto-generated method stub
		StorageListOutGetByTime storagelistoutgetbytime=new StorageListOutGetByTime();
		ArrayList<StorageListLineofOutPO> arraylistout=storagelistoutgetbytime.findOutList(time,idofcenter);
		
		return arraylistout;
	}

	public ArrayList<StorageListLineofInPO> findInList(String timebegin,
			String timeend,String idofcenter) {
		StorageListInGetByTime storagelistingetbytime=new StorageListInGetByTime();
		ArrayList<StorageListLineofInPO> arraylistin=storagelistingetbytime.findInList(timebegin,timeend,idofcenter);
		return arraylistin;
		// TODO Auto-generated method stub
		
	}

	public ArrayList<StorageListLineofOutPO> findOutList(String timebegin,
			String timeend,String idofcenter) {
		// TODO Auto-generated method stub
		StorageListOutGetByTime storagelistoutgetbytime=new StorageListOutGetByTime();
		ArrayList<StorageListLineofOutPO> arraylistout=storagelistoutgetbytime.findOutList(timebegin,timeend,idofcenter);
		
		return arraylistout;
	}
    
}
