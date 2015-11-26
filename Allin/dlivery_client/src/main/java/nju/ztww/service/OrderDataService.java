package nju.ztww.service;

import java.rmi.Remote;
import java.util.List;

import nju.ztww.po.OrderPO;
import nju.ztww.po.PriceDataPO;

/**
 * OrderData模块Service
 * @author TQ
 * 
 * */

public interface OrderDataService extends Remote{
	
	public String insert(OrderPO orderPO,int type);
	
	public String delete(OrderPO orderPO,int type);
	
	public String find(int id);

	public String insertToDateFactory(List<OrderPO> list, int type);
	
	public PriceDataPO getPriceData(String place1, String place2, String type);
}
