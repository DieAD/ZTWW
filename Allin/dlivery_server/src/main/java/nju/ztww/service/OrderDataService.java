package nju.ztww.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import nju.ztww.po.CarManagePO;
import nju.ztww.po.TrackPO;
import nju.ztww.po.OrderPO;
import nju.ztww.po.PriceDataPO;
import nju.ztww.vo.BusinessArriveVO;
import nju.ztww.vo.DeliverFeesVO;
import nju.ztww.vo.IDVO;

/**
 * OrderData模块Service
 * @author TQ
 * 
 * */

public interface OrderDataService extends Remote  {
	
	public String insert(OrderPO orderPO,int type) throws RemoteException;
	
	public String delete(String id,String type)throws RemoteException;

	public String findID(String name)throws RemoteException;
	
	public OrderPO find(String id,int type)throws RemoteException;
	
	public String insertToDateFactory(List<IDVO> list,int type) throws RemoteException;

	public PriceDataPO getPriceData(String place1, String place2, String type) throws RemoteException;

	public double getmoney(String place1,String place2)throws RemoteException;
	
	public String addTrace(List<IDVO> list,int type)  throws RemoteException;


	public TrackPO passMailingOrder(String order) throws RemoteException;
	
	public void addTrack(TrackPO mailingTrackPO) throws RemoteException;
	
	public TrackPO passAcceptOrder(String order) throws RemoteException;
	
	public ArrayList<CarManagePO> findAll() throws RemoteException;

}
