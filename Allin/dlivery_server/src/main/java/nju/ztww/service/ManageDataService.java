package nju.ztww.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import nju.ztww.po.SuperviseePO;

/*
 * Date:
 * Author:
 */

public interface ManageDataService extends Remote {
//TODO// 插入一个订单信息
	public void insert(SuperviseePO po) throws RemoteException;
	//删除一个订单信息
	public void delete(SuperviseePO po) throws RemoteException;
	//找到一个订单信息
	public SuperviseePO find(String id) throws RemoteException;
	//更新一个订单的具体信息
	public void update(SuperviseePO po) throws RemoteException;

}
