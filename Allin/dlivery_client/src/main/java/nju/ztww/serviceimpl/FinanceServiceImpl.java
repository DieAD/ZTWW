package nju.ztww.serviceimpl;

import java.util.ArrayList;

import nju.ztww.bl.finance.FinanceBL;
import nju.ztww.dao.AccountDO;
import nju.ztww.dao.InsDO;
import nju.ztww.dao.StockDO;
import nju.ztww.dao.UserDO;
import nju.ztww.dao.matrixDO;
import nju.ztww.po.CarManagePO;
import nju.ztww.service.FinanceService;
import nju.ztww.vo.AccountVO;
import nju.ztww.vo.BenefitVO;
import nju.ztww.vo.CollectionVO;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.PCVO;
import nju.ztww.vo.PaymentVO;
import nju.ztww.vo.SalaryVO;

public class FinanceServiceImpl implements FinanceService {
	private FinanceBL financeBL = new FinanceBL();

	public AccountVO checkAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean setSalary(SalaryVO salary) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<OrderVO> viewList() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<CollectionVO> queryCollection(String querydate,
			String queryholl) {
		// TODO Auto-generated method stub
		return financeBL.queryCollection(querydate, queryholl);
	}

	public boolean addPaymentForm(ArrayList<PaymentVO> list) {
		// TODO Auto-generated method stub
		financeBL.addPaymentVO(list);
		return true;
	}

	public ArrayList<PaymentVO> queryPCP(String startTime, String endTime,
			String holl) {
		// TODO Auto-generated method stub
		return financeBL.queryPCP(startTime, endTime, holl);
	}

	public ArrayList<CollectionVO> queryPCC(String startTime, String endTime,
			String holl) {
		// TODO Auto-generated method stub
		return financeBL.queryPCC(startTime, endTime, holl);
	}

	public BenefitVO getBenefit() {
		// TODO Auto-generated method stub
		return financeBL.getTotalBenefit();
	}

	public void init(ArrayList<InsDO> list) {
		// TODO Auto-generated method stub
		financeBL.init(list);
	}

	public void initCar(ArrayList<CarManagePO> list) {
		// TODO Auto-generated method stub
		financeBL.initCar(list);
	}

	public void initStock(ArrayList<StockDO> list) {
		// TODO Auto-generated method stub
		financeBL.initStock(list);
	}

	public void initAccount(AccountDO account) {
		// TODO Auto-generated method stub
		financeBL.initAccount(account);
	}

	public ArrayList<AccountDO> getAllAccount() {
		// TODO Auto-generated method stub
		return financeBL.getAllAccount();
	}

	public void updateAccount(AccountDO account) {
		// TODO Auto-generated method stub
		financeBL.updateAccount(account);
	}

	public void initUser(ArrayList<UserDO> list) {
		// TODO Auto-generated method stub
		financeBL.initUser(list);
	}

	public void exportExcel(int index) {
		// TODO Auto-generated method stub
		financeBL.exportExcel(index);
	}

	public void insertM(matrixDO form) {
		// TODO Auto-generated method stub
		financeBL.insertM(form);
	}

	public ArrayList<matrixDO> queryM() {
		// TODO Auto-generated method stub
		return financeBL.queryM();
	}

}
