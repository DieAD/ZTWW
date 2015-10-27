package nju.ztww.service_stub;

import java.util.ArrayList;

import nju.ztww.service.FinanceService;
import nju.ztww.vo.AccountVO;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.SalaryVO;

public class FinanceService_stub implements FinanceService{

	public AccountVO checkAccount(String account) {
		// TODO Auto-generated method stub
		return new AccountVO(account, 0, account);
	}

	public boolean setSalary(SalaryVO salary) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<OrderVO> viewList() {
		// TODO Auto-generated method stub
		System.out.println("返回成功");
		return null;
	}
    
}
