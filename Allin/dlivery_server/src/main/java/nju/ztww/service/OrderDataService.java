package nju.ztww.service;

import java.rmi.Remote;

import nju.ztww.po.OrderPO;

/**
 * OrderData模块Service
 * @author TQ
 * 
 * */

public interface OrderDataService  {
	
	public void insert(OrderPO orderPO);
	
	public void delete(OrderPO orderPO);
	
	public void find(int id);

}
