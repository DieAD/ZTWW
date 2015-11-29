package nju.ztww.service;

import java.util.ArrayList;

import nju.ztww.common.ResultMessage;
import nju.ztww.vo.DeliverFeesVO;
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
	 * 结束输入
	 * 
	 * @param order OrderVO要保存的vo,vo对应的编号
	 * @return
	 * 
	 * */
	public String endSales(OrderVO order,int number);
	
	/**
	 * 删除订单
	 * @param id 唯一标识码
	 * @return
	 */
	public String deleteOrder(String id,String type);
	/**
	 * 获得运费
	 * 
	 * @param city 出发地
	 * @param city2 目的地
	 * @return
	 */
	public double getMoney(String city,String city2,int type);
	
	/**
	 * 获得到达日期
	 * 
	 * @param city 出发地
	 * @param city2 目的地
	 * @return
	 */
	public String getDate(String city,String city2,int type);
	
	
	/*
	 * 获得快递费用
	 * 
	 * @param 计算总共费用所需要的数据包
	 */
	
	public double getCost(DeliverFeesVO deliverFees);
	
	/*
	 * 获得4位订单号
	 */
	
	public String getOrderID();
}
