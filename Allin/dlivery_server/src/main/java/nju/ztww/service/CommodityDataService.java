package nju.ztww.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import nju.ztww.po.OrderPO;
import nju.ztww.po.StorageListLinePO;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;
import nju.ztww.po.StorageListodInPO;
import nju.ztww.po.StorageListodOutPO;

public interface CommodityDataService extends Remote{
	// 插入一个订单信息
		public void insert(OrderPO po)throws RemoteException;
		//删除一个订单信息
		public void delete(String idoforder,String idofcenter)throws RemoteException;
		//找到一个订单信息
		public OrderPO find(String id)throws RemoteException;
		//更新一个订单的具体信息
		public void update(OrderPO po)throws RemoteException;
		//得到一个中转中心仓库此时的库存表
		public ArrayList<StorageListLinePO> findList(String idofcenter)throws RemoteException;
	//TODO
		public String insertOut(ArrayList<StorageListLineofOutPO>  arraylistoutpo,String idofcenter)throws RemoteException;
		public String insertIn(ArrayList<StorageListLineofInPO>  arraylistinpo,String idofcenter)throws RemoteException;
		public String getLastidofcenter(String idofcenter)throws RemoteException;
}
