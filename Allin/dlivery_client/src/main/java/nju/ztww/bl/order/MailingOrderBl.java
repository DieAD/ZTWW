package nju.ztww.bl.order;

/**
 * 寄件单的bl层
 * 
 * @author TQ
  */

import nju.ztww.po.MailingPO;
import nju.ztww.serviceimpl.OrderDataServiceImpl;
import nju.ztww.vo.MailingVO;

public class MailingOrderBl {
	//新的MainingPO
	MailingPO mailingPO=new MailingPO(1);
	//OrderDataService的引用
	OrderDataServiceImpl orderDataServiceImpl = new OrderDataServiceImpl();
	
	public MailingOrderBl(){
		
	}
	
	public void handleVO(MailingVO mailingVO){
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
	
		mailingPO.setBusinID(mailingVO.getBusinID());
		mailingPO.setSendOrga(mailingVO.getSendOrga());
		mailingPO.setSendTEL(mailingVO.getSendTEL());
		mailingPO.setTime(mailingVO.getTime());
		mailingPO.setState(mailingVO.getState());
		orderDataServiceImpl.insert(mailingPO);
	}

}
