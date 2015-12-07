package nju.ztww.serviceimpl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.util.ArrayList;

import nju.ztww.data.commodity.HandleExe;
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
		ArrayList<StorageListLineofInPO> arraylistin=new ArrayList<StorageListLineofInPO>();
		arraylistin=	storagelistingetbytime.findInList(timebegin,timeend,idofcenter);
		return arraylistin;
		// TODO Auto-generated method stub
		
	}

	public ArrayList<StorageListLineofOutPO> findOutList(String timebegin,
			String timeend,String idofcenter) throws RemoteException, ParseException{
		// TODO Auto-generated method stub
		StorageListOutGetByTime storagelistoutgetbytime=new StorageListOutGetByTime();
		ArrayList<StorageListLineofOutPO> arraylistout=new ArrayList<StorageListLineofOutPO>();
		arraylistout=storagelistoutgetbytime.findOutList(timebegin,timeend,idofcenter);
		System.out.println(arraylistout.size()+"实现");
		return arraylistout;
	}
	public ArrayList<StorageListLineofInPO> getStock(String idofcenter)throws RemoteException{
		StockGet sg=new StockGet();
		ArrayList<StorageListLineofInPO> arraylistin=new ArrayList<StorageListLineofInPO>();
		arraylistin=sg.getStock(idofcenter);
		return arraylistin;
		
		  
	}

	public void changeExeAddStock(ArrayList<String> list)
			throws RemoteException {
		// TODO Auto-generated method stub
		HandleExe handle=new HandleExe();
		handle.changeExeAddStock(list);
		
	}
	public void changeExeDeleteStock(ArrayList<String> list)
			throws RemoteException {
		// TODO Auto-generated method stub
		HandleExe handle=new HandleExe();
		handle.changeExeDeleteStock(list);
		
	}

	public ArrayList<StorageListLineofInPO> getStockByQu(String string,
			String idofcenter) throws RemoteException {
		// TODO Auto-generated method stub
		StockGet sg=new StockGet();
		ArrayList<StorageListLineofInPO> arraylistin=new ArrayList<StorageListLineofInPO>();
		arraylistin=sg.getStockByQu(string,idofcenter);
		return arraylistin;
		
	}

	public void modify(ArrayList<StorageListLineofInPO> arraylistinpo,
			String idofcenter) throws RemoteException {
		// TODO Auto-generated method stub
		StockGet sg=new StockGet();
		sg.modify(arraylistinpo,idofcenter);
	}
}
