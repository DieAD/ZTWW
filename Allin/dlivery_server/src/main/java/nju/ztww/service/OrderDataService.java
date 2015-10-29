package nju.ztww.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import nju.ztww.po.OrderPO;

/**
 * OrderData模块Service
 * @author TQ
 * 
 * */

public interface OrderDataService  extends Remote{
	
	public void insert(OrderPO orderPO) throws RemoteException;
	
	public void delete(OrderPO orderPO) throws RemoteException;
	
	public void find(int id);

}
