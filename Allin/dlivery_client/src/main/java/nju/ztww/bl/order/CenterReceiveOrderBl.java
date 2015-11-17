package nju.ztww.bl.order;

import nju.ztww.po.BusinessArrivePO;
import nju.ztww.po.CenterReceivePO;
import nju.ztww.serviceimpl.OrderDataServiceImpl;
import nju.ztww.vo.BusinessArriveVO;
import nju.ztww.vo.CenterReceiveVO;

/**
 * 中转中心到达单的bl层
 * 
 * @author TQ
 * 
 * */

public class CenterReceiveOrderBl {
	//新的businessArrivePO
	CenterReceivePO benterReceivePO=new CenterReceivePO(3);
	//OrderDataService的引用
	OrderDataServiceImpl orderDataServiceImpl = new OrderDataServiceImpl();

    public CenterReceiveOrderBl(){
		
	}
	
	public void handleVO(CenterReceiveVO centerReceiveVO){
		
	}
}
