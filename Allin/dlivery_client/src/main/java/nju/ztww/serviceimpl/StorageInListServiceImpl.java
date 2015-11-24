package nju.ztww.serviceimpl;

import nju.ztww.bl.commodity.StorageInofListBL;
import nju.ztww.bl.commodity.StorageOutofListBL;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;
import nju.ztww.service.CommodityService;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.StorageListLineofInVO;
import nju.ztww.vo.StorageListLineofOutVO;
import nju.ztww.vo.StorageListVO;

public class StorageInListServiceImpl implements CommodityService {

	public StorageListVO getList(String idOfCenter) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVO getOrder(String idOfOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getTotal(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addOrder(OrderVO order) {
		// TODO Auto-generated method stub
		 StorageListLineofInVO storagelineinvo=(StorageListLineofInVO)order;
		 StorageListLineofInPO storagelistlinepo=storagelineinvo.changetopo();
		 StorageInofListBL storagelistinbl=new StorageInofListBL(); 
		 storagelistinbl.addorder(storagelistlinepo);

	}

	public void deleteOrder(String idofOrder) {
		// TODO Auto-generated method stub

	}

	public boolean isOutofIndex(int number) {
		// TODO Auto-generated method stub
		return false;
	}

}
