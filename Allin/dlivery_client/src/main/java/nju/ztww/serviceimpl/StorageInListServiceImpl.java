package nju.ztww.serviceimpl;

import java.util.ArrayList;

import nju.ztww.bl.commodity.StorageInofListBL;
import nju.ztww.bl.commodity.StorageListInAftercheckBL;
import nju.ztww.bl.commodity.StorageOutofListBL;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;
import nju.ztww.service.CommodityService;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.StorageListLineofInVO;
import nju.ztww.vo.StorageListLineofOutVO;
import nju.ztww.vo.StorageListVO;
//WJ 主要用来实现入库单的增加数据的作用
public class StorageInListServiceImpl implements CommodityService {

	
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

	public void deleteOrder(String idofOrder,String idofcenter) {
		// TODO Auto-generated method stub
		StorageInofListBL storagelistin=new StorageInofListBL();
		storagelistin.deleteOrder(idofOrder, idofcenter);

	}

	public boolean isOutofIndex(int number) {
		// TODO Auto-generated method stub
		return false;
	}


	public void addOrder(ArrayList<StorageListLineofOutVO> arraylist) {
		// TODO Auto-generated method stub
		
		
	}

	public void addoutOrder(
			ArrayList<StorageListLineofOutVO> arraylist,String idofcneter) {
		// TODO Auto-generated method stub
		
	}
    //将添加的信息加到所有入库单中
	public void addinOrder(
		ArrayList<StorageListLineofInVO> arraylist,String idofcneter) {
		
		ArrayList<StorageListLineofInPO>arraylistinpo=new ArrayList<StorageListLineofInPO>();
		for(int i=0;i< arraylist.size();i++){
			arraylistinpo.add(arraylist.get(i).changetopo());
		}
		StorageInofListBL storagelistinbl=new StorageInofListBL(); 
		storagelistinbl.addorder(arraylistinpo,idofcneter);
		// TODO Auto-generated method stub
	
	}

	public String getLastidofcenter(String idofcenter) {
		// TODO Auto-generated method stub
		String index="";
		StorageInofListBL bl=new StorageInofListBL();
		index=bl.getLastidofcenter(idofcenter);
		return index;
	}

}
