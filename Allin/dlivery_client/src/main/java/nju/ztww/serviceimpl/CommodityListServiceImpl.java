package nju.ztww.serviceimpl;

import java.util.ArrayList;

import nju.ztww.bl.commodity.StorageListGetByStringBL;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;
import nju.ztww.service.CommodityListService;
import nju.ztww.vo.StorageListLineofInVO;
import nju.ztww.vo.StorageListLineofOutVO;

public class CommodityListServiceImpl implements CommodityListService {
	
	
	ArrayList<StorageListLineofInPO> arraylistinpo;
	public ArrayList<StorageListLineofInVO> getInListbytime(String time) {
		// TODO Auto-generated method stub
		//得到所需要的arraylist
		ArrayList<StorageListLineofInVO> arraylistinvo=new ArrayList<StorageListLineofInVO>();
		ArrayList<StorageListLineofInPO> arraylistinpo=new ArrayList<StorageListLineofInPO>();
		StorageListGetByStringBL storagegetbystring=new StorageListGetByStringBL();
		arraylistinpo=storagegetbystring.getInList(time);
		for(int i=0;i<arraylistinpo.size();i++){
			arraylistinvo.add(arraylistinpo.get(i).changetovo());
		}
		return arraylistinvo;
	}

	public ArrayList<StorageListLineofOutVO> getOutListbytime(String time) {
		// TODO Auto-generated method stub
		ArrayList<StorageListLineofOutVO> arraylistoutvo=new ArrayList<StorageListLineofOutVO>();
		ArrayList<StorageListLineofOutPO> arraylistoutpo=new ArrayList<StorageListLineofOutPO>();
		StorageListGetByStringBL storagegetbystring=new StorageListGetByStringBL();
		arraylistoutpo=storagegetbystring.getOutList(time);
		for(int i=0;i<arraylistoutpo.size();i++){
			arraylistoutvo.add(arraylistoutpo.get(i).changetovo());
		}
		return arraylistoutvo;
	}

	public ArrayList<StorageListLineofInVO> getInListbytime(String timebegin,
			String timeend) {
		// TODO Auto-generated method stub
		ArrayList<StorageListLineofInVO> arraylistinvo=new ArrayList<StorageListLineofInVO>();
		ArrayList<StorageListLineofInPO> arraylistinpo=new ArrayList<StorageListLineofInPO>();
		StorageListGetByStringBL storagegetbystring=new StorageListGetByStringBL();
		arraylistinpo=storagegetbystring.getInList(timebegin,timeend);
		for(int i=0;i<arraylistinpo.size();i++){
			arraylistinvo.add(arraylistinpo.get(i).changetovo());
		}
		return arraylistinvo;
	}

	public ArrayList<StorageListLineofOutVO> getOutListbytime(String timebegin,
			String timeend) {
		// TODO Auto-generated method stub
		ArrayList<StorageListLineofOutVO> arraylistoutvo=new ArrayList<StorageListLineofOutVO>();
		ArrayList<StorageListLineofOutPO> arraylistoutpo=new ArrayList<StorageListLineofOutPO>();
		StorageListGetByStringBL storagegetbystring=new StorageListGetByStringBL();
		arraylistoutpo=storagegetbystring.getOutList(timebegin,timeend);
		for(int i=0;i<arraylistoutpo.size();i++){
			arraylistoutvo.add(arraylistoutpo.get(i).changetovo());
		}
		return arraylistoutvo;
	
	}

}