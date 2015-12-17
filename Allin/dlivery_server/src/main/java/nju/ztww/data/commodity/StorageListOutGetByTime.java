package nju.ztww.data.commodity;
//WJ 数据层具体实现找List的方法（库存盘点或库存查看） 数据库表需要记录出库。
import java.text.ParseException;
import java.util.ArrayList;

import nju.ztww.DBHelper.DBForOutStockForm;
import nju.ztww.dao.OutStockFormDO;
import nju.ztww.po.StorageListLineofOutPO;

public class StorageListOutGetByTime {
	public DBForOutStockForm  dbforoutstorkform=new DBForOutStockForm();
	 ;
	public ArrayList<StorageListLineofOutPO> findOutList(String time,String idofcenter) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//数据库写完了再更改 两个时间点相同的情况也考虑了
	public ArrayList<StorageListLineofOutPO> findOutList(String timebegin,String timeend,String idofcenter) throws ParseException{
		System.out.println("out服务层");
		
		dbforoutstorkform.init();
		String tableName="outstockform";
		ArrayList<StorageListLineofOutPO> arraylist=new ArrayList<StorageListLineofOutPO>();
		ArrayList<OutStockFormDO> outstockformlist=new ArrayList<OutStockFormDO>();
		if(timebegin.equals(timeend)){
			outstockformlist=dbforoutstorkform.queryByTime(timebegin, tableName,idofcenter);
			for(int i=0;i<outstockformlist.size();i++){
			StorageListLineofOutPO storagelistlineofoutpo=new StorageListLineofOutPO(
					"不需要",
					outstockformlist.get(i).getGoodsid(),
					outstockformlist.get(i).getTime(),
					outstockformlist.get(i).getAddress(),
					outstockformlist.get(i).getTransmethod(),
					outstockformlist.get(i).getNumber(),
					outstockformlist.get(i).getIdofcenter()
					);
			arraylist.add(storagelistlineofoutpo);
			}
			return arraylist;
				
		}
		else{
			ArrayList<String>timelist=new ArrayList<String>();
			TimeChange time=new TimeChange();
			timelist=time.timechange(timebegin, timeend);
			outstockformlist=dbforoutstorkform.queryByTime(timebegin, tableName,idofcenter);
			for(int i=0;i<timelist.size();i++){
				ArrayList<OutStockFormDO> outstockformlist2=new ArrayList<OutStockFormDO>();
				outstockformlist2=dbforoutstorkform.queryByTime(timelist.get(i), tableName,idofcenter);
				for(int j=0;j<outstockformlist2.size();j++){
					outstockformlist.add(outstockformlist2.get(j));
				}
			}
			for(int i=0;i<outstockformlist.size();i++){
				StorageListLineofOutPO storagelistlineofoutpo=new StorageListLineofOutPO(
						"不需要",
						outstockformlist.get(i).getGoodsid(),
						outstockformlist.get(i).getTime(),
						outstockformlist.get(i).getAddress(),
						outstockformlist.get(i).getTransmethod(),
						outstockformlist.get(i).getNumber(),
						outstockformlist.get(i).getIdofcenter()
						);
				arraylist.add(storagelistlineofoutpo);
			}
			System.out.println("总数量："+arraylist.size());
		}
		dbforoutstorkform.close();
		
		return arraylist;
	}
	public static void main(String args[]) throws ParseException{
		StorageListOutGetByTime slo=new StorageListOutGetByTime();
		ArrayList<StorageListLineofOutPO> arraylist=new ArrayList<StorageListLineofOutPO>();
		arraylist=slo.findOutList("15/12/10", "15/12/11", "02501");
	}
}
