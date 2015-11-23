package nju.ztww.serviceimpl;
import java.util.ArrayList;
import nju.ztww.data.commodity.StorageListInGetByTime;
import nju.ztww.data.commodity.StorageListOutGetByTime;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;
//WJ 用来处理commoditylist
import nju.ztww.service.CommodityListDataService;

public class CommodityListDataServiceImpl implements CommodityListDataService {

	public ArrayList<StorageListLineofInPO> findInList(String time) {
		// TODO Auto-generated method stub
		
		StorageListInGetByTime storagelistingetbytime=new StorageListInGetByTime();
		ArrayList<StorageListLineofInPO> arraylistin=storagelistingetbytime.findInList(time);
		return arraylistin;
	}

	public ArrayList<StorageListLineofOutPO> findOutList(String time) {
		// TODO Auto-generated method stub
		StorageListOutGetByTime storagelistoutgetbytime=new StorageListOutGetByTime();
		ArrayList<StorageListLineofOutPO> arraylistout=storagelistoutgetbytime.findOutList(time);
		
		return arraylistout;
	}

	public ArrayList<StorageListLineofInPO> findInList(String timebegin,
			String timeend) {
		StorageListInGetByTime storagelistingetbytime=new StorageListInGetByTime();
		ArrayList<StorageListLineofInPO> arraylistin=storagelistingetbytime.findInList(timebegin,timeend);
		return arraylistin;
		// TODO Auto-generated method stub
		
	}

	public ArrayList<StorageListLineofOutPO> findOutList(String timebegin,
			String timeend) {
		// TODO Auto-generated method stub
		StorageListOutGetByTime storagelistoutgetbytime=new StorageListOutGetByTime();
		ArrayList<StorageListLineofOutPO> arraylistout=storagelistoutgetbytime.findOutList(timebegin,timeend);
		
		return arraylistout;
	}
    
}
