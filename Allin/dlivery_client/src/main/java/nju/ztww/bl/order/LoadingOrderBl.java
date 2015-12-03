package nju.ztww.bl.order;


import java.util.ArrayList;
import java.util.List;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.LoadingPO;
import nju.ztww.po.OrderPO;
import nju.ztww.service.OrderDataService;
import nju.ztww.vo.IDVO;
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
	   
	   LoadingVO loadingVO=new LoadingVO(4);
		
		 private String IP = "127.0.0.1";
		 private RMIHelper rhelper = new RMIHelper(IP,"1010");
		 
		 private OrderDataService orderDataService;
		 
		 private List<IDVO> list=new ArrayList<IDVO>();
		
		public LoadingOrderBl(){
			
		}
		
		public String handleVO(LoadingVO loadingVO){
			loadingPO.setArrive(loadingVO.getArrive());
			loadingPO.setCarNumber(loadingVO.getCarNumber());
			loadingPO.setData(loadingVO.getData());
			loadingPO.setJianZhuangName(loadingVO.getJianZhuangName());
			loadingPO.setMoney(loadingVO.getMoney());
			loadingPO.setOrderNumber(loadingVO.getOrderNumber());
			loadingPO.setQiYunNumber(loadingVO.getQiYunNumber());
			loadingPO.setYaYunName(loadingVO.getYaYunName());
			loadingPO.setYingYeNumber(loadingVO.getYingYeNumber());
			loadingPO.setId(loadingVO.getId());
			orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
			String result=orderDataService.insert(loadingPO,4);
			return result;
		}
		
		public LoadingVO find(String id){
			orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
			loadingPO=(LoadingPO) orderDataService.find(id, 4);
			loadingVO.setArrive(loadingPO.getArrive());
			loadingVO.setCarNumber(loadingPO.getCarNumber());
			loadingVO.setData(loadingPO.getData());
			loadingVO.setJianZhuangName(loadingPO.getJianZhuangName());
			loadingVO.setMoney(loadingPO.getMoney());
			loadingVO.setOrderNumber(loadingPO.getOrderNumber());
			loadingVO.setQiYunNumber(loadingPO.getQiYunNumber());
			loadingVO.setYaYunName(loadingPO.getYaYunName());
			loadingVO.setYingYeNumber(loadingPO.getYingYeNumber());
			loadingVO.setId(loadingPO.getId());
			return loadingVO;
			
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
			 String result=orderDataService.insertToDateFactory(this.list,4);
			return result;
			
		}

}
