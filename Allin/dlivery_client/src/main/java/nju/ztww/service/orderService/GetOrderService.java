package nju.ztww.service.orderService;

import java.util.ArrayList;

import nju.ztww.vo.OrderVO;

/**
 * 审判所有单据的Service
 * @authorTQ
 * 
 * */

public interface GetOrderService {
	
	/**
	 * 审判所有单据
	 * 
	 * @return ArrayList<OrderVO>所有orderVO的list
	 * 
	 * */
	public ArrayList<OrderVO> getAllOrders();

}
