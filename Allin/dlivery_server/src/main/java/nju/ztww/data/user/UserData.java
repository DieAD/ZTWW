package nju.ztww.data.user;

import nju.ztww.po.OrderPO;
import nju.ztww.po.StatePO;

public class UserData {
         
	
	
	
	public OrderPO findOrder(String id){
		if(id.equals("0000000001")){
			StatePO statePO = new StatePO(1);
			statePO.setCurrentPlace("南京中转中心站");
			statePO.setHistoryPlace("上海中转中心");
			return  statePO;
		}else{
			return null;
		}
	}
}
