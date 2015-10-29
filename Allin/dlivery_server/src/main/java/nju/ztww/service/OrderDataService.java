package nju.ztww.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import nju.ztww.po.OrderPO;

/**
 * OrderData模块Service
 * @author TQ
 * 
 * */

<<<<<<< HEAD
public interface OrderDataService  extends Remote{
	
	public void insert(OrderPO orderPO) throws RemoteException;
	
	public void delete(OrderPO orderPO) throws RemoteException;
=======
public interface OrderDataService extends Remote  {
	
	public void insert(OrderPO orderPO) throws RemoteException;
	
	public void delete(OrderPO orderPO)throws RemoteException;
>>>>>>> refs/remotes/DieAD/master
	
	public void find(int id)throws RemoteException;

}
