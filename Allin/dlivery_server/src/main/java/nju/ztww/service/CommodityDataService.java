package nju.ztww.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import nju.ztww.po.OrderPO;

/*
 * Date:
 * Author:
 */
public interface CommodityDataService extends Remote{
	// 插入一个订单信息
	public void insert(OrderPO po) throws RemoteException;
	//删除一个订单信息
	public void delete(OrderPO po) throws RemoteException;
	//找到一个订单信息
	public OrderPO find(String id) throws RemoteException;
	//更新一个订单的具体信息
	public void update(OrderPO po) throws RemoteException;
//TODO
}
