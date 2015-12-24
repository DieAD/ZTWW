package nju.ztww.bl.finance;

import java.rmi.RemoteException;
import java.util.ArrayList;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.dao.AccountDO;
import nju.ztww.dao.InsDO;
import nju.ztww.dao.StockDO;
import nju.ztww.dao.UserDO;
import nju.ztww.dao.matrixDO;
import nju.ztww.po.CarManagePO;
import nju.ztww.po.CollectionPO;
import nju.ztww.po.PaymentPO;
import nju.ztww.service.FinanceDataService;
import nju.ztww.vo.BenefitVO;
import nju.ztww.vo.CollectionVO;
import nju.ztww.vo.IDVO;
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
	
	public ArrayList<PaymentVO> queryPCP(String beginTime,String endTime,String holl){
		ArrayList<PaymentVO> listVO = new ArrayList<PaymentVO>();
		ArrayList<PaymentPO> listPO = new ArrayList<PaymentPO>();
		financeDataService = (FinanceDataService) rmi
				.findService("FinanceDataService");
		try {
			 listPO = financeDataService.queryPCP(beginTime, endTime, holl);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(PaymentPO po : listPO){
			//String date,double money,String paymen,String payaccount,String paycat,String ps
			PaymentVO vo = new PaymentVO(po.getDate(),po.getMoney(),po.getPaymen(),po.getPayaccount(),po.getPaycat(),po.getPs());
			listVO.add(vo);
		}
		return listVO;
	
		
	}
	
	public ArrayList<CollectionVO> queryPCC(String beginTime,String endTime,String holl){
		ArrayList<CollectionPO> listPO  = new ArrayList<CollectionPO>();
		ArrayList<CollectionVO> listVO  = new ArrayList<CollectionVO>();
		financeDataService = (FinanceDataService) rmi
				.findService("FinanceDataService");
		try {
			listPO = financeDataService.queryPCC(beginTime, endTime, holl);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(CollectionPO po : listPO){
			// String date,double money,String courierid,String orderid
			CollectionVO vo= new CollectionVO(po.getDate(),po.getMoney(),po.getCourierid(),po.getGoodsid());
			listVO.add(vo);
			
		}
  		return listVO;
		
	}
	
	public BenefitVO getTotalBenefit(){
		ArrayList<CollectionPO> listPO1 = null;
		ArrayList<PaymentPO>    listPO2 = null;
		double totalCollection = 0;
		double totalPayment = 0;
		double totalBenefit = 0;
		financeDataService = (FinanceDataService) rmi
				.findService("FinanceDataService");
		try {
			listPO1 =  financeDataService.totalCollection();
			listPO2 =  financeDataService.totalPayment();
			for(CollectionPO po : listPO1){
				totalCollection += po.getMoney();
			}
			for(PaymentPO po: listPO2){
				totalPayment += po.getMoney();
			}
			totalBenefit = totalCollection - totalPayment;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BenefitVO benefitVO = new BenefitVO(totalCollection,totalPayment,totalBenefit);
		
		return benefitVO;
	}
	
	public void UpdateTrace(ArrayList<IDVO> list){
		
	}
	
	public void init(ArrayList<InsDO> list){
		financeDataService = (FinanceDataService) rmi
				.findService("FinanceDataService");
		try {
			financeDataService.init(list);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initCar(ArrayList<CarManagePO> listPO){
		financeDataService = (FinanceDataService) rmi
				.findService("FinanceDataService");
		
		try {
			financeDataService.initCar(listPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initStock(ArrayList<StockDO> list){
		financeDataService = (FinanceDataService) rmi
				.findService("FinanceDataService");
		try {
			financeDataService.initStock(list);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initAccount(AccountDO account){
		financeDataService = (FinanceDataService) rmi
				.findService("FinanceDataService");
		try {
			financeDataService.initAccount(account);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<AccountDO> getAllAccount(){
		financeDataService = (FinanceDataService) rmi
				.findService("FinanceDataService");
		
		ArrayList<AccountDO> list = new ArrayList<AccountDO>();
		try {
			list = financeDataService.selectAllAccount();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void updateAccount(AccountDO account){
		financeDataService = (FinanceDataService) rmi
				.findService("FinanceDataService");
		try {
			financeDataService.updateAccount(account);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initUser(ArrayList<UserDO> list){
		financeDataService = (FinanceDataService) rmi
				.findService("FinanceDataService");
		try {
			financeDataService.initUser(list);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void exportExcel(int index){
	  ExcelHelper myHelper = new ExcelHelper();
	  if(index==1){
		  myHelper.CollectionToExcel();
		  myHelper.PaymentToExcel();
	  }
	}
	public void insertM(matrixDO form){
		financeDataService = (FinanceDataService) rmi
				.findService("FinanceDataService");
		try {
			financeDataService.insertM(form);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<matrixDO> queryM(){
		ArrayList<matrixDO> list = new ArrayList<matrixDO>();
		financeDataService = (FinanceDataService) rmi
				.findService("FinanceDataService");
		try {
			list = financeDataService.queryM();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
