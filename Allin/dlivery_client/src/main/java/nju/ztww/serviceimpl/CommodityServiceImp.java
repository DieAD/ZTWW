package nju.ztww.serviceimpl;
//@ auther Wj
import java.util.ArrayList;

import nju.ztww.bl.commodity.StorageListBL;
import nju.ztww.bl.commodity.StorageOutofListBL;
import nju.ztww.po.OrderPO;
import nju.ztww.po.StorageListLinePO;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;
import nju.ztww.service.CommodityDataService;
import nju.ztww.service.CommodityService;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.StorageListLineofInVO;
import nju.ztww.vo.StorageListLineofOutVO;
import nju.ztww.vo.StorageListVO;

public class CommodityServiceImp implements CommodityService {
  
//根据 中转中心的id 和 时间来获得库存信息	


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
  
	
}

public void deleteOrder(String idofOrder,String idofcenter) {
	// TODO Auto-generated method stub
	
	
}

public boolean isOutofIndex(int number) {
	// TODO Auto-generated method stub
	return false;
}



public void addoutOrder(
		ArrayList<StorageListLineofOutVO> arraylist,String idofcneter) {
	// TODO Auto-generated method stub
	
}

public void addinOrder(
		ArrayList<StorageListLineofInVO> arraylist,String idofcneter) {
	// TODO Auto-generated method stub
	
}

public String getLastidofcenter(String idofcenter) {
	// TODO Auto-generated method stub
	return null;
}
}