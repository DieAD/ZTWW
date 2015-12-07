package nju.ztww.serviceimpl;
/**
 * @author wangjie;
 */
import java.util.ArrayList;



import nju.ztww.bl.commodity.StorageOutofListBL;
import nju.ztww.po.StorageListLineofOutPO;
import nju.ztww.service.CommodityService;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.StorageListLineofInVO;
import nju.ztww.vo.StorageListLineofOutVO;

//主要用来实现增加出库信息的作用
public class StorageOutListServiceImpl implements CommodityService {

	

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

	

	

	public void addoutOrder(ArrayList<StorageListLineofOutVO> arraylist,String idofcneter) {
		// TODO Auto-generated method stub
		
			ArrayList<StorageListLineofOutPO>arraylistinpo=new ArrayList<StorageListLineofOutPO>();
			for(int i=0;i< arraylist.size();i++){
				arraylistinpo.add(arraylist.get(i).changetopo());
			}
			StorageOutofListBL storagelistoutbl=new StorageOutofListBL(); 
			storagelistoutbl.addorder(arraylistinpo,idofcneter);
	}

	public void addinOrder(ArrayList<StorageListLineofInVO> arraylist,String idofcneter) {
		// TODO Auto-generated method stub
		
	}
//得到现在单子的号码
	public String getLastidofcenter(String idofcenter) {
		// TODO Auto-generated method stub
		String index="";
		StorageOutofListBL soutbl=new StorageOutofListBL();
		index=soutbl.getLastidofcenter(idofcenter);
		return index;
	}

}
