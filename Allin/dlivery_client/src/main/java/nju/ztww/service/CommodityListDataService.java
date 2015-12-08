package nju.ztww.service;

import java.util.ArrayList;

import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;

public interface CommodityListDataService {
	//通过时间来得到入库信息（库存盘点和库存盘点）
	ArrayList<StorageListLineofInPO> findInList(String time,String idofcenter);
	
	
	//通过时间来得到出库信息（库存盘点和库存盘点）
	ArrayList<StorageListLineofOutPO> findOutList(String time,String idofcenter);
	//通过一段时间来得到入库信息（库存盘点和库存盘点）
	ArrayList<StorageListLineofInPO> findInList(String timebegin,String timeend,String idofcenter);
	//通过一段时间来得到出库信息（库存盘点和库存盘点）
	ArrayList<StorageListLineofOutPO> findOutList(String timebegin,String timeend,String idofcenter);


	ArrayList<StorageListLineofInPO> getStock(String idofcenter);


	void changeExeAddStock(ArrayList<String> list);
	void changeExeDeleteStock(ArrayList<String> list);

   //得到各分区库存
	ArrayList<StorageListLineofInPO> getStockByQu(String string,
			String idofcenter);


	void modify(ArrayList<StorageListLineofInPO> arraylistinpo,
			String idofcenter);

	
}
