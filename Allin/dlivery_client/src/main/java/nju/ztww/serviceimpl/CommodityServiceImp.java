package nju.ztww.serviceimpl;
//@ auther Wj
import nju.ztww.bl.commodity.StorageOutofListTest;
import nju.ztww.po.OrderPO;
import nju.ztww.po.StorageListLineofOutPO;
import nju.ztww.service.CommodityDataService;
import nju.ztww.service.CommodityService;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.StorageListLineofOutVO;
import nju.ztww.vo.StorageListVO;

public class CommodityServiceImp implements CommodityService {
  
	
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
  StorageListLineofOutVO storagelineoutvo=(StorageListLineofOutVO)order;
   StorageListLineofOutPO storagelistlinepo=storagelineoutvo.changetopo();
   StorageOutofListTest storagelistout=new StorageOutofListTest(); 
   storagelistout.addorder(storagelistlinepo);
	
}

public void deleteOrder(String idofOrder) {
	// TODO Auto-generated method stub
	
}

public boolean isOutofIndex(int number) {
	// TODO Auto-generated method stub
	return false;
}
}