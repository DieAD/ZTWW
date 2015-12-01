package nju.ztww.bl.finance;

import java.rmi.RemoteException;
import java.util.ArrayList;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.CollectionPO;
import nju.ztww.po.PaymentPO;
import nju.ztww.service.FinanceDataService;
import nju.ztww.vo.CollectionVO;
import nju.ztww.vo.PaymentVO;

public class FinanceBL {
	private RMIHelper rmi = new RMIHelper("localhost", "1010");
	private FinanceDataService financeDataService;

	public double getFund(double fund) {

		return 0;
	}

	public ArrayList<CollectionVO> queryCollection(String querydate,
			String queryholl) {
		ArrayList<CollectionVO> listVO = new ArrayList<CollectionVO>();
		ArrayList<CollectionPO> listPO = new ArrayList<CollectionPO>();
		financeDataService = (FinanceDataService) rmi
				.findService("FinanceDataService");
		try {
			listPO = financeDataService.queryCollection(querydate, queryholl);
			for (CollectionPO collection : listPO) {
				// String date,double money,String courierid,String orderid
				CollectionVO vo = new CollectionVO(collection.getDate(),
						collection.getMoney(), collection.getCourierid(),
						collection.getGoodsid());
				listVO.add(vo);
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listVO;
	}
	
	public boolean addPaymentVO(ArrayList<PaymentVO> list){
		ArrayList<PaymentVO> listVO = list;
		ArrayList<PaymentPO> listPO = new ArrayList<PaymentPO>();
		for(PaymentVO vo : listVO){
			PaymentPO po = new PaymentPO();
			po.setDate(vo.date);
			po.setMoney(vo.money);
			po.setPaymen(vo.paymen);
			po.setPayaccount(vo.payaccount);
			po.setPaycat(vo.paycat);
			po.setPs(vo.ps);
			
			listPO.add(po);
		}
		financeDataService = (FinanceDataService) rmi
				.findService("FinanceDataService");
		
	   financeDataService.addPaymentForm(listPO);
		return true;
	}
}
