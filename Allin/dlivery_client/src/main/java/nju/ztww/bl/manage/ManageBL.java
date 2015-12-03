package nju.ztww.bl.manage;

import java.rmi.RemoteException;
import java.util.ArrayList;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.bl.order.AcceptOrderBl;
import nju.ztww.bl.order.MailingOrderBl;
import nju.ztww.po.GeneratePO;
import nju.ztww.service.ManageDataService;
import nju.ztww.vo.GenerateVO;
import nju.ztww.vo.IDVO;

public class ManageBL {
	private RMIHelper rmi = new RMIHelper("localhost", "1010");
	private ManageDataService MDService;
	private AcceptOrderBl acceptOrderBl = new AcceptOrderBl();
	private MailingOrderBl mailingOrderBl = new MailingOrderBl();
	
	public ArrayList<GenerateVO> getCheckOrder(int index){
		ArrayList<GeneratePO> listPO;
		ArrayList<GenerateVO> listVO = new ArrayList<GenerateVO>();
		MDService = (ManageDataService)rmi.findService("ManageDataService");
		try {
			listPO = MDService.getCheckOrder(index);
			for(GeneratePO po : listPO){
				//String id,String state,String dealmen
				GenerateVO vo = new GenerateVO(po.getId(),"未审批",po.getDealmen());
				listVO.add(vo);
				
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listVO;
	}
	public void updateInfo(ArrayList<IDVO> list ,int index){
		/*
		 * 1->orderform;
		 * 2->reciveform;
		 */
		if(index==1){
			acceptOrderBl.passOrders(list);
			System.out.print("order get");
		}
		if(index==2){
			mailingOrderBl.passOrders(list);
		}
	}
}
