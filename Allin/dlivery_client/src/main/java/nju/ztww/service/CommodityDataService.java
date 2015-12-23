package nju.ztww.service;

import java.util.ArrayList;

import nju.ztww.po.OrderPO;
import nju.ztww.po.StorageListLinePO;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;
import nju.ztww.po.StorageListodInPO;
import nju.ztww.po.StorageListodOutPO;

public interface CommodityDataService {
	// 插入一个订单信息
		public void insert(OrderPO po);
		//删除一个订单信息
		public void delete(String idoforder, String idofcenter);
		//找到一个订单信息
		public OrderPO find(String id);
		//更新一个订单的具体信息
		public void update(OrderPO po);
		//
		public ArrayList<StorageListLinePO> findList(String idofcenter);
	//TODO
		//插入一个列表
		public String insertOut(ArrayList<StorageListLineofOutPO>  arraylistoutpo,String idofcenter);
		public String insertIn(ArrayList<StorageListLineofInPO> arraylistinpo,String idofcenter);
		public String getLastidofcenter(String idofcenter);
}
