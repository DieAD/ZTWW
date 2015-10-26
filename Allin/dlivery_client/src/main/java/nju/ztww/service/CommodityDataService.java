package nju.ztww.service;

import nju.ztww.po.OrderPO;

public interface CommodityDataService {
	// 插入一个订单信息
		public void insert(OrderPO po);
		//删除一个订单信息
		public void delete(OrderPO po);
		//找到一个订单信息
		public OrderPO find(String id);
		//更新一个订单的具体信息
		public void update(OrderPO po);
	//TODO
}
