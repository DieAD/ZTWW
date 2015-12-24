package nju.ztww.bl.order;

import java.util.ArrayList;
import java.util.List;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.CarManagePO;
import nju.ztww.po.OrderPO;
import nju.ztww.service.OrderDataService;
import nju.ztww.vo.CarManageVO;
import nju.ztww.vo.IDVO;

/**
 * 车辆管理BL层
 * 
 * @author TQ
 *
 */
public class CarManageBl {
	
	    //新的businessArrivePO
	    CarManagePO carManagePO=new CarManagePO(9);
	    
	    CarManageVO carManageVO=new CarManageVO(9);
		//ip地址
		 private String IP = "127.0.0.1";
		 private RMIHelper rhelper = new RMIHelper(IP,"1010");
		 
		 private OrderDataService orderDataService;
		 
		 private List<IDVO> list=new ArrayList<IDVO>();

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
		carManagePO.setId(carManageVO.getId());
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
	
		String result=orderDataService.insert(carManagePO,9);
		return result;
	}
	
	public CarManageVO find(String id){
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		carManagePO=(CarManagePO) orderDataService.find(id, 9);
		carManageVO.setCarNumber(carManagePO.getCarNumber());
		carManageVO.setCarState(carManagePO.getCarState());
		carManageVO.setPlateNUmber(carManagePO.getPlateNUmber());
		carManageVO.setServiceTime(carManagePO.getServiceTime());
		carManageVO.setId(carManagePO.getId());
		return carManageVO;
	}
	
	public ArrayList<CarManagePO> findAll(){
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		ArrayList<CarManagePO> list=orderDataService.findAll();
		return list;
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
		String result=orderDataService.insertToDateFactory(this.list, 9);
		return result;
		
	}

}
