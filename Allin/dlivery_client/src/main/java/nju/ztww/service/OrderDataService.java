package nju.ztww.service;

import java.rmi.Remote;
import java.util.List;

import nju.ztww.po.TrackPO;
import nju.ztww.po.OrderPO;
import nju.ztww.po.PriceDataPO;

/**
 * OrderData模块Service
 * @author TQ
 * 
 * */

public interface OrderDataService extends Remote{
	
	public String insert(OrderPO orderPO,int type);
	
	public String delete(String id,String type);
	
	public OrderPO find(String id,int type);
	
	public String findID();

	public String insertToDateFactory(List<OrderPO> list, int type);
	
	public PriceDataPO getPriceData(String place1, String place2, String type);

	public TrackPO passMailingOrder(String order);

	public void addTrack(TrackPO mailingTrackPO);

	public TrackPO passAcceptOrder(String order);
}
