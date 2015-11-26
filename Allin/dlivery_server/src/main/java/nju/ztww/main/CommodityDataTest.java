package nju.ztww.main;

import nju.ztww.DBHelper.DBForStock;
import nju.ztww.DBHelper.DBHelper;
import nju.ztww.data.commodity.StorageListIn;

public class CommodityDataTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 DBForStock  dbforstock=new DBForStock();
		 DBHelper dbhelper=new DBHelper();
		 dbhelper.init();
		 dbhelper.queryTable("stocktable");
		 dbhelper.close();
		
		 
        
	}

}
