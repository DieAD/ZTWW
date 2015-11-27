package nju.ztww.serviceimpl;

import java.util.ArrayList;

import nju.ztww.bl.commodity.StorageInofListBL;
import nju.ztww.bl.commodity.StorageListOutbeforecheckBL;
import nju.ztww.bl.commodity.StorageOutofListBL;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;
import nju.ztww.service.CommodityService;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.StorageListLineVO;
import nju.ztww.vo.StorageListLineofInVO;
import nju.ztww.vo.StorageListLineofOutVO;
import nju.ztww.vo.StorageListVO;
//主要用来实现增加出库信息的作用
public class StorageOutListServiceImpl implements CommodityService {

	public ArrayList<StorageListLineVO> getList(String idOfCenter) {
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
		

	}

	public void deleteOrder(String idofOrder,String idofcenter) {
		// TODO Auto-generated method stub
		StorageOutofListBL storageoutlist=new StorageOutofListBL();
		storageoutlist.delete(idofOrder,idofcenter);

	}

	public boolean isOutofIndex(int number) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<StorageListLineVO> getList(String idOfCenter, String time) {
		// TODO Auto-generated method stub
		return null;
	}

	

	public void addoutOrder(ArrayList<StorageListLineofOutVO> arraylist,String idofcneter) {
		// TODO Auto-generated method stub
		
			ArrayList<StorageListLineofOutPO>arraylistinpo=new ArrayList<StorageListLineofOutPO>();
			for(int i=0;i< arraylist.size();i++){
				arraylistinpo.add(arraylist.get(i).changetopo());
			}
			StorageListOutbeforecheckBL storagelistoutbl=new StorageListOutbeforecheckBL(); 
			storagelistoutbl.addorder(arraylistinpo,idofcneter);
	}

	public void addinOrder(ArrayList<StorageListLineofInVO> arraylist,String idofcneter) {
		// TODO Auto-generated method stub
		
	}

}
