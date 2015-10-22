package nju.ztww.service;

import nju.ztww.vo.OrderVO;
import nju.ztww.vo.StorageListVO;

public interface CommodityService {
	//根据中转中心编号，得到中转中心库存列表
    public StorageListVO getList(String idOfCenter);
    
    //根据订单号显示订单信息
    public OrderVO getOrder(String idOfOrder);
    
    //计算分区的库存数量
    //id ： 库存编号
    public int getTotal(int id);
    	
}
