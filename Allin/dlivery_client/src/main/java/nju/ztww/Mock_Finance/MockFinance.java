package nju.ztww.Mock_Finance;

import nju.ztww.bl.finance.*;
import nju.ztww.vo.AccountVO;
import nju.ztww.vo.SalaryVO;

public class MockFinance extends FinanceBL{
	AccountVO account;	
	
	public  MockFinance(AccountVO account ){
		this.account = account;
	}
	
	public AccountVO getAccount(){
		return account;
	}
}
