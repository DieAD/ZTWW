package nju.ztww.bl.commodity;

import java.util.ArrayList;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.service.CommodityListDataService;

public class GetStockListBL {
	private static String IP = "127.0.0.1";
	private RMIHelper rhelper = new RMIHelper(IP,"1010");
	private CommodityListDataService commoditylistdata;
	public ArrayList<StorageListLineofInPO> getStock(String idofcenter) {
		ArrayList<StorageListLineofInPO> storagelist=new ArrayList<StorageListLineofInPO>();
		commoditylistdata = (CommodityListDataService)rhelper.findService("CommodityListDataService");
		storagelist=commoditylistdata.getStock(idofcenter);
		return storagelist;
	}
	public ArrayList<StorageListLineofInPO> getStockByQu(String string,
			String idofcenter) {
		// TODO Auto-generated method stub
		ArrayList<StorageListLineofInPO> storagelist=new ArrayList<StorageListLineofInPO>();
		commoditylistdata = (CommodityListDataService)rhelper.findService("CommodityListDataService");
		storagelist=commoditylistdata.getStockByQu(string,idofcenter);
		System.out.println("ssss"+storagelist.size());
		return storagelist;
	}
	public static void main(String[]args){
		ArrayList<StorageListLineofInPO> ss=new ArrayList<StorageListLineofInPO>();
		 GetStockListBL gs=new GetStockListBL();
		 ss=gs.getStockByQu("航运区", "ss");
	}
	public void modify(ArrayList<StorageListLineofInPO> arraylistinpo,
			String idofcenter) {
		// TODO Auto-generated method stub
	commoditylistdata = (CommodityListDataService)rhelper.findService("CommodityListDataService");
	commoditylistdata.modify(arraylistinpo,idofcenter);
	for(int i=0;i<arraylistinpo.size();i++){
	System.out.println(arraylistinpo.get(i).getQu());
	}
	}
}
