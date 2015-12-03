package nju.ztww.serviceimpl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.util.ArrayList;

import nju.ztww.data.commodity.StockGet;
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

	public ArrayList<StorageListLineofInPO> findInList(String time,String idofcenter) throws RemoteException{
		// TODO Auto-generated method stub
		
		StorageListInGetByTime storagelistingetbytime=new StorageListInGetByTime();
		ArrayList<StorageListLineofInPO> arraylistin=storagelistingetbytime.findInList(time,idofcenter);
		return arraylistin;
	}

	public ArrayList<StorageListLineofOutPO> findOutList(String time,String idofcenter) throws RemoteException{
		// TODO Auto-generated method stub
		StorageListOutGetByTime storagelistoutgetbytime=new StorageListOutGetByTime();
		ArrayList<StorageListLineofOutPO> arraylistout=storagelistoutgetbytime.findOutList(time,idofcenter);
		
		return arraylistout;
	}

	public ArrayList<StorageListLineofInPO> findInList(String timebegin,
			String timeend,String idofcenter) throws RemoteException, ParseException{
		StorageListInGetByTime storagelistingetbytime=new StorageListInGetByTime();
		ArrayList<StorageListLineofInPO> arraylistin=storagelistingetbytime.findInList(timebegin,timeend,idofcenter);
		return arraylistin;
		// TODO Auto-generated method stub
		
	}

	public ArrayList<StorageListLineofOutPO> findOutList(String timebegin,
			String timeend,String idofcenter) throws RemoteException, ParseException{
		// TODO Auto-generated method stub
		StorageListOutGetByTime storagelistoutgetbytime=new StorageListOutGetByTime();
		ArrayList<StorageListLineofOutPO> arraylistout=storagelistoutgetbytime.findOutList(timebegin,timeend,idofcenter);
		
		return arraylistout;
	}
//得到库存信息
	public ArrayList<StorageListLineofInPO> getStock(String idofcenter)
			throws RemoteException {
		// TODO Auto-generated method stub
		 ArrayList<StorageListLineofInPO> storagelistofin=new ArrayList<StorageListLineofInPO>();
		 StockGet stockget=new StockGet();
		 storagelistofin=stockget.getStock(idofcenter);
		 
		return storagelistofin;
	}
    
}
