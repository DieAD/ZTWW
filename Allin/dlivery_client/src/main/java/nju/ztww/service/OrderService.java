package nju.ztww.service;

import java.util.ArrayList;

import nju.ztww.common.ResultMessage;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.StorageListVO;

/**
 * Order模块Service
 * @author TQ
 * 
 * */
public interface OrderService {

    /**
     * 获取一个新的vo（在ui层已选择单据类型后）
     * 
     * @param number 单据对应的号码（一个单据对应一个号码，通过号码返回单据）
     * @return 返回一个对应的vo
     * 
     * */
	public OrderVO getOrder(int number);
	
    /**
     * 获得库存信息（输入对应的ID，返回库存信息）
     * 
     * @param id 货物库存对应的id号码
     * @return 返回一个对应的库存信息vo
     * 
     * */
	public StorageListVO getCommodity(int id);
	
	/**
	 * 增加一条库存信息
	 * 
	 * @param idOfCenter 货物ID
	 * @param date 存储日期（格式：2015-10-22）
	 * @param location 储存地点
	 * @return ResultMessage
	 * 
	 * */
	public ResultMessage addCommodity(int idOfCenter,String data,String location );
	
	/**
	 * 审判所有单据
	 * 
	 * @return ArrayList<OrderVO>所有orderVO的list
	 * 
	 * */
	public ArrayList getAllOrders();
	
	/**
	 * 结束输入
	 * 
	 * @param order OrderVO要保存的vo
	 * @return
	 * 
	 * */
	public void endSales(OrderVO order);
	
	
	
}
