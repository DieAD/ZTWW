package nju.ztww.serviceimpl;

import java.util.ArrayList;

import nju.ztww.bl.finance.FinanceBL;
import nju.ztww.service.FinanceService;
import nju.ztww.vo.AccountVO;
import nju.ztww.vo.CollectionVO;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.PaymentVO;
import nju.ztww.vo.SalaryVO;

public class FinanceServiceImpl implements FinanceService{
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

	public ArrayList<CollectionVO> queryCollection(String querydate, String queryholl) {
		// TODO Auto-generated method stub
		return financeBL.queryCollection(querydate, queryholl);
	}

	public boolean addPaymentForm(ArrayList<PaymentVO> list) {
		// TODO Auto-generated method stub
		financeBL.addPaymentVO(list);
		return true;
	}

}
