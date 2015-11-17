package nju.ztww.bl.order;


import nju.ztww.po.LoadingPO;
import nju.ztww.serviceimpl.OrderDataServiceImpl;

import nju.ztww.vo.LoadingVO;

/**
 * 营业厅装车单的bl层
 * 
 * @author TQ
 * 
 * */

public class LoadingOrderBl {
	
	   //新的LoadingPO
	   LoadingPO loadingPO=new LoadingPO(4);
		//OrderDataService的引用
		OrderDataServiceImpl orderDataServiceImpl = new OrderDataServiceImpl();
		
		public LoadingOrderBl(){
			
		}
		
		public void handleVO(LoadingVO loadingVO){
			
		}

}
