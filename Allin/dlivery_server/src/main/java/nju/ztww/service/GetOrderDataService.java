package nju.ztww.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import nju.ztww.po.OrderPO;

/**
 * 审判所有单据的DataService
 * @author TQ
 * 
 * */

public interface GetOrderDataService extends Remote{
	
	public ArrayList<OrderPO> finds() throws RemoteException;

}
