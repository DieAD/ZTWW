package nju.ztww.bl.order;

import java.util.ArrayList;
import java.util.List;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.CarManagePO;
import nju.ztww.po.DriverMessagePO;
import nju.ztww.po.OrderPO;
import nju.ztww.service.OrderDataService;
import nju.ztww.vo.DriverMessageVO;

public class DriverMessageBl {

	  //新的businessArrivePO
    DriverMessagePO driverMessagePO=new DriverMessagePO(10);
	//ip地址
	 private String IP = "127.0.0.1";
	 private RMIHelper rhelper = new RMIHelper(IP,"1010");
	 
	 private OrderDataService orderDataService;
	 
	 private List<OrderPO> list=new ArrayList<OrderPO>();

    public DriverMessageBl() {
	
    }

/**
 * 将单据添加到临时数据库
 * 
 * @param businessArriveVO
 * @return
 */
    public String handleVO(DriverMessageVO driverMessageVO){
    	driverMessagePO.setDriverBirthday(driverMessageVO.getDriverBirthday());
    	driverMessagePO.setDriverId(driverMessageVO.getDriverId());
    	driverMessagePO.setDriverName(driverMessageVO.getDriverName());
    	driverMessagePO.setDriverNumber(driverMessageVO.getDriverNumber());
    	driverMessagePO.setDriverServiceDeadline(driverMessageVO.getDriverServiceDeadline());
    	driverMessagePO.setDriverSex(driverMessageVO.getDriverSex());
    	driverMessagePO.setDriverSex(driverMessageVO.getDriverTelephone());
	
	orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
	String result=orderDataService.insert(driverMessagePO,10);
	return result;
}

/**
 * 修改物流数据库
 * 
 * @param list
 * @return
 */
   public String handleAllVO(List<DriverMessagePO> list){
	  for(DriverMessagePO temp:list){
		this.list.add(temp);
	 }
	  orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
	 String result=orderDataService.insertToDateFactory(this.list,9);
	  return result;
	
}

}
