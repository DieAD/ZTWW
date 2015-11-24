package nju.ztww.bl.order;

/**
 * 寄件单的bl层
 * 
 * @author TQ
  */

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.MailingPO;
import nju.ztww.service.OrderDataService;
import nju.ztww.vo.MailingVO;

public class MailingOrderBl {
	//新的MainingPO
	MailingPO mailingPO=new MailingPO(1);

	
	 private String IP = "127.0.0.1";
	 private RMIHelper rhelper = new RMIHelper(IP,"1010");
	 
	 private OrderDataService orderDataService;
	
	public MailingOrderBl(){
		
	}
	
	public String handleVO(MailingVO mailingVO){
		mailingPO.setSendName(mailingVO.getSendName());
		mailingPO.setSendLocation(mailingVO.getSendLocation());
		mailingPO.setSendTelephone(mailingVO.getSendTelephone());
		mailingPO.setReceiveName(mailingVO.getReceiveName());
		mailingPO.setReceiveLocation(mailingVO.getReceiveLocation());
		mailingPO.setReceiveTelephone(mailingVO.getReceiveTelephone());
		mailingPO.setInfortation(mailingVO.getInfortation());
		mailingPO.setMethod(mailingVO.getMethod());
		mailingPO.setCount(mailingVO.getCount());
		mailingPO.setStripNumber(mailingVO.getStripNumber());
		
		orderDataService=(OrderDataService)rhelper.findService("OrderDataService");
		String result=orderDataService.insert(mailingPO,1);
		return result;
	}

}
