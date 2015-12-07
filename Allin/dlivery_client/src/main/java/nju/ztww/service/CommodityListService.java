package nju.ztww.service;

import java.util.ArrayList;






import nju.ztww.vo.StorageListLineofInVO;
import nju.ztww.vo.StorageListLineofOutVO;

//WJ 来得到
public interface CommodityListService {
	//通过时间来得到具体的 入库信息表
 public ArrayList<StorageListLineofInVO> getStock(String idofcenter);
   
 public ArrayList<StorageListLineofInVO>getInListbytime(String time,String idofcenter);
 //通过时间来得到具体的 出库信息表
 public ArrayList<StorageListLineofOutVO>getOutListbytime(String time,String idofcenter);
  
 
 //通过一段时间来得到具体的入库信息表
 public ArrayList<StorageListLineofInVO> getInListbytime(String timebegin,String timeend,String idofcenter);
 
 
 //通过一段时间来得到具体的出库信息表
 public ArrayList<StorageListLineofOutVO> getOutListbytime(String timebegin,String timeend,String idofcenter);

public ArrayList<StorageListLineofInVO> getStockbyQu(String string,
		String idofcenter);

public void modify(ArrayList<StorageListLineofInVO> arraylist, String idofcenter);
}

