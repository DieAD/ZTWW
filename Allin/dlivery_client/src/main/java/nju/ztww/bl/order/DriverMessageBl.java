package nju.ztww.bl.order;

import java.util.ArrayList;
import java.util.List;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.DriverMessagePO;
import nju.ztww.po.OrderPO;
import nju.ztww.service.OrderDataService;
import nju.ztww.vo.DriverMessageVO;
import nju.ztww.vo.IDVO;

public class DriverMessageBl {

	  //新的businessArrivePO
    DriverMessagePO driverMessagePO=new DriverMessagePO(10);
    
    DriverMessageVO driverMessageVO=new DriverMessageVO(10);
	//ip地址
	 private String IP = "127.0.0.1";
	 private RMIHelper rhelper = new RMIHelper(IP,"1010");
	 
	 private OrderDataService orderDataService;
	 
	 private List<IDVO> list=new ArrayList<IDVO>();

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
    	driverMessagePO.setId(driverMessageVO.getId());
	orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
	String result=orderDataService.insert(driverMessagePO,10);
	return result;
}

    public DriverMessageVO find(String id){
    	orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
    	driverMessagePO=(DriverMessagePO) orderDataService.find(id, 10);
    	driverMessageVO.setDriverBirthday(driverMessagePO.getDriverBirthday());
    	driverMessageVO.setDriverId(driverMessagePO.getDriverId());
    	driverMessageVO.setDriverName(driverMessagePO.getDriverName());
    	driverMessageVO.setDriverNumber(driverMessagePO.getDriverNumber());
    	driverMessageVO.setDriverServiceDeadline(driverMessagePO.getDriverServiceDeadline());
    	driverMessageVO.setDriverSex(driverMessagePO.getDriverSex());
    	driverMessageVO.setDriverSex(driverMessagePO.getDriverTelephone());
    	driverMessageVO.setId(driverMessagePO.getId());
		return driverMessageVO;
    	
    }
/**
 * 修改物流数据库
 * 
 * @param list
 * @return
 */
   public String handleAllVO(List<IDVO> list){
	  for(IDVO temp:list){
		this.list.add(temp);
	 }
	  orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
	  String result=orderDataService.insertToDateFactory(this.list,10);
	  return result;
	
}

}
