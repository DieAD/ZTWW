package nju.ztww.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import nju.ztww.po.OrderPO;
import nju.ztww.vo.BusinessArriveVO;

/**
 * OrderData模块Service
 * @author TQ
 * 
 * */

public interface OrderDataService extends Remote  {
	
	public String insert(OrderPO orderPO,int type) throws RemoteException;
	
	public String delete(OrderPO orderPO,int type)throws RemoteException;

	
	public String find(int id)throws RemoteException;
	
	public String insertToDateFactory(List<OrderPO> list,int type) throws RemoteException;

}
