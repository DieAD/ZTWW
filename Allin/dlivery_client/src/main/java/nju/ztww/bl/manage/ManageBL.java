package nju.ztww.bl.manage;

import java.rmi.RemoteException;
import java.util.ArrayList;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.bl.commodity.StorageListInAftercheckBL;
import nju.ztww.bl.commodity.StorageListOutAftercheckBL;
import nju.ztww.bl.order.AcceptOrderBl;
import nju.ztww.bl.order.BusinessArriveOrderBl;
import nju.ztww.bl.order.CenterReceiveOrderBl;
import nju.ztww.bl.order.LoadingOrderBl;
import nju.ztww.bl.order.MailingOrderBl;
import nju.ztww.bl.order.ReceiveOrderBl;
import nju.ztww.bl.order.SendOrderBl;
import nju.ztww.bl.order.TransferOrderBl;
import nju.ztww.po.GeneratePO;
import nju.ztww.service.ManageDataService;
import nju.ztww.vo.GenerateVO;
import nju.ztww.vo.IDVO;
///
public class ManageBL {
	private RMIHelper rmi = new RMIHelper("localhost", "1010");
	private ManageDataService MDService;
	private AcceptOrderBl acceptOrderBl = new AcceptOrderBl();
	private MailingOrderBl mailingOrderBl = new MailingOrderBl();
	private  StorageListInAftercheckBL inStock = new  StorageListInAftercheckBL();
	private  StorageListOutAftercheckBL outStock = new StorageListOutAftercheckBL();
	private BusinessArriveOrderBl hollrecive =  new BusinessArriveOrderBl();
	private LoadingOrderBl loadBl = new LoadingOrderBl();
	private ReceiveOrderBl payeeBL = new ReceiveOrderBl();
	private SendOrderBl senderBL = new SendOrderBl();
	private  CenterReceiveOrderBl centerReciveBL = new  CenterReceiveOrderBl();
	private TransferOrderBl transBL = new TransferOrderBl();
	
	
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
			//	
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
		 * 2->loadform
		 * 3->hollrecive
		 * 4->payeeform;
		 * 5->deliveryform;
		 * 6->centerreciveform;
		 * 
		 * 7->loadstockform;
		 * 8->transform;
		 * 
		 * 9->outStockForm;
		 * 10->paymentform;
		 */
		if(index==1){
			mailingOrderBl.passOrders(list);
			System.out.print("order get");
		}
		if(index==2){		
			loadBl.handleAllVO(list);
		}
		if(index==3){
			hollrecive.handleAllVO(list);
		}
		if(index==4){
			payeeBL.handleAllVO(list);
		}
		if(index==5){
			senderBL.handleAllVO(list);
		}
		if(index==6){
			centerReciveBL.handleAllVO(list);
		}
		if(index==7){
			inStock.changeExeAddStock(list);
		}
		if(index==8){
			transBL.handleAllVO(list);
		}
		if(index==9){
			outStock.changeExeDeleteStock(list);
		}////
		if(index==10){
			
		}
		
	}
	
}
