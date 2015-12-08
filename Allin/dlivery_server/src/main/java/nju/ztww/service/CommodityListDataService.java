package nju.ztww.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;

public interface CommodityListDataService extends Remote{
	//通过时间来得到入库信息（库存盘点和库存盘点）
	ArrayList<StorageListLineofInPO> findInList(String time,String idofcenter)throws RemoteException;
	
	
	//通过时间来得到出库信息（库存盘点和库存盘点）
	ArrayList<StorageListLineofOutPO> findOutList(String time,String idofcenter)throws RemoteException;
	//通过一段时间来得到入库信息（库存盘点和库存盘点）
	ArrayList<StorageListLineofInPO> findInList(String timebegin,String timeend,String idofcenter)throws RemoteException, ParseException;
	//通过一段时间来得到出库信息（库存盘点和库存盘点）
	ArrayList<StorageListLineofOutPO> findOutList(String timebegin,String timeend,String idofcenter)throws RemoteException, ParseException;
	ArrayList<StorageListLineofInPO> getStock(String idofcenter)throws RemoteException;
	ArrayList<StorageListLineofInPO> getStockByQu(String string,
			String idofcenter)throws RemoteException;
	void changeExeAddStock(ArrayList<String> list)throws RemoteException;
	void changeExeDeleteStock(ArrayList<String> list)throws RemoteException;
	void modify(ArrayList<StorageListLineofInPO> arraylistinpo,
			String idofcenter)throws RemoteException;
}
