package nju.ztww.serviceimpl;

import java.util.ArrayList;

import nju.ztww.bl.commodity.GetStockListBL;
import nju.ztww.bl.commodity.StorageListGetByStringBL;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;
import nju.ztww.service.CommodityListService;
import nju.ztww.vo.StorageListLineofInVO;
import nju.ztww.vo.StorageListLineofOutVO;

public class CommodityListServiceImpl implements CommodityListService {
	
	
	ArrayList<StorageListLineofInPO> arraylistinpo;
	public ArrayList<StorageListLineofInVO> getInListbytime(String time,String idofcenter) {
		// TODO Auto-generated method stub
		//得到所需要的arraylist
		ArrayList<StorageListLineofInVO> arraylistinvo=new ArrayList<StorageListLineofInVO>();
		ArrayList<StorageListLineofInPO> arraylistinpo=new ArrayList<StorageListLineofInPO>();
		StorageListGetByStringBL storagegetbystring=new StorageListGetByStringBL();
		arraylistinpo=storagegetbystring.getInList(time,idofcenter);
		for(int i=0;i<arraylistinpo.size();i++){
			arraylistinvo.add(arraylistinpo.get(i).changetovo());
		}
		return arraylistinvo;
	}

	

	public ArrayList<StorageListLineofInVO> getInListbytime(String timebegin,
			String timeend,String idofcenter) {
		// TODO Auto-generated method stub
		
		ArrayList<StorageListLineofInVO> arraylistinvo=new ArrayList<StorageListLineofInVO>();
		ArrayList<StorageListLineofInPO> arraylistinpo=new ArrayList<StorageListLineofInPO>();
		StorageListGetByStringBL storagegetbystring=new StorageListGetByStringBL();
		arraylistinpo=storagegetbystring.getInList(timebegin,timeend,idofcenter);
		for(int i=0;i<arraylistinpo.size();i++){
			arraylistinvo.add(arraylistinpo.get(i).changetovo());
		}
		return arraylistinvo;
	}

	public ArrayList<StorageListLineofOutVO> getOutListbytime(String timebegin,
			String timeend,String idofcenter) {
		// TODO Auto-generated method stub
		ArrayList<StorageListLineofOutVO> arraylistoutvo=new ArrayList<StorageListLineofOutVO>();
		ArrayList<StorageListLineofOutPO> arraylistoutpo=new ArrayList<StorageListLineofOutPO>();
		StorageListGetByStringBL storagegetbystring=new StorageListGetByStringBL();
		arraylistoutpo=storagegetbystring.getOutList(timebegin,timeend,idofcenter);
		for(int i=0;i<arraylistoutpo.size();i++){
			
			arraylistoutvo.add(arraylistoutpo.get(i).changetovo());
			
		}
		
		return arraylistoutvo;
	
	}

	public ArrayList<StorageListLineofInVO> getStock(String idofcenter) {
		// TODO Auto-generated method stub
		ArrayList<StorageListLineofInVO> arraylistinvo=new ArrayList<StorageListLineofInVO>();
		ArrayList<StorageListLineofInPO> arraylistinpo=new ArrayList<StorageListLineofInPO>();
		 GetStockListBL getstock=new GetStockListBL();
		 arraylistinpo=getstock.getStock(idofcenter);
		for(int i=0;i<arraylistinpo.size();i++){
			 arraylistinvo.add(arraylistinpo.get(i).changetovo());
		}
		return arraylistinvo;
	}



	public ArrayList<StorageListLineofOutVO> getOutListbytime(String time,
			String idofcenter) {
		// TODO Auto-generated method stub
		return null;
	}



	public ArrayList<StorageListLineofInVO> getStockbyQu(String string,
			String idofcenter) {
		// TODO Auto-generated method stub
		ArrayList<StorageListLineofInVO> arraylistinvo=new ArrayList<StorageListLineofInVO>();
		ArrayList<StorageListLineofInPO> arraylistinpo=new ArrayList<StorageListLineofInPO>();
		 GetStockListBL getstock=new GetStockListBL();
		 arraylistinpo=getstock.getStockByQu(string,idofcenter);
		for(int i=0;i<arraylistinpo.size();i++){
			 arraylistinvo.add(arraylistinpo.get(i).changetovo());
		}
		System.out.println(arraylistinvo.size());
		return arraylistinvo;
	}
	public static void main(String[]args){
		CommodityListServiceImpl ss=new CommodityListServiceImpl();
		ArrayList<StorageListLineofInVO> sss=new ArrayList<StorageListLineofInVO>();
		sss=ss.getStockbyQu("航空区", "ss");
	}



	public void modify(ArrayList<StorageListLineofInVO> arraylist,
			String idofcenter) {
		// TODO Auto-generated method stub
		ArrayList<StorageListLineofInPO> arraylistinpo=new ArrayList<StorageListLineofInPO>();
		for(int i=0;i<arraylist.size();i++){
		arraylistinpo.add(arraylist.get(i).changetopo());
		}
		GetStockListBL gbl=new GetStockListBL();
		 gbl.modify(arraylistinpo,idofcenter);
		
	}
	

}
