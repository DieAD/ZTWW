package nju.ztww.service;

import java.util.ArrayList;

import nju.ztww.po.OrderPO;
import nju.ztww.po.StorageListLinePO;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;

public interface CommodityDataService {
	// 插入一个订单信息
		public void insert(OrderPO po);
		//删除一个订单信息
		public void delete(OrderPO po);
		//找到一个订单信息
		public OrderPO find(String id);
		//更新一个订单的具体信息
		public void update(OrderPO po);
		//
		public ArrayList<StorageListLinePO> findList(String idofcenter);
	//TODO
		//插入一个列表
		public void insertOut(ArrayList<StorageListLineofOutPO> arraylist,String idofcenter);
		public void insertIn(ArrayList<StorageListLineofInPO> arraylist,String idofcenter);
}
