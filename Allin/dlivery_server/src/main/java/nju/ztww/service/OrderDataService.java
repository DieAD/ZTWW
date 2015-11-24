package nju.ztww.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import nju.ztww.po.OrderPO;

/**
 * OrderData模块Service
 * @author TQ
 * 
 * */

public interface OrderDataService extends Remote  {
	
	public String insert(OrderPO orderPO,int type) throws RemoteException;
	
	public String delete(OrderPO orderPO,int type)throws RemoteException;

	
	public String find(int id)throws RemoteException;

}
