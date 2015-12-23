package nju.ztww.bl.commodity;
// 写审批时限的方法步骤是 setArrayLIST  Set ischeck,然后在总单子中将这个单子remove
import java.rmi.Naming;
import java.util.ArrayList;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.OrderPO;
import nju.ztww.po.StorageListLineofOutPO;
import nju.ztww.po.StorageListodOutPO;
import nju.ztww.service.CommodityDataService;
import nju.ztww.service.UserDataService;
import nju.ztww.ui.main.TipsUI;

public class StorageOutofListBL {
	private static String IP = "127.0.0.1";
    private RMIHelper rhelper = new RMIHelper(IP,"1010");
    private CommodityDataService commoditydata;
    //两个操作 增加信息到出库列表， 在库存中删除信息
    public void addorder(ArrayList<StorageListLineofOutPO> outList,String idofcenter){
    	
    	commoditydata = (CommodityDataService)rhelper.findService("CommodityDataServiceOut");
    	String result=commoditydata.insertOut(outList, idofcenter);
    	if(result.equals("success")){
			TipsUI.tip.setText("操作成功");
		}else if(result.equals("fasil")){
			TipsUI.tip.setText("数据库操作失败");
		}
		TipsUI.ifLine=true;
  
    	
    }

	public void addorder(StorageListLineofOutPO storagelistlinepo) {
		// TODO Auto-generated method stub
		
	}

	public void delete(String idofOrder, String idofcenter) {
		// TODO Auto-generated method stub
		commoditydata = (CommodityDataService)rhelper.findService("CommodityDataServiceOut");
		commoditydata.delete(idofOrder, idofcenter);
	}

	public String getLastidofcenter(String idofcenter) {
		// TODO Auto-generated method stub
		String index=" ";
		commoditydata = (CommodityDataService)rhelper.findService("CommodityDataServiceOut");
		index=commoditydata.getLastidofcenter(idofcenter);
		return index;
	}
   
}
