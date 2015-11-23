package nju.ztww.service;

import java.util.ArrayList;

import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;

public interface CommodityListDataService {
	//通过时间来得到入库信息（库存盘点和库存盘点）
	ArrayList<StorageListLineofInPO> findInList(String time);
	
	
	//通过时间来得到出库信息（库存盘点和库存盘点）
	ArrayList<StorageListLineofOutPO> findOutList(String time);
	//通过一段时间来得到入库信息（库存盘点和库存盘点）
	ArrayList<StorageListLineofInPO> findInList(String timebegin,String timeend);
	//通过一段时间来得到出库信息（库存盘点和库存盘点）
	ArrayList<StorageListLineofOutPO> findOutList(String timebegin,String timeend);
}
