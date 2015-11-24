package nju.ztww.bl.order;

import java.util.ArrayList;
import java.util.List;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.BusinessArrivePO;
import nju.ztww.po.CarManagePO;
import nju.ztww.po.OrderPO;
import nju.ztww.service.OrderDataService;
import nju.ztww.vo.BusinessArriveVO;
import nju.ztww.vo.CarManageVO;

/**
 * 车辆管理BL层
 * 
 * @author TQ
 *
 */
public class CarManageBl {
	
	    //新的businessArrivePO
	    CarManagePO carManagePO=new CarManagePO(9);
		//ip地址
		 private String IP = "127.0.0.1";
		 private RMIHelper rhelper = new RMIHelper(IP,"1010");
		 
		 private OrderDataService orderDataService;
		 
		 private List<OrderPO> list=new ArrayList<OrderPO>();

	public CarManageBl() {
		
	}
	
	/**
	 * 将单据添加到临时数据库
	 * 
	 * @param businessArriveVO
	 * @return
	 */
	public String handleVO(CarManageVO carManageVO){
		carManagePO.setCarNumber(carManageVO.getCarNumber());
		carManagePO.setCarState(carManageVO.getCarState());
		carManagePO.setPlateNUmber(carManageVO.getPlateNUmber());
		carManagePO.setServiceTime(carManageVO.getServiceTime());
		
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		String result=orderDataService.insert(carManagePO,9);
		return result;
	}
	
	/**
	 * 修改物流数据库
	 * 
	 * @param list
	 * @return
	 */
	public String handleAllVO(List<CarManagePO> list){
		for(CarManagePO temp:list){
			this.list.add(temp);
		}
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		String result=orderDataService.insertToDateFactory(this.list,9);
		return result;
		
	}

}
